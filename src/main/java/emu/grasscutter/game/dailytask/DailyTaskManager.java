package emu.grasscutter.game.dailytask;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.DailyTaskData;
import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.game.dailytask.enums.DailyTaskFinishType;
import emu.grasscutter.game.dailytask.enums.DailyTaskType;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.player.*;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.game.quest.enums.LogicType;
import emu.grasscutter.game.quest.enums.QuestCond;
import emu.grasscutter.game.quest.enums.QuestState;
import emu.grasscutter.net.proto.RetcodeOuterClass.Retcode;
import emu.grasscutter.server.packet.send.PacketWorldOwnerDailyTaskNotify;
import emu.grasscutter.utils.Utils;
import emu.grasscutter.server.packet.send.PacketDailyTaskDataNotify;
import emu.grasscutter.server.packet.send.PacketDailyTaskScoreRewardNotify;
import emu.grasscutter.server.packet.send.PacketDailyTaskUnlockedCitiesNotify;
import emu.grasscutter.server.packet.send.PacketTaskVarNotify;

import java.util.*;

import org.bson.types.ObjectId;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Indexed;
import dev.morphia.annotations.Transient;
import lombok.*;

@Entity(value = "dailytasks", useDiscriminator = false)
public class DailyTaskManager extends BasePlayerManager {
    @Transient @Getter private Player player;

    @Id private ObjectId id;
    @Indexed @Getter private int ownerUid;

    @Getter private int refreshTimes;
    @Getter private int filterCityId;
    @Getter private int randomCityId;
    @Getter private List<Integer> unlockedCities;
    @Getter private Map<Integer, DailyTask> playerDailyTask;

    @Getter private int finishedNum;
    @Getter private int scorePreviewRewardId;
    @Getter private int scoreDropId;
    @Getter private boolean isScoreRewardTaken;

    private Set<Integer> surePool;
    private LinkedList<Set<Integer>> possiblePool;
    private Map<Integer, Integer> cycleQuestCountMap;
    private List<Set<Integer>> excludeTagVec;

    @Transient private Map<Integer, List<Integer>> poolTaskVecMap;
    @Transient private Map<Integer, List<Integer>> cityPoolVecMap;

    // TODO these values should be loaded from ConstValueExcelConfig
    public static final int DAILY_TASK_NUM = 4;
    public static final int DAILY_TASK_FINISH_NUM = 4;
    public static final int DAILY_TASK_REWARD_MAX_NUM = 4;
    public static final int DAILY_TASK_POSSIBLE_POOL_NUM = 5;
    public static final int DAILY_TASK_VAR_NUM = 5;
    public static final int DAILY_TASK_REWARD_TALK = 2010137;
    public static final float DAILY_TASK_RELATED_TAG_EFFECT_PROB = 0.15f;
    public static final List<List<Integer>> DAILY_TASK_REFRESH_TIMES_POOL_VEC = List.of(List.of(10106, 10107, 10204, 21700));

    public DailyTaskManager(Player player) {
        super(player);

        this.player = player;
        this.ownerUid = player.getUid();
        this.refreshTimes = 0;
        this.filterCityId = 0;
        this.randomCityId = 0;
        this.unlockedCities = new ArrayList<>();
        this.playerDailyTask = new HashMap<>();

        this.finishedNum = 0;
        this.scorePreviewRewardId = 0;
        this.scoreDropId = 0;
        this.isScoreRewardTaken = false;

        this.surePool = new HashSet<>();
        this.possiblePool = new LinkedList<>();
        this.cycleQuestCountMap = new HashMap<>();
        this.excludeTagVec = new ArrayList<>();

        this.init();

        this.save();
    }

    public static DailyTaskManager getByPlayer(Player player) {
        var dailyTaskManager = DatabaseHelper.getDailyTasksByUid(player.getUid());
        if(dailyTaskManager != null) {
            dailyTaskManager.setPlayer(player);
            dailyTaskManager.getPlayerDailyTask().forEach((i, t) -> {
                t.setOwner(player);
                t.setConfig(GameData.getDailyTaskDataMap().get(i.intValue()));
            });
            dailyTaskManager.init();
            return dailyTaskManager;
        }

        return new DailyTaskManager(player);
    }

    public void setPlayer(Player player) {
        if(player == null || this.ownerUid != player.getUid()) return;
        this.player = player;
    }

    public void init() {
        this.poolTaskVecMap = new HashMap<>();
        this.cityPoolVecMap = new HashMap<>();

        GameData.getDailyTaskDataMap().forEach((k, v) -> {
            int cityId = v.getCityId();
            int poolId = v.getPoolId();

            if(!poolTaskVecMap.containsKey(poolId)) poolTaskVecMap.put(poolId, new ArrayList<>());
            if(!cityPoolVecMap.containsKey(cityId)) cityPoolVecMap.put(cityId, new ArrayList<>());
            var taskVec = poolTaskVecMap.get(poolId);
            var poolVec = cityPoolVecMap.get(cityId);
            if(!taskVec.contains(k)) taskVec.add(k);
            if(!poolVec.contains(poolId)) poolVec.add(poolId);
        });
    }

    public void onPlayerLogin() {
        this.refreshUnlockedCities();
        this.notifyAllData();
    }

    public void onFinishQuest(int questId) {
        for(var i : GameData.getCityTaskOpenDataMap().values()) {
            if(questId == i.getQuestId()) {
                this.refreshUnlockedCities();
                if(this.playerDailyTask.isEmpty())
                    this.resetDailyTasks();
                break;
            }
        }
    }

    public void onFinishTalk(int talkId) {
        if(talkId == DAILY_TASK_REWARD_TALK)
            this.claimScoreReward();
    }

    public Retcode handleFilterCityReq(int cityId) {
        if(cityId == this.filterCityId) return Retcode.RET_SUCC;
        if(cityId == 0) {
            this.filterCityId = cityId;
            this.save();
            return Retcode.RET_SUCC;
        }

        var cityConfig = GameData.getCityTaskOpenDataMap().get(cityId);
        if(cityConfig == null) return Retcode.RET_NOT_FOUND_CONFIG;

        var quest = this.player.getQuestManager().getQuestById(cityConfig.getQuestId());
        if(quest != null && quest.state == QuestState.QUEST_STATE_FINISHED) {
            this.filterCityId = cityId;
            this.save();
            return Retcode.RET_SUCC;
        }
        return Retcode.RET_DAILY_TASK_FILTER_CITY_NOT_OPEN;
    }

    public void refreshUnlockedCities() {
        this.unlockedCities.clear();
        for(var i : GameData.getCityTaskOpenDataMap().values()) {
            var quest = this.player.getQuestManager().getQuestById(i.getQuestId());
            if(quest != null && quest.state == QuestState.QUEST_STATE_FINISHED)
                this.unlockedCities.add(i.getCityId());
        }

        this.save();

        this.player.sendPacket(new PacketDailyTaskUnlockedCitiesNotify(unlockedCities));
    }

    public boolean isMeetExcludeQuestNpc(DailyTaskData dailyTaskData) {
        if(dailyTaskData.getType() == DailyTaskType.DAILY_TASK_QUEST) {
            int questId = dailyTaskData.getQuestId();
            var npcList = GameData.getQuestDataMap().get(questId).getExclusiveNpcList();
            if(npcList != null) {
                for(int npcId : npcList) {
                    if(this.player.getQuestManager().isNpcOccupied(npcId, questId)) return false;
                }
            }
        }
        return true;
    }

    public boolean isMeetExcludeTag(DailyTaskData dailyTaskData) {
        var tagVec = dailyTaskData.getTagVec();
        for(int i = 0; i < tagVec.size(); i++) {
            int tag = tagVec.get(i);
            if(tag != 0 && i < excludeTagVec.size()) {
                if(excludeTagVec.get(i).contains(tag))
                    return false;
            }
        }
        return true;
    }

    public boolean isDailyTaskSatisfied(DailyTaskData dailyTaskData) {
        if(!this.isMeetExcludeTag(dailyTaskData)) return false;
        if(!this.isMeetExcludeQuestNpc(dailyTaskData)) return false;

        var dailyTaskSystem = this.player.getServer().getDailyTaskSystem();
        var satisfiedCond = dailyTaskData.getSatisfiedCond();
        if(satisfiedCond == null || satisfiedCond.size() == 0) return true;

        int[] satisfiedProgress = new int[satisfiedCond.size()];
        for(int i = 0; i < satisfiedCond.size(); i++) {
            satisfiedProgress[i] = dailyTaskSystem.triggerSatisfiedCond(player, satisfiedCond.get(i)) ? 1 : 0;
        }
        if(LogicType.calculate(dailyTaskData.getSatisfiedCondComb(), satisfiedProgress)) return true;
        return false;
    }

    public void addDailyTask(int taskId) {
        // Add given task
        var data = GameData.getDailyTaskDataMap().get(taskId);
        this.playerDailyTask.put(taskId, new DailyTask(data, player));

        // Add tags to excluded tags list
        int tagIndex = 0;
        for(int tag : data.getTagVec()) {
            // Skip invalid tags
            if(tag == 0) continue;

            if(this.excludeTagVec.size() <= tagIndex) this.excludeTagVec.add(new HashSet<>());
            this.excludeTagVec.get(tagIndex).add(tag);
            tagIndex++;
        }

        this.save();
    }

    public void addToSurePool(int taskId) {
        if(!GameData.getDailyTaskDataMap().containsKey(taskId)) return;

        this.surePool.add(taskId);
        this.save();
    }

    public void addToPossiblePool(int taskId, int nextDays) {
        if(!GameData.getDailyTaskDataMap().containsKey(taskId)) return;
        if(nextDays >= DAILY_TASK_POSSIBLE_POOL_NUM) {
            Grasscutter.getLogger().debug("addToPossiblePool: nextDays ({}) is greater than possible pool num ({})",
                    nextDays,
                    DAILY_TASK_POSSIBLE_POOL_NUM);
            
            nextDays = DAILY_TASK_POSSIBLE_POOL_NUM - 1;
        }
        
        while(this.possiblePool.size() <= nextDays) possiblePool.add(new HashSet<>());
        this.possiblePool.get(nextDays).add(taskId);
        this.save();
    }

    public void resetDailyTasks() {
        // Check if daily task system is unlocked
        if(this.unlockedCities.isEmpty()) return;

        this.playerDailyTask.forEach((i, t) -> {
            var dailyTaskData = t.getDailyTaskData();

            // Reset expired daily tasks
            resetDailyTask(dailyTaskData);
            
            if(t.isFinished() && dailyTaskData.getType() == DailyTaskType.DAILY_TASK_QUEST) {
                // Increment counter for finished tasks
                int taskId = dailyTaskData.getId();
                this.cycleQuestCountMap.put(taskId, cycleQuestCountMap.getOrDefault(taskId, 0) + 1);
            }
        });

        // Set score reward by player level
        int level = this.player.getLevel();
        for(var i : GameData.getDailyTaskLevelDataMap().int2ObjectEntrySet()) {
            var levelData = i.getValue();
            if(level >= levelData.getMinPlayerLevel() && level <= levelData.getMaxPlayerLevel()) {
                this.scoreDropId = levelData.getScoreDropId();
                this.scorePreviewRewardId = levelData.getScorePreviewRewardId();
                break;
            }
        }
        
        this.isScoreRewardTaken = false;
        this.finishedNum = 0;

        // Generate new daily tasks
        this.playerDailyTask.clear();
        this.excludeTagVec.clear();

        // Add from refresh times pool. This has the highest priority.
        if(refreshTimes < DAILY_TASK_REFRESH_TIMES_POOL_VEC.size()) {
            for(int t : DAILY_TASK_REFRESH_TIMES_POOL_VEC.get(refreshTimes)) {
                if(playerDailyTask.size() >= DAILY_TASK_NUM) break;
                addDailyTask(t);
            }
        }

        // Add from sure pool
        if(playerDailyTask.size() < DAILY_TASK_NUM && !surePool.isEmpty()) {
            var t = surePool.iterator();
            while(t.hasNext()) {
                int taskId = t.next();
                var data = GameData.getDailyTaskDataMap().get(taskId);
                if(playerDailyTask.size() < DAILY_TASK_NUM
                    && !playerDailyTask.containsKey(taskId)
                    && isMeetExcludeTag(data)
                    && isMeetExcludeQuestNpc(data)) {
                        addDailyTask(taskId);
                        t.remove();
                }
            }
        }

        // Add from possible pool
        if(playerDailyTask.size() < DAILY_TASK_NUM && !possiblePool.isEmpty()) {
            var poolSet = possiblePool.pop();
            if(!poolSet.isEmpty()) {
                // Filter acceptable tasks and sort by poolId
                Map<Integer, List<Integer>> acceptableTasks = new HashMap<>();
                for(int p : poolSet) {
                    var data = GameData.getDailyTaskDataMap().get(p);
                    if(!playerDailyTask.containsKey(p)
                        && isMeetExcludeTag(data)
                        && isMeetExcludeQuestNpc(data)) {
                            var pool = acceptableTasks.get(data.getPoolId());
                            if(pool == null) {
                                pool = new ArrayList<>();
                                acceptableTasks.put(data.getPoolId(), pool);
                            }
                            pool.add(p);
                    }
                }

                // Choose one task from each pool
                for(var t : acceptableTasks.entrySet()) {
                    var taskVec = t.getValue();
                    addDailyTask(taskVec.get(Utils.randomRange(0, taskVec.size() - 1)));
                    if(playerDailyTask.size() >= DAILY_TASK_NUM) break;
                }
            }
        }

        // Add from common pool
        if(playerDailyTask.size() < DAILY_TASK_NUM) {
            int remainingNum = DAILY_TASK_NUM - playerDailyTask.size();
            // Choose a city
            randomCityId = filterCityId != 0 ?
                    filterCityId :
                    this.unlockedCities.get(Utils.randomRange(0, unlockedCities.size() - 1));
            
            // Select random pools
            List<Integer> poolList = new ArrayList<>(this.cityPoolVecMap.get(randomCityId));
            Collections.shuffle(poolList, Utils.random);
            if(remainingNum < poolList.size()) poolList = poolList.subList(0, remainingNum);

            // Choose one task from each pool
            List<Integer> acceptableTasks = new ArrayList<>();
            List<Integer> relatedTagTasks = new ArrayList<>();
            List<Integer> weights = new ArrayList<>();
            int preChooseTaskRelatedTag = 0;
            for(int poolId : poolList) {
                acceptableTasks.clear();
                relatedTagTasks.clear();
                for(int taskId : this.poolTaskVecMap.get(poolId)) {
                    var data = GameData.getDailyTaskDataMap().get(taskId);
                    if(!playerDailyTask.containsKey(taskId)
                        && data.getWeight() != 0
                        && (data.getType() != DailyTaskType.DAILY_TASK_QUEST
                            || this.cycleQuestCountMap.getOrDefault(taskId, 0) < data.getTaskCycleRefreshTimes())
                        && this.isDailyTaskSatisfied(data)) {
                            acceptableTasks.add(taskId);
                            int taskRelatedTag = data.getRelatedTag();
                            if(taskRelatedTag != 0 && preChooseTaskRelatedTag == taskRelatedTag)
                                relatedTagTasks.add(taskId);
                    }
                }

                if(!relatedTagTasks.isEmpty()
                    && Utils.randomFloatRange(0f, 1f) < DAILY_TASK_RELATED_TAG_EFFECT_PROB) {
                        acceptableTasks.clear();
                        acceptableTasks.addAll(relatedTagTasks);
                }

                if(acceptableTasks.isEmpty()) {
                    // No satisfied tasks in this pool, use backup pool instead
                    var backupPoolVec = GameData.getCityTaskOpenDataMap().get(randomCityId).getBackupVec();
                    for(int taskId : backupPoolVec) {
                        if(!playerDailyTask.containsKey(taskId)) {
                            addDailyTask(taskId);
                            break;
                        }
                    }

                    // Reset counter for this pool
                    for(int taskId : this.poolTaskVecMap.get(poolId)) {
                        this.cycleQuestCountMap.remove(taskId);
                    }
                } else {
                    // Select one task from satisfied tasks by weight
                    int selected = 0;
                    int sumWeight = 0;
                    weights.clear();
                    for(int taskId : acceptableTasks) {
                        int weight = GameData.getDailyTaskDataMap().get(taskId).getWeight();
                        weights.add(weight);
                        sumWeight += weight;
                    }

                    int randWeight = Utils.randomRange(0, sumWeight);
                    for(int i = 0; i < acceptableTasks.size(); i++) {
                        randWeight -= weights.get(i);
                        if(randWeight < 0) {
                            selected = i;
                            break;
                        }
                    }

                    int selectedTask = acceptableTasks.get(selected);
                    addDailyTask(selectedTask);
                    int taskRelatedTag = GameData.getDailyTaskDataMap().get(selectedTask).getRelatedTag();
                    if(preChooseTaskRelatedTag == 0 && taskRelatedTag != 0) preChooseTaskRelatedTag = taskRelatedTag;
                }
            }
        }

        this.refreshTimes++;

        this.save();

        // Start possible quests
        this.playerDailyTask.forEach(
            (i, t) -> {
                int dailyTaskId = t.getDailyTaskData().getId();
                player.getQuestManager().queueEvent(QuestCond.QUEST_COND_DAILY_TASK_START, dailyTaskId, 0);
            }
        );

        this.notifyAllData();

        // Broadcast the new daily task list to all players if this is the world owner
        if(this.player.getWorld().getHost().equals(this.player))
            this.player.getWorld().getPlayers().forEach(p -> this.requestDailyTaskData(p));
    }

    public void resetDailyTask(DailyTaskData dailyTask) {
        dailyTask.getNewGroupVec().forEach(
            v -> {
                if(this.player.getWorld().getHost().equals(this.player)) {
                    var scene = this.player.getWorld().getSceneById(3);
                    if(scene != null && scene.unregisterDynamicGroup(v)) return;
                }

                // load group instance from database directly in case player is not world owner or failed to unregister group
                var instance = DatabaseHelper.loadGroupInstance(v, this.player);
                if(instance != null) {
                    // reset dynamic group data
                    instance.setTargetSuiteId(0);
                    instance.setActiveSuiteId(0);
                    instance.getDeadEntities().clear();
                    instance.getCachedGadgetStates().clear();
                    instance.getCachedVariables().clear();

                    // save
                    instance.setCached(true);
                }
            }
        );

        // cancel related quests
        if(dailyTask.getType() == DailyTaskType.DAILY_TASK_QUEST) {
            var quest = this.player.getQuestManager().getQuestById(dailyTask.getQuestId());
            if(quest != null)
                quest.getMainQuest().cancel();
        }
    }

    public void notifyAllData() {
        this.player.sendPacket(new PacketDailyTaskDataNotify(this));
        this.player.sendPacket(new PacketTaskVarNotify(player));
    }

    public void requestDailyTaskData(Player target) {
        target.sendPacket(new PacketWorldOwnerDailyTaskNotify(this));

        // load dynamic groups in case it's a new world
        new Thread(this::loadGroups).start();
    }

    private void loadGroups() {
        var scene = this.player.getWorld().getSceneById(3);
        if(scene == null) return;

        // Wait for scene script manager to init
        boolean timeOut = true;
        for(int i = 0; i < 10; i++) {
            var scriptManager = scene.getScriptManager();
            if(scriptManager != null && scriptManager.isInit()) {
                timeOut = false;
                break;
            }
            Utils.sleep(100);
        }

        if(timeOut) {
            Grasscutter.getLogger().warn("scene script manager timed out on init. daily task groups are not loaded");
            return;
        }

        for(var task : this.playerDailyTask.values()) {
            for(int groupId : task.getDailyTaskData().getNewGroupVec()) {
                scene.loadDynamicGroup(groupId);
            }
        }
    }

    public void triggerDailyTaskVarAction(int dailyTaskId) {
        var questManager = player.getQuestManager();
        questManager.queueEvent(QuestCond.QUEST_COND_DAILY_TASK_VAR_EQ, dailyTaskId);
        questManager.queueEvent(QuestCond.QUEST_COND_DAILY_TASK_VAR_GT, dailyTaskId);
        questManager.queueEvent(QuestCond.QUEST_COND_DAILY_TASK_VAR_LT, dailyTaskId);

        this.player.sendPacket(new PacketTaskVarNotify(player, dailyTaskId));
    }

    public boolean triggerEvent(DailyTaskFinishType type, int... params) {
        for(var i : this.playerDailyTask.entrySet()) {
            DailyTask t = i.getValue();
            if(t.getDailyTaskData().getType() == DailyTaskType.DAILY_TASK_QUEST) continue;
            if(t.getDailyTaskData().getFinishType() == type) {
                if (t.handleEvent(params)) {
                    this.save();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean triggerEvent(int... params) {
        if(params[1] != 0) return false;
        for(var i : this.playerDailyTask.entrySet()) {
            DailyTask t = i.getValue();
            if(t.getDailyTaskData().getType() == DailyTaskType.DAILY_TASK_SCENE) continue;
            if(t.getDailyTaskData().getId() == params[0]) {
                t.addProgress();
                this.save();
                return true;
            }
        }
        return false;
    }

    public int getDailyTaskVarValue(int dailyTaskId, int index) {
        if(index >= DAILY_TASK_VAR_NUM) return 0;

        var dailyTaskIdVariables = this.player.getDailyTaskVariables().get(dailyTaskId);
        if(dailyTaskIdVariables == null) {
            dailyTaskIdVariables = new Integer[DAILY_TASK_VAR_NUM];
            Arrays.fill(dailyTaskIdVariables, Integer.valueOf(0));
            this.player.getDailyTaskVariables().put(dailyTaskId, dailyTaskIdVariables);
            player.save();
        }
        return dailyTaskIdVariables[index];
    }

    public void setDailyTaskVarValue(int dailyTaskId, int index, int value) {
        if(index >= DAILY_TASK_VAR_NUM) {
            Grasscutter.getLogger().debug("Failed to set daily task var for task {}. Index ({}) too large", dailyTaskId, index);
            return;
        }

        var dailyTaskIdVariables = this.player.getDailyTaskVariables().get(dailyTaskId);
        if(dailyTaskIdVariables == null) {
            dailyTaskIdVariables = new Integer[DAILY_TASK_VAR_NUM];
            Arrays.fill(dailyTaskIdVariables, Integer.valueOf(0));
            this.player.getDailyTaskVariables().put(dailyTaskId, dailyTaskIdVariables);
        }
        dailyTaskIdVariables[index] = value;
        player.save();

        this.triggerDailyTaskVarAction(dailyTaskId);
    }

    public void incDailyTaskVarValue(int dailyTaskId, int index, int inc) {
        if(index >= DAILY_TASK_VAR_NUM) {
            Grasscutter.getLogger().debug("Failed to inc daily task var for task {}. Index ({}) too large", dailyTaskId, index);
            return;
        }

        int prevVal = this.getDailyTaskVarValue(dailyTaskId, index);
        this.player.getDailyTaskVariables().get(dailyTaskId)[index] = prevVal + inc;
        player.save();

        this.triggerDailyTaskVarAction(dailyTaskId);
    }

    public void decDailyTaskVarValue(int dailyTaskId, int index, int dec) {
        if(index >= DAILY_TASK_VAR_NUM) {
            Grasscutter.getLogger().debug("Failed to dec daily task var for task {}. Index ({}) too large", dailyTaskId, index);
            return;
        }

        int prevVal = this.getDailyTaskVarValue(dailyTaskId, index);
        this.player.getDailyTaskVariables().get(dailyTaskId)[index] = prevVal - dec;
        player.save();
        
        this.triggerDailyTaskVarAction(dailyTaskId);
    }

    public void claimReward(int dropId) {
        finishedNum++;
        this.save();
        
        if(finishedNum > DAILY_TASK_REWARD_MAX_NUM) return;

        List<GameItem> rewards = this.player.getServer()
                    .getDropSystem()
                    .handleDungeonRewardDrop(dropId, false);
        if(rewards.isEmpty()) {
            Grasscutter.getLogger().warn("daily task drop failed. droppId: {}", dropId);
        } else {
            this.player.getInventory().addItems(rewards,
                    this.player.getWorld().getHost().equals(this.player) ?
                    ActionReason.DailyTaskHost :
                    ActionReason.DailyTaskGuest);
        }
    }

    public void claimScoreReward() {
        if(isScoreRewardTaken) return;
        if(finishedNum < DAILY_TASK_FINISH_NUM) return;

        List<GameItem> scoreRewards = this.player.getServer()
            .getDropSystem()
            .handleDungeonRewardDrop(scoreDropId, false);
        if(scoreRewards.isEmpty()) {
            Grasscutter.getLogger().warn("daily task score reward drop failed. DropId: {}", scoreDropId);
        } else {
            this.player.getInventory().addItems(scoreRewards, ActionReason.DailyTaskScore);
        }

        this.player.sendPacket(new PacketDailyTaskScoreRewardNotify(scorePreviewRewardId));
        isScoreRewardTaken = true;
        this.save();
    }

    public void save() {
        DatabaseHelper.saveDailyTasks(this);
    }
}

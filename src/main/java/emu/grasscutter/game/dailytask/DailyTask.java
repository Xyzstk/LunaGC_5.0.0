package emu.grasscutter.game.dailytask;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Transient;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.DailyTaskData;
import emu.grasscutter.data.excels.DailyTaskRewardData;
import emu.grasscutter.game.dailytask.DailyTask;
import emu.grasscutter.game.dailytask.enums.DailyTaskType;
import emu.grasscutter.game.player.*;
import emu.grasscutter.net.proto.DailyTaskInfoOuterClass.DailyTaskInfo;
import emu.grasscutter.server.packet.send.PacketDailyTaskProgressNotify;

import lombok.*;

@Entity
public class DailyTask {
    @Transient @Getter private DailyTaskData dailyTaskData;
    @Getter private int taskId;

    @Getter private boolean isFinished;
    @Getter private int progress;
    @Getter private int rewardId;
    @Getter private int dropId;

    @Transient @Setter private Player owner;

    public DailyTask(DailyTaskData dailyTaskData, Player player) {
        this.dailyTaskData = dailyTaskData;
        this.taskId = dailyTaskData.getId();
        this.isFinished = false;
        this.progress = 0;

        this.owner = player;

        int level = player.getLevel();
        for(var i : GameData.getDailyTaskLevelDataMap().int2ObjectEntrySet()) {
            var levelData = i.getValue();
            if(level >= levelData.getMinPlayerLevel() && level <= levelData.getMaxPlayerLevel()) {
                DailyTaskRewardData.RewardData reward = GameData.getDailyTaskRewardDataMap()
                    .get(dailyTaskData.getTaskRewardId())
                    .getDropVec()
                    .get(levelData.getId());
                
                this.rewardId = reward.getPreviewRewardId();
                this.dropId = reward.getDropId();
                break;
            }
        }
    }

    public void setConfig(DailyTaskData config) {
        if(config == null || config.getId() != this.taskId) return;
        this.dailyTaskData = config;
    }

    public boolean handleEvent(int... params) {
        if(this.dailyTaskData.getType() == DailyTaskType.DAILY_TASK_QUEST) return false;

        var dailyTaskSystem = this.owner.getServer().getDailyTaskSystem();
        for(int i : this.dailyTaskData.getNewGroupVec()) {
            if(i == params[0]) {
                if(dailyTaskSystem.triggerFinishCond(owner, dailyTaskData, params)) {
                    this.addProgress();
                    return true;
                }
                break;
            }
        }
        return false;
    }

    public void addProgress() {
        if(this.isFinished) return;

        this.progress++;
        if(this.progress >= this.dailyTaskData.getFinishProgress()) {
            this.finish();
        } else {
            // Send packet to all players
            this.owner.broadcastPacketToWorld(new PacketDailyTaskProgressNotify(this));
        }
    }

    public void finish() {
        this.isFinished = true;
        this.progress = this.dailyTaskData.getFinishProgress();

        // Send packet to all players
        this.owner.broadcastPacketToWorld(new PacketDailyTaskProgressNotify(this));

        var dailyTaskSystem = this.owner.getServer().getDailyTaskSystem();

        // finishAction
        this.dailyTaskData.getFinishActionVec().forEach(e -> dailyTaskSystem.triggerAction(owner, e));

        // Try giving rewards to all players in the world
        this.owner.getWorld()
                .getPlayers()
                .forEach(
                        p -> {
                                p.getDailyTaskManager()
                                        .claimReward(this.dropId);});
    }

    public DailyTaskInfo toProto() {
        DailyTaskInfo.Builder proto = DailyTaskInfo.newBuilder()
            .setDailyTaskId(dailyTaskData.getId())
            .setIsFinished(isFinished)
            .setProgress(progress)
            .setFinishProgress(dailyTaskData.getFinishProgress())
            .setRewardId(rewardId);
        
        return proto.build();
    }
}

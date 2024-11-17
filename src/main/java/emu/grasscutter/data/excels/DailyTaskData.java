package emu.grasscutter.data.excels;

import emu.grasscutter.data.*;
import emu.grasscutter.game.dailytask.enums.*;
import emu.grasscutter.game.quest.enums.LogicType;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@ResourceType(name = "DailyTaskExcelConfigData.json")
@Getter
@ToString
public class DailyTaskData extends GameResource {
    private int id;
    private int cityId;
    private int poolId;
    private int weight;
    private int rarity;
    private int questId;
    private int taskRewardId;
    private int taskCycleRefreshTimes;
    private int relatedTag;
    private DailyTaskType type;

    private List<Integer> tagVec;
    private List<Integer> oldGroupVec;
    private List<Integer> newGroupVec;

    private LogicType satisfiedCondComb;
    private List<DailyTaskSatisfiedCond> satisfiedCond;
    private DailyTaskFinishType finishType;
    private int finishParam1;
    private int finishParam2;
    private int finishProgress;
    private List<DailyTaskFinishAction> finishActionVec;

    public void onLoad() {
        if(type == null) type = DailyTaskType.DAILY_TASK_QUEST;
        if(this.satisfiedCondComb == null) this.satisfiedCondComb = LogicType.LOGIC_NONE;
        if(this.satisfiedCond == null) this.satisfiedCond = new ArrayList<>();
        if(this.finishActionVec == null) this.finishActionVec = new ArrayList<>();

        this.finishActionVec.forEach(e -> {
            if(e.getCond() == null) e.setCond(new DailyTaskFinishActionCond());
            e.getCond().setType(DailyTaskCondType.DAILY_TASK_COND_NONE);
        });

        if(this.finishProgress == 0) this.finishProgress = 1;
    }

    public static class DailyTaskSatisfiedCond extends DailyTaskCond<ConditionType> {}

    public static class DailyTaskFinishActionCond extends DailyTaskCond<DailyTaskCondType> {}

    public static class DailyTaskFinishAction extends DailyTaskCond<DailyTaskActionType> {
        @Getter @Setter private DailyTaskFinishActionCond cond;
    }

    @Data
    public static class DailyTaskCond<TYPE extends Enum<?>> {
        private TYPE type;
        private int[] param;
    }
}

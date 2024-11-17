package emu.grasscutter.game.dailytask.conditions;

import emu.grasscutter.data.excels.DailyTaskData;
import emu.grasscutter.game.dailytask.DailyTaskValueCond;
import emu.grasscutter.game.dailytask.enums.ConditionType;
import emu.grasscutter.game.player.Player;

@DailyTaskValueCond(ConditionType.CONDITION_VAR_GT)
public class SatisfiedCondVarGt extends BaseSatisfiedCond {
    public boolean execute(Player owner, DailyTaskData.DailyTaskSatisfiedCond condition) {
        int taskId = condition.getParam()[0];
        int index = condition.getParam()[1];
        int dailyTaskVar = owner.getDailyTaskManager().getDailyTaskVarValue(taskId, index);

        if(dailyTaskVar > condition.getParam()[2]) return true;
        return false;
    }
}

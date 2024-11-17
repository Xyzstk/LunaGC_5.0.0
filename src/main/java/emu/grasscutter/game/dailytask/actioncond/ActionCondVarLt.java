package emu.grasscutter.game.dailytask.actioncond;

import emu.grasscutter.data.excels.DailyTaskData;
import emu.grasscutter.game.dailytask.DailyTaskValueActionCond;
import emu.grasscutter.game.dailytask.enums.DailyTaskCondType;
import emu.grasscutter.game.player.Player;

@DailyTaskValueActionCond(DailyTaskCondType.DAILY_TASK_COND_VAR_LT)
public class ActionCondVarLt extends BaseActionCond {
    public boolean execute(Player owner, DailyTaskData.DailyTaskFinishActionCond condition) {
        int taskId = condition.getParam()[0];
        int index = condition.getParam()[1];
        int dailyTaskVar = owner.getDailyTaskManager().getDailyTaskVarValue(taskId, index);

        if(dailyTaskVar < condition.getParam()[2]) return true;
        return false;
    }
}

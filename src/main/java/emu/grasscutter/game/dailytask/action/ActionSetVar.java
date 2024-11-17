package emu.grasscutter.game.dailytask.action;

import emu.grasscutter.data.excels.DailyTaskData;
import emu.grasscutter.game.dailytask.DailyTaskValueAction;
import emu.grasscutter.game.dailytask.enums.DailyTaskActionType;
import emu.grasscutter.game.player.Player;

@DailyTaskValueAction(DailyTaskActionType.DAILY_TASK_ACTION_SET_VAR)
public class ActionSetVar extends BaseActionHandler {
    public void execute(Player owner, DailyTaskData.DailyTaskFinishAction condition) {
        int taskId = condition.getParam()[0];
        int index = condition.getParam()[1];
        int value = condition.getParam()[2];

        owner.getDailyTaskManager().setDailyTaskVarValue(taskId, index, value);
    }
}

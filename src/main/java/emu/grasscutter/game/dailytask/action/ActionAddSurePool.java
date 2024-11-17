package emu.grasscutter.game.dailytask.action;

import emu.grasscutter.data.excels.DailyTaskData;
import emu.grasscutter.game.dailytask.DailyTaskValueAction;
import emu.grasscutter.game.dailytask.enums.DailyTaskActionType;
import emu.grasscutter.game.player.Player;

@DailyTaskValueAction(DailyTaskActionType.DAILY_TASK_ACTION_ADD_SURE_POOL)
public class ActionAddSurePool extends BaseActionHandler {
    public void execute(Player owner, DailyTaskData.DailyTaskFinishAction condition) {
        int taskId = condition.getParam()[0];
        
        owner.getDailyTaskManager().addToSurePool(taskId);
    }
}

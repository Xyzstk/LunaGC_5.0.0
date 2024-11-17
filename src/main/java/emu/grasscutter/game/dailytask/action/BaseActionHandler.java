package emu.grasscutter.game.dailytask.action;

import emu.grasscutter.data.excels.DailyTaskData;
import emu.grasscutter.game.dailytask.DailyTaskValueAction;
import emu.grasscutter.game.dailytask.enums.DailyTaskActionType;
import emu.grasscutter.game.player.Player;

@DailyTaskValueAction(DailyTaskActionType.DAILY_TASK_ACTION_NONE)
public class BaseActionHandler {
    public void execute(Player owner, DailyTaskData.DailyTaskFinishAction condition) {}
}

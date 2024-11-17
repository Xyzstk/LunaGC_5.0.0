package emu.grasscutter.game.dailytask.actioncond;

import emu.grasscutter.data.excels.DailyTaskData;
import emu.grasscutter.game.dailytask.DailyTaskValueActionCond;
import emu.grasscutter.game.dailytask.enums.DailyTaskCondType;
import emu.grasscutter.game.player.Player;

@DailyTaskValueActionCond(DailyTaskCondType.DAILY_TASK_COND_NONE)
public class BaseActionCond {
    public boolean execute(Player owner, DailyTaskData.DailyTaskFinishActionCond condition) {
        return true;
    }
}

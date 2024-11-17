package emu.grasscutter.game.dailytask.finishcond;

import emu.grasscutter.data.excels.DailyTaskData;
import emu.grasscutter.game.dailytask.DailyTaskValueFinishCond;
import emu.grasscutter.game.dailytask.enums.DailyTaskFinishType;
import emu.grasscutter.game.player.Player;

@DailyTaskValueFinishCond(DailyTaskFinishType.DAILY_FINISH_NONE)
public class BaseFinishCond {
    public boolean execute(Player owner, DailyTaskData dailyTaskData, int... params) {
        return true;
    }
}

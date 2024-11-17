package emu.grasscutter.game.dailytask.finishcond;

import emu.grasscutter.data.excels.DailyTaskData;
import emu.grasscutter.game.dailytask.DailyTaskValueFinishCond;
import emu.grasscutter.game.dailytask.enums.DailyTaskFinishType;
import emu.grasscutter.game.player.Player;

@DailyTaskValueFinishCond(DailyTaskFinishType.DAILY_FINISH_CHALLENGE)
public class FinishCondChallenge extends BaseFinishCond {
    public boolean execute(Player owner, DailyTaskData dailyTaskData, int... params) {
        if(params[2] == 0) return false;
        
        if(dailyTaskData.getFinishParam1() == params[1]
            && dailyTaskData.getFinishParam2() == params[0]) return true;
        return false;
    }
}

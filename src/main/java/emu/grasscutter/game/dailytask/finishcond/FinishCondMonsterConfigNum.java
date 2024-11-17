package emu.grasscutter.game.dailytask.finishcond;

import emu.grasscutter.data.excels.DailyTaskData;
import emu.grasscutter.game.dailytask.DailyTaskValueFinishCond;
import emu.grasscutter.game.dailytask.enums.DailyTaskFinishType;
import emu.grasscutter.game.player.Player;

@DailyTaskValueFinishCond(DailyTaskFinishType.DAILY_FINISH_MONSTER_CONFIG_NUM)
public class FinishCondMonsterConfigNum extends BaseFinishCond {
    public boolean execute(Player owner, DailyTaskData dailyTaskData, int... params) {
        int finishParam1 = dailyTaskData.getFinishParam1();
        if(finishParam1 == 0 || params[1] == finishParam1) return true;
        return false;
    }
}

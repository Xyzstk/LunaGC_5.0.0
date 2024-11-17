package emu.grasscutter.game.dailytask.conditions;

import emu.grasscutter.data.excels.DailyTaskData;
import emu.grasscutter.game.dailytask.DailyTaskValueCond;
import emu.grasscutter.game.dailytask.enums.ConditionType;
import emu.grasscutter.game.player.Player;

@DailyTaskValueCond(ConditionType.CONDITION_NONE)
public class BaseSatisfiedCond {
    public boolean execute(Player owner, DailyTaskData.DailyTaskSatisfiedCond condition) {
        return true;
    }
}

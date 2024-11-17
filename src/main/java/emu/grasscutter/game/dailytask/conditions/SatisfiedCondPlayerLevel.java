package emu.grasscutter.game.dailytask.conditions;

import emu.grasscutter.data.excels.DailyTaskData;
import emu.grasscutter.game.dailytask.DailyTaskValueCond;
import emu.grasscutter.game.dailytask.enums.ConditionType;
import emu.grasscutter.game.player.Player;

@DailyTaskValueCond(ConditionType.CONDITION_PLAYER_LEVEL)
public class SatisfiedCondPlayerLevel extends BaseSatisfiedCond {
    public boolean execute(Player owner, DailyTaskData.DailyTaskSatisfiedCond condition) {
        int minLevel = condition.getParam()[0];
        if(owner.getLevel() >= minLevel) return true;
        return false;
    }
}

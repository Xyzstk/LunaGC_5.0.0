package emu.grasscutter.game.dailytask.conditions;

import emu.grasscutter.data.excels.DailyTaskData;
import emu.grasscutter.game.dailytask.DailyTaskValueCond;
import emu.grasscutter.game.dailytask.enums.ConditionType;
import emu.grasscutter.game.player.Player;

@DailyTaskValueCond(ConditionType.CONDITION_PLAYER_LEVEL_LT)
public class SatisfiedCondPlayerLevelLt extends BaseSatisfiedCond {
    public boolean execute(Player owner, DailyTaskData.DailyTaskSatisfiedCond condition) {
        int maxLevel = condition.getParam()[0];
        if(owner.getLevel() < maxLevel) return true;
        return false;
    }
}

package emu.grasscutter.game.dailytask.conditions;

import emu.grasscutter.data.excels.DailyTaskData;
import emu.grasscutter.game.dailytask.DailyTaskValueCond;
import emu.grasscutter.game.dailytask.enums.ConditionType;
import emu.grasscutter.game.player.Player;

@DailyTaskValueCond(ConditionType.CONDITION_QUEST_GLOBAL_VAR_LESS)
public class SatisfiedCondQuestGlobalVarLess extends BaseSatisfiedCond {
    public boolean execute(Player owner, DailyTaskData.DailyTaskSatisfiedCond condition) {
        int value = owner.getQuestManager().getQuestGlobalVarValue(condition.getParam()[0]);
        if(value < condition.getParam()[1]) return true;
        return false;
    }
}

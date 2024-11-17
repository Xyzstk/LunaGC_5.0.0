package emu.grasscutter.game.dailytask.conditions;

import emu.grasscutter.data.excels.DailyTaskData;
import emu.grasscutter.game.dailytask.DailyTaskValueCond;
import emu.grasscutter.game.dailytask.enums.ConditionType;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.quest.enums.QuestState;

@DailyTaskValueCond(ConditionType.CONDITION_QUEST)
public class SatisfiedCondQuest extends BaseSatisfiedCond {
    public boolean execute(Player owner, DailyTaskData.DailyTaskSatisfiedCond condition) {
        int questId = condition.getParam()[0];
        var quest = owner.getQuestManager().getQuestById(questId);
        if(quest != null && quest.state == QuestState.QUEST_STATE_FINISHED) return true;
        return false;
    }
}

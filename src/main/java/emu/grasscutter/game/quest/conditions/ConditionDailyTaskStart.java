package emu.grasscutter.game.quest.conditions;

import static emu.grasscutter.game.quest.enums.QuestCond.QUEST_COND_DAILY_TASK_START;

import emu.grasscutter.data.excels.quest.QuestData;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.quest.QuestValueCond;

@QuestValueCond(QUEST_COND_DAILY_TASK_START)
public class ConditionDailyTaskStart extends BaseCondition {

    @Override
    public boolean execute(
            Player owner,
            QuestData questData,
            QuestData.QuestAcceptCondition condition,
            String paramStr,
            int... params) {
        return condition.getParam()[0] == params[0] && condition.getParam()[1] == params[1];
    }
}

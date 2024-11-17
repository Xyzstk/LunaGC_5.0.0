package emu.grasscutter.game.quest.conditions;

import emu.grasscutter.data.excels.quest.QuestData;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.quest.QuestValueCond;
import emu.grasscutter.game.quest.enums.QuestCond;

@QuestValueCond(QuestCond.QUEST_COND_DAILY_TASK_VAR_EQ)
public class ConditionDailyTaskVarEqual extends BaseCondition {

    @Override
    public boolean execute(
            Player owner,
            QuestData questData,
            QuestData.QuestAcceptCondition condition,
            String paramStr,
            int... params) {
        int[] conditionParams = condition.getParam();

        int dailyTaskId = conditionParams[0];
        int index = conditionParams[1];
        int targetValue = 0;
        if(conditionParams.length > 2) targetValue = conditionParams[2];

        int dailyTaskVarValue = owner.getDailyTaskManager().getDailyTaskVarValue(dailyTaskId, index);
        return dailyTaskVarValue == targetValue;
    }
}

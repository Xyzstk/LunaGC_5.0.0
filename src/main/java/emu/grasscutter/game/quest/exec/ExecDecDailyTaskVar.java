package emu.grasscutter.game.quest.exec;

import emu.grasscutter.data.excels.quest.QuestData;
import emu.grasscutter.game.quest.*;
import emu.grasscutter.game.quest.enums.QuestExec;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;

@QuestValueExec(QuestExec.QUEST_EXEC_DEC_DAILY_TASK_VAR)
public class ExecDecDailyTaskVar extends QuestExecHandler {
    @Override
    public boolean execute(GameQuest quest, QuestData.QuestExecParam condition, String... paramStr) {
        String[] conditionParams = condition.getParam();
        int dailyTaskId = Integer.parseInt(conditionParams[0]);
        int index = Integer.parseInt(conditionParams[1]);
        int dec = 1;
        if(conditionParams.length > 2) dec = Integer.parseInt(conditionParams[2]);
        quest
                .getOwner()
                .getDailyTaskManager()
                .decDailyTaskVarValue(dailyTaskId, index, dec);
        return true;
    }
}

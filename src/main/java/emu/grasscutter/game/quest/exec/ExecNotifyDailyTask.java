package emu.grasscutter.game.quest.exec;

import emu.grasscutter.data.excels.quest.QuestData;
import emu.grasscutter.game.quest.*;
import emu.grasscutter.game.quest.enums.QuestExec;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;

@QuestValueExec(QuestExec.QUEST_EXEC_NOTIFY_DAILY_TASK)
public class ExecNotifyDailyTask extends QuestExecHandler {
    @Override
    public boolean execute(GameQuest quest, QuestData.QuestExecParam condition, String... paramStr) {
        var player = quest.getOwner();
        int dailyTaskId = Integer.parseInt(condition.getParam()[0]);
        int Param = Integer.parseInt(condition.getParam()[1]);
        return player.getDailyTaskManager().triggerEvent(dailyTaskId, Param);
    }
}

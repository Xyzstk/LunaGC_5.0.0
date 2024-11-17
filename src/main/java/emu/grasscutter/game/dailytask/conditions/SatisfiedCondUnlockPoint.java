package emu.grasscutter.game.dailytask.conditions;

import emu.grasscutter.data.excels.DailyTaskData;
import emu.grasscutter.game.dailytask.DailyTaskValueCond;
import emu.grasscutter.game.dailytask.enums.ConditionType;
import emu.grasscutter.game.player.Player;

@DailyTaskValueCond(ConditionType.CONDITION_UNLOCK_POINT)
public class SatisfiedCondUnlockPoint extends BaseSatisfiedCond {
    public boolean execute(Player owner, DailyTaskData.DailyTaskSatisfiedCond condition) {
        int sceneId = condition.getParam()[0];
        int pointId = condition.getParam()[1];
        return owner.getUnlockedScenePoints(sceneId).contains(pointId);
    }
}

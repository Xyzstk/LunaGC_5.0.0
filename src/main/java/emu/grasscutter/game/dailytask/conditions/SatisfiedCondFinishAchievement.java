package emu.grasscutter.game.dailytask.conditions;

import emu.grasscutter.data.excels.DailyTaskData;
import emu.grasscutter.game.dailytask.DailyTaskValueCond;
import emu.grasscutter.game.dailytask.enums.ConditionType;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.proto.AchievementOuterClass.Achievement;

@DailyTaskValueCond(ConditionType.CONDITION_FINISH_ACHIEVEMENT)
public class SatisfiedCondFinishAchievement extends BaseSatisfiedCond {
    public boolean execute(Player owner, DailyTaskData.DailyTaskSatisfiedCond condition) {
        return owner.getAchievements()
                .getStatus(condition.getParam()[0])
                .compareTo(Achievement.Status.STATUS_UNFINISHED) > 0;
    }
}

package emu.grasscutter.game.dailytask;

import emu.grasscutter.game.dailytask.enums.ConditionType;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface DailyTaskValueCond {
    ConditionType value();
}

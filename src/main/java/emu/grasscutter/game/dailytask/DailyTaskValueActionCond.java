package emu.grasscutter.game.dailytask;

import emu.grasscutter.game.dailytask.enums.DailyTaskCondType;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface DailyTaskValueActionCond {
    DailyTaskCondType value();
}

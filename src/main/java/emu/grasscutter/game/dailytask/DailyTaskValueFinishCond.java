package emu.grasscutter.game.dailytask;

import emu.grasscutter.game.dailytask.enums.DailyTaskFinishType;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface DailyTaskValueFinishCond {
    DailyTaskFinishType value();
}

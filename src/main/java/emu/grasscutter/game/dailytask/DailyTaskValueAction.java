package emu.grasscutter.game.dailytask;

import emu.grasscutter.game.dailytask.enums.DailyTaskActionType;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface DailyTaskValueAction {
    DailyTaskActionType value();
}

package emu.grasscutter.game.dailytask.enums;

public enum DailyTaskCondType {
    DAILY_TASK_COND_NONE(0),
    DAILY_TASK_COND_VAR_EQ(1),
    DAILY_TASK_COND_VAR_NE(2),
    DAILY_TASK_COND_VAR_GT(3),
    DAILY_TASK_COND_VAR_LT(4);

    private final int value;

    DailyTaskCondType(int id) {
        this.value = id;
    }

    public int getValue() {
        return value;
    }
}

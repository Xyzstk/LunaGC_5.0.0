package emu.grasscutter.game.dailytask.enums;

public enum DailyTaskActionType {
    DAILY_TASK_ACTION_NONE(0),
    DAILY_TASK_ACTION_SET_VAR(1),
    DAILY_TASK_ACTION_INC_VAR(2),
    DAILY_TASK_ACTION_DEC_VAR(3),
    DAILY_TASK_ACTION_ADD_SURE_POOL(4),
    DAILY_TASK_ACTION_ADD_POSSIBLE_POOL(5);

    private final int value;

    DailyTaskActionType(int id) {
        this.value = id;
    }

    public int getValue() {
        return value;
    }
}

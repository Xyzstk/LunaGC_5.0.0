package emu.grasscutter.game.dailytask.enums;

public enum DailyTaskType {
    DAILY_TASK_QUEST(0),
    DAILY_TASK_SCENE(1);

    private final int value;

    DailyTaskType(int id) {
        this.value = id;
    }

    public int getValue() {
        return value;
    }
}

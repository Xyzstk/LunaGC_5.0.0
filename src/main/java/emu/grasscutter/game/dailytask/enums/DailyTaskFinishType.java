package emu.grasscutter.game.dailytask.enums;

public enum DailyTaskFinishType {
    DAILY_FINISH_NONE(0),
    DAILY_FINISH_MONSTER_ID_NUM(1),
    DAILY_FINISH_GADGET_ID_NUM(2),
    DAILY_FINISH_MONSTER_CONFIG_NUM(3),
    DAILY_FINISH_GADGET_CONFIG_NUM(4),
    DAILY_FINISH_MONSTER_NUM(5),
    DAILY_FINISH_CHEST_CONFIG(6),
    DAILY_FINISH_GATHER(7),
    DAILY_FINISH_CHALLENGE(8);

    private final int value;

    DailyTaskFinishType(int id) {
        this.value = id;
    }

    public int getValue() {
        return value;
    }
}

package emu.grasscutter.game.dailytask.enums;

public enum ConditionType {
    CONDITION_NONE(0),
    CONDITION_QUEST(1),
    CONDITION_PLAYER_LEVEL(2),
    CONDITION_VAR_EQ(3),
    CONDITION_VAR_NE(4),
    CONDITION_VAR_GT(5),
    CONDITION_VAR_LT(6),
    CONDITION_UNLOCK_POINT(7),
    CONDITION_PLAYER_LEVEL_GT_EQ(8),
    CONDITION_PLAYER_LEVEL_LT(9),
    CONDITION_SPECIFIC_ACTIVITY_OPEN(10),
    CONDITION_ACTIVITY_TYPE_OPEN(11),
    CONDITION_QUEST_GLOBAL_VAR_EQUAL(12),
    CONDITION_QUEST_GLOBAL_VAR_GREATER(13),
    CONDITION_QUEST_GLOBAL_VAR_LESS(14),
    CONDITION_FINISH_ACHIEVEMENT(15);

    private final int value;

    ConditionType(int id) {
        this.value = id;
    }

    public int getValue() {
        return value;
    }
}

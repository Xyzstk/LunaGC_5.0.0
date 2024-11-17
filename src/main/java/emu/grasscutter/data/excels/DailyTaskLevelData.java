package emu.grasscutter.data.excels;

import emu.grasscutter.data.*;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@ResourceType(name = "DailyTaskLevelExcelConfigData.json")
@Getter
public class DailyTaskLevelData extends GameResource {
    @SerializedName("ID")
    private int id;

    private int minPlayerLevel;
    private int maxPlayerLevel;
    private int groupReviseLevel;
    private int scoreDropId;
    private int scorePreviewRewardId;
}

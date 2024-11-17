package emu.grasscutter.data.excels;

import emu.grasscutter.data.*;

import java.util.*;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@ResourceType(name = "DailyTaskRewardExcelConfigData.json")
@Getter
public class DailyTaskRewardData extends GameResource {
    @SerializedName("ID")
    private int id;
    private List<RewardData> dropVec;

    @Getter
    public static class RewardData {
        private int dropId;
        private int previewRewardId;
    }
}

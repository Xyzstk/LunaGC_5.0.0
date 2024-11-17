package emu.grasscutter.data.excels;

import emu.grasscutter.data.*;
import java.util.List;
import lombok.*;
import lombok.experimental.FieldDefaults;

@ResourceType(name = "CityTaskOpenExcelConfigData.json")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CityTaskOpenData extends GameResource {
    int cityId;
    int questId;
    List<Integer> backupVec;

    @Override
    public int getId() {
        return this.cityId;
    }
}

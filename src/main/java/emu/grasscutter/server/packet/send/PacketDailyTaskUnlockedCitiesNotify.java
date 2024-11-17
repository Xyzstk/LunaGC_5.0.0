package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.DailyTaskUnlockedCitiesNotifyOuterClass.DailyTaskUnlockedCitiesNotify;

public class PacketDailyTaskUnlockedCitiesNotify extends BasePacket {
    public PacketDailyTaskUnlockedCitiesNotify(int cityId) {
        super(PacketOpcodes.DailyTaskUnlockedCitiesNotify);

        DailyTaskUnlockedCitiesNotify.Builder p =
            DailyTaskUnlockedCitiesNotify.newBuilder().addUnlockedCityList(cityId);

        this.setData(p);
    }

    public PacketDailyTaskUnlockedCitiesNotify(Iterable<Integer> cityIds) {
        super(PacketOpcodes.DailyTaskUnlockedCitiesNotify);

        DailyTaskUnlockedCitiesNotify.Builder p =
            DailyTaskUnlockedCitiesNotify.newBuilder().addAllUnlockedCityList(cityIds);

        this.setData(p);
    }
}

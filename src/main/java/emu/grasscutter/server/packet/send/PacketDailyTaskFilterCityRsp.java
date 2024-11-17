package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DailyTaskFilterCityRspOuterClass.DailyTaskFilterCityRsp;
import emu.grasscutter.net.proto.RetcodeOuterClass.Retcode;

public class PacketDailyTaskFilterCityRsp extends BasePacket {
    
    public PacketDailyTaskFilterCityRsp(int cityId, Retcode retcode) {
        super(PacketOpcodes.DailyTaskFilterCityRsp);

        this.setData(DailyTaskFilterCityRsp.newBuilder().setCityId(cityId).setRetcode(retcode.getNumber()));
    }
}

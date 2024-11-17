package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.dailytask.DailyTask;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.DailyTaskProgressNotifyOuterClass.DailyTaskProgressNotify;

public class PacketDailyTaskProgressNotify extends BasePacket {

    public PacketDailyTaskProgressNotify(DailyTask dailyTask) {
        super(PacketOpcodes.DailyTaskProgressNotify);
        
        this.setData(DailyTaskProgressNotify.newBuilder().setInfo(dailyTask.toProto()));
    }
}

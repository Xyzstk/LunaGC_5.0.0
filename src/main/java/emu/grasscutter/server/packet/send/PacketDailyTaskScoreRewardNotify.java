package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.DailyTaskScoreRewardNotifyOuterClass.DailyTaskScoreRewardNotify;

public class PacketDailyTaskScoreRewardNotify extends BasePacket {

    public PacketDailyTaskScoreRewardNotify(int rewardId) {
        super(PacketOpcodes.DailyTaskScoreRewardNotify);
        
        this.setData(DailyTaskScoreRewardNotify.newBuilder().setRewardId(rewardId));
    }
}

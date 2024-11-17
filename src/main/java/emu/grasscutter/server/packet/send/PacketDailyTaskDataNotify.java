package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.dailytask.DailyTaskManager;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.DailyTaskDataNotifyOuterClass.DailyTaskDataNotify;

public class PacketDailyTaskDataNotify extends BasePacket {

    public PacketDailyTaskDataNotify(DailyTaskManager dailyTaskManager) {
        super(PacketOpcodes.DailyTaskDataNotify);

        DailyTaskDataNotify.Builder proto = DailyTaskDataNotify.newBuilder()
                .setFinishedNum(dailyTaskManager.getFinishedNum())
                .setIsTakenScoreReward(dailyTaskManager.isScoreRewardTaken())
                .setScoreRewardId(dailyTaskManager.getScorePreviewRewardId());
        
        this.setData(proto);
    }
}

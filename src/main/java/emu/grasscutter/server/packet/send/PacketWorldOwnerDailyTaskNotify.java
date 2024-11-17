package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.dailytask.DailyTaskManager;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.WorldOwnerDailyTaskNotifyOuterClass.WorldOwnerDailyTaskNotify;

public class PacketWorldOwnerDailyTaskNotify extends BasePacket {

    public PacketWorldOwnerDailyTaskNotify(DailyTaskManager dailyTaskManager) {
        super(PacketOpcodes.WorldOwnerDailyTaskNotify);

        WorldOwnerDailyTaskNotify.Builder proto = WorldOwnerDailyTaskNotify.newBuilder()
            .setFilterCityId(dailyTaskManager.getFilterCityId());
        
        int finishedNum = 0;
        for(var t : dailyTaskManager.getPlayerDailyTask().entrySet()) {
            if(t.getValue().isFinished()) {
                finishedNum++;
            }
            proto.addTaskList(t.getValue().toProto());
        }
        proto.setFinishedDailyTaskNum(finishedNum);
        
        this.setData(proto);
    }
}

package emu.grasscutter.server.packet.send;

import java.util.Arrays;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.TaskVarNotifyOuterClass.TaskVarNotify;
import emu.grasscutter.net.proto.TaskVarOuterClass.TaskVar;

public class PacketTaskVarNotify extends BasePacket {

    public PacketTaskVarNotify(Player player, int dailyTaskId) {
        super(PacketOpcodes.TaskVarNotify);

        var taskVar = TaskVar.newBuilder().setKey(dailyTaskId);

        var dailyTaskVariables = player.getDailyTaskVariables().get(dailyTaskId);
        if(dailyTaskVariables != null)
            taskVar.addAllValueList(Arrays.asList(player.getDailyTaskVariables().get(dailyTaskId)));
        
        this.setData(TaskVarNotify.newBuilder().addTaskVarList(taskVar));
    }

    public PacketTaskVarNotify(Player player) {
        super(PacketOpcodes.TaskVarNotify);

        var proto = TaskVarNotify.newBuilder().addAllTaskVarList(
                player.getDailyTaskVariables().entrySet().stream().map(
                    e -> TaskVar.newBuilder().setKey(e.getKey()).addAllValueList(Arrays.asList(e.getValue())).build())
                .toList());

        this.setData(proto);
    }
}

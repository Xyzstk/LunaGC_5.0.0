package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DailyTaskFilterCityReqOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass.Retcode;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketDailyTaskFilterCityRsp;

@Opcodes(PacketOpcodes.DailyTaskFilterCityReq)
public class HandlerDailyTaskFilterCityReq extends PacketHandler {
    
    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        DailyTaskFilterCityReqOuterClass.DailyTaskFilterCityReq req =
                DailyTaskFilterCityReqOuterClass.DailyTaskFilterCityReq.parseFrom(payload);
        
        int cityId = req.getCityId();
        Retcode retcode = session.getPlayer().getDailyTaskManager().handleFilterCityReq(cityId);
        session.send(new PacketDailyTaskFilterCityRsp(cityId, retcode));
    }
}

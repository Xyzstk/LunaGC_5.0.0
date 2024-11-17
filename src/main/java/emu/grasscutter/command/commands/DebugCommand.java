package emu.grasscutter.command.commands;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.command.*;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotify;

import java.util.List;
import java.util.HexFormat;

@Command(
        label = "debug",
        usage = "/debug",
        permission = "grasscutter.command.debug",
        targetRequirement = Command.TargetRequirement.NONE)
public final class DebugCommand implements CommandHandler {
    @Override
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        // if (sender == null) return;

        if (args.isEmpty()) {
            sender.dropMessage("No arguments provided. (check command for help)");
            return;
        }

        var subCommand = args.get(0);
        args.remove(0);
        switch (subCommand) {
            default -> sender.dropMessage("No arguments provided. (check command for help)");
            case "abilities" -> {
                if (args.isEmpty()) {
                    sender.dropMessage("No arguments provided. (check command for help)");
                    return;
                }

                var scene = sender.getScene();
                var entityId = Integer.parseInt(args.get(0));
                // TODO Might want to allow groupId specification,
                // because there can be more than one entity with
                // the given config ID.
                var entity =
                        args.size() > 1 && args.get(1).equals("config")
                                ? scene.getFirstEntityByConfigId(entityId)
                                : scene.getEntityById(entityId);
                if (entity == null) {
                    sender.dropMessage("Entity not found.");
                    return;
                }

                try {
                    var abilities = entity.getInstancedAbilities();
                    for (var i = 0; i < abilities.size(); i++) {
                        try {
                            var ability = abilities.get(i);
                            Grasscutter.getLogger()
                                    .debug(
                                            "Ability #{}: {}; Modifiers: {}",
                                            i,
                                            ability.toString(),
                                            ability.getModifiers().keySet());
                        } catch (Exception exception) {
                            Grasscutter.getLogger().warn("Failed to print ability #{}.", i, exception);
                        }
                    }

                    if (abilities.isEmpty()) {
                        Grasscutter.getLogger().debug("No abilities found on {}.", entity.toString());
                    }
                } catch (Exception exception) {
                    Grasscutter.getLogger().warn("Failed to get abilities.", exception);
                }

                sender.dropMessage("Check console for abilities.");
            }
            case "point" -> {
                if (args.size() < 3) {
                    sender.dropMessage("No arguments provided. (check command for help)");
                    return;
                }
                subCommand = args.get(0);
                int scene, point;
                try {
                    scene = Integer.parseInt(args.get(1));
                    point = Integer.parseInt(args.get(2));
                } catch (Exception e) {
                    sender.dropMessage("Invalid argument.");
                    return;
                }
                BasePacket packet = new BasePacket(PacketOpcodes.ScenePointUnlockNotify);
                switch (subCommand) {
                    case "unlock":
                        targetPlayer.getUnlockedScenePoints(scene).add(point);
                        packet.setData(ScenePointUnlockNotify.newBuilder().setSceneId(scene).addPointList(point));
                        break;
                    case "lock":
                        targetPlayer.getUnlockedScenePoints(scene).remove(point);
                        packet.setData(ScenePointUnlockNotify.newBuilder().setSceneId(scene).addLockedPointList(point));
                        break;
                    case "unhide":
                        packet.setData(ScenePointUnlockNotify.newBuilder().setSceneId(scene).addUnhidePointList(point));
                        break;
                    case "hide":
                        packet.setData(ScenePointUnlockNotify.newBuilder().setSceneId(scene).addHidePointList(point));
                        break;
                    default:
                        sender.dropMessage("Invalid operation.");
                        return;
                }
                targetPlayer.sendPacket(packet);
            }
            case "packet" -> {
                if(args.isEmpty()) {
                    sender.dropMessage("No arguments provided. (check command for help)");
                    return;
                }
                try {
                    BasePacket packet = new BasePacket(Integer.parseInt(args.get(0)));
                    if(args.size() > 1) packet.setData(HexFormat.of().parseHex(args.get(1)));
                    targetPlayer.sendPacket(packet);
                } catch (Exception e) {
                    sender.dropMessage("Invalid arguments.");
                }
            }
            case "dailyrst" -> {
                targetPlayer.getDailyTaskManager().resetDailyTasks();
            }
        }
    }
}

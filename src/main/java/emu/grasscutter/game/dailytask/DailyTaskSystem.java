package emu.grasscutter.game.dailytask;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.excels.DailyTaskData;
import emu.grasscutter.data.excels.DailyTaskData.DailyTaskSatisfiedCond;
import emu.grasscutter.data.excels.DailyTaskData.DailyTaskFinishAction;
import emu.grasscutter.data.excels.DailyTaskData.DailyTaskFinishActionCond;
import emu.grasscutter.game.dailytask.action.BaseActionHandler;
import emu.grasscutter.game.dailytask.actioncond.BaseActionCond;
import emu.grasscutter.game.dailytask.conditions.BaseSatisfiedCond;
import emu.grasscutter.game.dailytask.finishcond.BaseFinishCond;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.game.BaseGameSystem;
import emu.grasscutter.server.game.GameServer;
import it.unimi.dsi.fastutil.ints.*;

public final class DailyTaskSystem extends BaseGameSystem {

    private final Int2ObjectMap<BaseSatisfiedCond> dailyCondHandlers;
    private final Int2ObjectMap<BaseFinishCond> dailyFinishCondHandlers;
    private final Int2ObjectMap<BaseActionCond> dailyActionCondHandlers;
    private final Int2ObjectMap<BaseActionHandler> dailyActionHandlers;

    public DailyTaskSystem(GameServer server) {
        super(server);

        this.dailyCondHandlers = new Int2ObjectOpenHashMap<>();
        this.dailyFinishCondHandlers = new Int2ObjectOpenHashMap<>();
        this.dailyActionCondHandlers = new Int2ObjectOpenHashMap<>();
        this.dailyActionHandlers = new Int2ObjectOpenHashMap<>();
        
        this.registerHandlers();
    }

    public void registerHandlers() {
        this.registerHandlers(this.dailyCondHandlers, BaseSatisfiedCond.class);
        this.registerHandlers(this.dailyFinishCondHandlers, BaseFinishCond.class);
        this.registerHandlers(this.dailyActionCondHandlers, BaseActionCond.class);
        this.registerHandlers(this.dailyActionHandlers, BaseActionHandler.class);
    }

    public <T> void registerHandlers(Int2ObjectMap<T> map, Class<T> clazz) {
        var handlerClasses = Grasscutter.reflector.getSubTypesOf(clazz);
        for (var obj : handlerClasses) {
            this.registerHandler(map, obj);
        }
    }

    public <T> void registerHandler(Int2ObjectMap<T> map, Class<? extends T> handlerClass) {
        try {
            int value;
            if (handlerClass.isAnnotationPresent(DailyTaskValueCond.class)) {
                DailyTaskValueCond opcode = handlerClass.getAnnotation(DailyTaskValueCond.class);
                value = opcode.value().getValue();
            } else if (handlerClass.isAnnotationPresent(DailyTaskValueFinishCond.class)) {
                DailyTaskValueFinishCond opcode = handlerClass.getAnnotation(DailyTaskValueFinishCond.class);
                value = opcode.value().getValue();
            } else if (handlerClass.isAnnotationPresent(DailyTaskValueActionCond.class)) {
                DailyTaskValueActionCond opcode = handlerClass.getAnnotation(DailyTaskValueActionCond.class);
                value = opcode.value().getValue();
            } else if (handlerClass.isAnnotationPresent(DailyTaskValueAction.class)) {
                DailyTaskValueAction opcode = handlerClass.getAnnotation(DailyTaskValueAction.class);
                value = opcode.value().getValue();
            } else {
                return;
            }

            if (value <= 0) {
                return;
            }

            map.put(value, handlerClass.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            Grasscutter.getLogger()
                    .warn("Unable to register handler {}.", handlerClass.getSimpleName(), e);
        }
    }

    public boolean triggerSatisfiedCond(Player owner, DailyTaskSatisfiedCond condition) {
        BaseSatisfiedCond handler = dailyCondHandlers.get(condition.getType().getValue());

        if(handler == null) {
            Grasscutter.getLogger()
                    .debug("Could not trigger daily task satisfied condition {}", condition.getType().getValue());
            return false;
        }

        return handler.execute(owner, condition);
    }

    public boolean triggerFinishCond(Player owner, DailyTaskData dailyTaskData, int... params) {
        BaseFinishCond handler = dailyFinishCondHandlers.get(dailyTaskData.getFinishType().getValue());

        if(handler == null) {
            Grasscutter.getLogger()
                    .debug("Could not trigger daily task finish condition for {}", dailyTaskData);
            return false;
        }

        return handler.execute(owner, dailyTaskData, params);
    }

    public void triggerAction(Player owner, DailyTaskFinishAction condition) {
        BaseActionHandler actionHandler = dailyActionHandlers.get(condition.getType().getValue());

        if(actionHandler == null) {
            Grasscutter.getLogger()
                    .debug("Could not trigger daily task action {}", condition.getType().getValue());
            return;
        }
        
        DailyTaskFinishActionCond actionCond = condition.getCond();
        if(actionCond != null) {
            BaseActionCond condHandler = dailyActionCondHandlers.get(actionCond.getType().getValue());

            if(condHandler == null) {
                Grasscutter.getLogger()
                    .debug("Could not trigger daily task action cond {}", actionCond.getType().getValue());
                return;
            }

            if(!condHandler.execute(owner, actionCond)) return;
        }

        actionHandler.execute(owner, condition);
    }
}

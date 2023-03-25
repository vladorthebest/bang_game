package sk.stuba.fei.uim.oop.game.bang.effects.abs;

import sk.stuba.fei.uim.oop.game.bang.effects.types.EffectType;
import sk.stuba.fei.uim.oop.game.bang.player.Player;

public abstract class BaseEffect {
    protected String name;
    protected int priority;
    protected EffectType type;
    protected boolean isPassive;
    protected boolean disposable;
    protected boolean allwaysDisposable;

    public boolean isPassive() {
        return isPassive;
    }
    public boolean isDisposable() {
        return disposable;
    }

    public boolean isAllwaysDisposable() {
        return allwaysDisposable;
    }
    public boolean use(Player ownerPlayer){
        return false;
    }

    public EffectType getType() {
        return type;
    }

    public int getPriority(){
        return priority;
    }

    @Override
    public String toString() {
        return name;
    }
    public String getName(){
        return name;
    }
}

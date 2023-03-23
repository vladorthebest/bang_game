package sk.stuba.fei.uim.oop.game.bang.effects;

import sk.stuba.fei.uim.oop.game.bang.player.Player;

public abstract class BaseEffect {
    protected String name;
    protected int priority;
    protected EffectType type;

    public boolean isDisposable() {
        return disposable;
    }

    protected boolean disposable;
    public boolean use(Player ownerPlayer){
        return false;
    };

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
}

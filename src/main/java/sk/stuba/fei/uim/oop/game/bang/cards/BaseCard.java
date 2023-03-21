package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.player.Player;

public abstract class BaseCard {
    protected String name;
    protected Color type;
    protected boolean target;

    public boolean needTarget(){
        return this.target;
    }
    public void use(Player usingPlayer, Player targetPlayer) {}; // Target
    public String toString(){
        return name;
    }
}

package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.player.Player;

public abstract class BaseCard {
    protected String name;
    protected String type;
    public void use(Player usingPlayer, Player targetPlayer) {}; // Two players

    public String toString(){
        return name;
    }
}

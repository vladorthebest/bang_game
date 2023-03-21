package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.player.Player;

public abstract class BaseCard {
    public String name = "test";
    String type;
    public void use(Player usingPlayer, Player targetPlayer) {}; // Two players

    public String toString(){
        return name;
    }
}

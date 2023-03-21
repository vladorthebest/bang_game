package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.player.Player;

public abstract class BaseCard {
    protected String name;
    protected Color type;


    public String toString(){
        return name;
    }
}

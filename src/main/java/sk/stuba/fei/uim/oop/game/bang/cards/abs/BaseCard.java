package sk.stuba.fei.uim.oop.game.bang.cards.abs;

import sk.stuba.fei.uim.oop.game.bang.cards.types.Color;
import sk.stuba.fei.uim.oop.game.bang.player.Player;

public abstract class BaseCard {
    protected String name;
    protected Color type;
    final String ANSI_RESET = "\u001B[0m";

    public void use(Player usingPlayer) {} // Target
    public String toString(){
        return this.type.get() + this.name + ANSI_RESET;
    }

    public String getName(){
        return name;
    }

    public Color getType() {
        return type;
    }
}

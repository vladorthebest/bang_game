package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.cards.abs.NoneTargetCard;
import sk.stuba.fei.uim.oop.game.bang.cards.types.Color;
import sk.stuba.fei.uim.oop.game.bang.player.Player;

public class BeerCard extends NoneTargetCard {

    {
        this.name = "Beer";
        this.type = Color.BROWN;
    }
    @Override
    public void use(Player usingPlayer) {
        usingPlayer.addHP(1);
    }
}

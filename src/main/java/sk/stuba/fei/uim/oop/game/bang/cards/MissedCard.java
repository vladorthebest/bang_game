package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.cards.abs.NoneTargetCard;
import sk.stuba.fei.uim.oop.game.bang.cards.types.Color;
import sk.stuba.fei.uim.oop.game.bang.player.Player;

public class MissedCard extends NoneTargetCard {
    {
        this.name = "Missed";
        this.type = Color.BROWN;
    }

    @Override
    public void use(Player usingPlayer) {
        usingPlayer.addCard(this);
    }
}

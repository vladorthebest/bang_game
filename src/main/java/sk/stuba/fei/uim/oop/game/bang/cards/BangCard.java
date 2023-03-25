package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.cards.abs.TargetCard;
import sk.stuba.fei.uim.oop.game.bang.cards.types.Color;
import sk.stuba.fei.uim.oop.game.bang.player.Player;

public class BangCard extends TargetCard {

    {
        this.name = "BANG!";
        this.type = Color.BROWN;
    }

    @Override
    public void use(Player usingPlayer) {
        Player targetPlayer = super.targeting(usingPlayer);

        if (!targetPlayer.useMissingEffects()){
            targetPlayer.damageHP(1);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

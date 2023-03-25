package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.cards.abs.TargetCard;
import sk.stuba.fei.uim.oop.game.bang.cards.types.Color;
import sk.stuba.fei.uim.oop.game.bang.effects.abs.BaseEffect;
import sk.stuba.fei.uim.oop.game.bang.effects.PrisonEffect;
import sk.stuba.fei.uim.oop.game.bang.player.Player;

public class PrisonCard extends TargetCard {

    private BaseEffect effect;
    {
        this.name = "Prison";
        this.type = Color.BLUE;
        this.effect = new PrisonEffect();
    }
    @Override
    public void use(Player usingPlayer) {
        Player targetPlayer = super.targeting(usingPlayer);
        if (!targetPlayer.addEffect(effect)){
            usingPlayer.addCard(this);
        }
    }
}

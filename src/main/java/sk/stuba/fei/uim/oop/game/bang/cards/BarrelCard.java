package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.cards.abs.NoneTargetCard;
import sk.stuba.fei.uim.oop.game.bang.cards.types.Color;
import sk.stuba.fei.uim.oop.game.bang.effects.BarrelEffect;
import sk.stuba.fei.uim.oop.game.bang.effects.abs.BaseEffect;
import sk.stuba.fei.uim.oop.game.bang.player.Player;

public class BarrelCard extends NoneTargetCard {

    private BaseEffect effect;
    {
        this.name = "Barrel";
        this.type = Color.BLUE;
        this.effect = new BarrelEffect();
    }
    @Override
    public void use(Player usingPlayer) {
        if (!usingPlayer.addEffect(effect)){
            System.out.println("You cant use this card");
            usingPlayer.addCard(this);
        }
    }
}

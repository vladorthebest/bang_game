package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.effects.BarrelEffect;
import sk.stuba.fei.uim.oop.game.bang.effects.BaseEffect;
import sk.stuba.fei.uim.oop.game.bang.effects.DynamiteEffect;
import sk.stuba.fei.uim.oop.game.bang.player.Player;

public class DynamiteCard extends NoneTargetCard{

    private BaseEffect effect;
    {
        this.name = "Dynamite";
        this.type = Color.BLUE;
        this.effect = new DynamiteEffect();
    }
    @Override
    public void use(Player usingPlayer) {
        if (!usingPlayer.addEffect(effect)){
            usingPlayer.addCard(this);
        }
    }
}

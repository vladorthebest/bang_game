package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.effects.BarrelEffect;
import sk.stuba.fei.uim.oop.game.bang.effects.BaseEffect;
import sk.stuba.fei.uim.oop.game.bang.player.Player;

public class BarrelCard extends NoneTargetCard{

    private BaseEffect effect;
    {
        this.name = "Barrel";
        this.type = Color.BLUE;
        this.effect = new BarrelEffect();
    }
    @Override
    public void use(Player usingPlayer) {
        usingPlayer.addEffect(effect);
    }
}
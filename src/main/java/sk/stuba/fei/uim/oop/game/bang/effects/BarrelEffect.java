package sk.stuba.fei.uim.oop.game.bang.effects;

import sk.stuba.fei.uim.oop.game.bang.cards.BarrelCard;
import sk.stuba.fei.uim.oop.game.bang.effects.abs.ActiveEffect;
import sk.stuba.fei.uim.oop.game.bang.effects.types.EffectType;
import sk.stuba.fei.uim.oop.game.bang.player.Player;

import java.util.Random;

public class BarrelEffect extends ActiveEffect {

    private int chance;
    private Random randomGenerator = new Random();


    {
        this.name = "Barrel";
        this.priority = 1;
        this.chance = 4;
        this.type = EffectType.MISS;
        this.disposable = true;
        this.allwaysDisposable = false;
    }

    @Override
    public boolean use(Player ownerPlayer) {
        if(randomGenerator.nextInt(chance) == 1)
            ownerPlayer.getResetDeck().addCard(new BarrelCard());
        return (randomGenerator.nextInt(chance) == 1);
    }
}

package sk.stuba.fei.uim.oop.game.bang.effects;

import sk.stuba.fei.uim.oop.game.bang.effects.abs.ActiveEffect;
import sk.stuba.fei.uim.oop.game.bang.effects.types.EffectType;
import sk.stuba.fei.uim.oop.game.bang.player.Player;

import java.util.Random;

public class PrisonEffect extends ActiveEffect {

    private int chance;
    private Random randomGenerator = new Random();


    {
        this.chance = 4;
        this.name = "Prison";
        this.priority = 2;
        this.type = EffectType.START;
        this.disposable = true;
        this.allwaysDisposable = true;
    }

    @Override
    public boolean use(Player ownerPlayer) {
        return (randomGenerator.nextInt(chance) == 1);
    }
}

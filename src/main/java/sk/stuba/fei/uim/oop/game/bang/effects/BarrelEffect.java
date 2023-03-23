package sk.stuba.fei.uim.oop.game.bang.effects;

import sk.stuba.fei.uim.oop.game.bang.player.Player;

import java.util.Random;

public class BarrelEffect extends BaseEffect{

    private int chance = 4;
    private Random randomGenerator = new Random();


    {
        this.name = "Barrel";
        this.priority = 1;
        this.type = EffectType.MISS;
        this.disposable = true;
    }

    @Override
    public boolean use(Player ownerPlayer) {
        return (randomGenerator.nextInt(chance) == 1);
    }
}

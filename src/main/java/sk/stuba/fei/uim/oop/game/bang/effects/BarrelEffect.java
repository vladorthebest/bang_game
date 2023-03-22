package sk.stuba.fei.uim.oop.game.bang.effects;

import java.util.Random;

public class BarrelEffect extends BaseEffect{

    private int chance = 4;
    private Random randomGenerator = new Random();


    {
        this.name = "Barrel";
        this.priority = 1;
        this.type = EffectType.MISS;
    }

    @Override
    public boolean use() {
        return (randomGenerator.nextInt(chance) == 1);
    }
}

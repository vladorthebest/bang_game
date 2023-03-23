package sk.stuba.fei.uim.oop.game.bang.effects;

import sk.stuba.fei.uim.oop.game.bang.player.Player;

import java.util.Random;

public class PrisonEffect extends BaseEffect{

    private int chance;
    private Random randomGenerator = new Random();


    {
        this.chance = 8;
        this.name = "Prison";
        this.priority = 1;
        this.type = EffectType.START;
        this.disposable = true;
        this.allwaysDisposable = true;
    }

    @Override
    public boolean use(Player ownerPlayer) {
        return (randomGenerator.nextInt(chance) == 1);
    }
}

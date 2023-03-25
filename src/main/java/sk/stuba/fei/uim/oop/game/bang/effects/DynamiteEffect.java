package sk.stuba.fei.uim.oop.game.bang.effects;

import sk.stuba.fei.uim.oop.game.bang.effects.abs.ActiveEffect;
import sk.stuba.fei.uim.oop.game.bang.effects.types.EffectType;
import sk.stuba.fei.uim.oop.game.bang.player.Player;

import java.util.LinkedList;
import java.util.Random;

public class DynamiteEffect extends ActiveEffect {

    private int chance;
    private Random randomGenerator = new Random();


    {
        this.chance = 8;
        this.name = "Dynamite";
        this.priority = 1;
        this.type = EffectType.START;
        this.disposable = true;
        this.allwaysDisposable = true;
    }

    @Override
    public boolean use(Player usingPlayer) {

        LinkedList<Player> players = new LinkedList<>(usingPlayer.getPlayers());
        Player player;
        if(randomGenerator.nextInt(chance) == 1){
            usingPlayer.damageHP(3);
            return true;
        }
        for(int i=0; i<players.size(); i++){
            player = players.get(i);
            if (player == usingPlayer) {
                if(i == 0){
                    players.getLast().addEffect(this);
                }else {
                    players.get(i-1).addEffect(this);
                }
            }
        }
        return false;
    }
}
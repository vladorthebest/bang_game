package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.player.Player;

public class BangCard extends ActiveCard{

    {
        this.name = "BANG!";
        this.type = Color.BROWN;
    }

    @Override
    public void use(Player usingPlayer, Player targetPlayer) {
        if (!targetPlayer.useMissing()){
            targetPlayer.takeHP();
        }
    }
}

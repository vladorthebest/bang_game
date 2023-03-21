package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.player.Player;

public class BangCard extends BaseBrownCard{

    {
        this.name = "BANG!";
    }

    @Override
    public void use(Player usingPlayer, Player targetPlayer) {
        if (!targetPlayer.useMissing()){
            targetPlayer.takeLife();
        }
    }
}

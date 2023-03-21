package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.player.Player;

public class BeerCard extends BaseActiveCard{

    {
        this.name = "Beer";
        this.type = Color.BROWN;

    }
    @Override
    public void use(Player usingPlayer, Player targetPlayer) {
        targetPlayer.addHP(1);
    }
}

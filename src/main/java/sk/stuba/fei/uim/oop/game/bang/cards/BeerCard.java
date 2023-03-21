package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.player.Player;

public class BeerCard extends ActiveCard{

    {
        this.name = "Beer";
        this.type = Color.BROWN;
        this.target = false;
    }
    @Override
    public void use(Player usingPlayer, Player targetPlayer) {
        usingPlayer.addHP(1);
    }
}

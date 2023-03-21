package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.player.Player;

public class MissedCard extends BaseBrownCard{
    {
        this.name = "Missed";
    }

    @Override
    public void use(Player usingPlayer, Player targetPlayer) {}
}

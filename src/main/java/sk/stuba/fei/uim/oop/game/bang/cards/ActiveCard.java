package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.player.Player;

public abstract class ActiveCard extends BaseCard{
    public void use(Player usingPlayer, Player targetPlayer) {}; // Two players
}

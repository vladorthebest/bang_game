package sk.stuba.fei.uim.oop.game.bang.cards.abs;

import sk.stuba.fei.uim.oop.game.bang.player.Player;

public abstract class TargetCard extends BaseCard {
    public void use(Player usingPlayer) {}

    protected Player targeting(Player usingPlayer) {
        return usingPlayer.choiseTarget();

    }
}

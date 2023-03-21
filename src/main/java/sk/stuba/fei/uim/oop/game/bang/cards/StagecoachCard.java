package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.player.Player;

public class StagecoachCard  extends ActiveCard{
    {
        this.name = "Stagecoach";
        this.type = Color.BROWN;
        this.target = false;
    }
    @Override
    public void use(Player usingPlayer, Player targetPlayer) {
        usingPlayer.draw(2);
    }
}

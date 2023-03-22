package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.player.Player;

public class StagecoachCard  extends NoneTargetCard{
    {
        this.name = "Stagecoach";
        this.type = Color.BROWN;
    }
    @Override
    public void use(Player usingPlayer) {
        usingPlayer.draw(2);
    }
}

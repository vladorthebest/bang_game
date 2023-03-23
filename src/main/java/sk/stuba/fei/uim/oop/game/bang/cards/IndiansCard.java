package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.player.Player;

import java.util.LinkedList;

public class IndiansCard extends NoneTargetCard{

    {
        this.name = "Indians";
        this.type = Color.BROWN;
    }
    @Override
    public void use(Player usingPlayer) {
        LinkedList<BaseCard> hand;
        boolean removed = false;
        for(Player player: usingPlayer.getPlayers()){
            if (player != usingPlayer) {
                hand = player.getHandList();

                for (int i=0; i<hand.size(); i++){

                    if (hand.get(i).getName() == "BANG!"){
                        hand.remove(i);
                        removed = true;
                    }
                }
                if (!removed)
                    player.damageHP(1);

            }
        }
    }
}

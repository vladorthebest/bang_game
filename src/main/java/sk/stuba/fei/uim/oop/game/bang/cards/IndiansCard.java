package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.cards.abs.BaseCard;
import sk.stuba.fei.uim.oop.game.bang.cards.abs.NoneTargetCard;
import sk.stuba.fei.uim.oop.game.bang.cards.types.Color;
import sk.stuba.fei.uim.oop.game.bang.player.Player;

import java.util.LinkedList;

public class IndiansCard extends NoneTargetCard {

    {
        this.name = "Indians";
        this.type = Color.BROWN;
    }
    @Override
    public void use(Player usingPlayer) {
        LinkedList<BaseCard> hand;
        boolean remove = false;
        int i;
        for(Player player: usingPlayer.getPlayers()){
            if (player != usingPlayer) {
                hand = player.getHandList();

                for (i=0; i<hand.size(); i++){

                    if (hand.get(i).getName().equals("BANG!")){
                        remove = true;
                    }
                }
                if (!remove){
                    player.damageHP(1);
                } else {
                    hand.remove(i-1);
                }


            }
        }
    }
}

package sk.stuba.fei.uim.oop.game.bang;

import sk.stuba.fei.uim.oop.game.bang.player.Player;
import sk.stuba.fei.uim.oop.game.bang.share.Deck;

public class Bang {

    {
        // Create players
    }

    public void start() {
        // Game
        Deck deck = new Deck();
        Player player = new Player("lox");
        player.initDraw(deck);
        System.out.println(player.getHand());

    }

    public void turn(){
        // TODO
    }


}

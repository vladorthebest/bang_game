package sk.stuba.fei.uim.oop.game.bang;

import sk.stuba.fei.uim.oop.game.bang.player.Player;
import sk.stuba.fei.uim.oop.game.bang.share.Deck;
import sk.stuba.fei.uim.oop.game.bang.share.UserInterface;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.Iterator;
import java.util.LinkedList;

public class Bang {

    ZKlavesnice in = new ZKlavesnice();
    LinkedList<Player> players = new LinkedList<>();
    UserInterface ui = new UserInterface();
    Deck deck;
    public Bang(){
        int lenPlayers;
        do{
            lenPlayers = in.readInt("How many players? (2-4)");
            if (lenPlayers < 2 || lenPlayers > 4)
                System.out.println("Invalid input");
        } while (lenPlayers < 2 || lenPlayers > 4);

        for(int i=0; i<lenPlayers; i++){
            players.add(new Player(in.readString("Nickname for player " + (i+1)), ui, players));
        }
        ui.addPlayers(players);

    }

    public void start() {
        // Game
        deck = new Deck();

        for(Player player : players){
            player.draw(deck, player.getHP());
        }
        while (checkPlayersHP()){
            for (Iterator<Player> playerIterator = players.iterator(); playerIterator.hasNext(); ) {
                if(playerIterator.next().isDead())
                    playerIterator.remove();
            }
            for(Player player : players){
                if(!player.isDead())
                    this.turn(player);
            }
        }
        for(Player player : players){
            if(!player.isDead()){
                ui.drawWinner(player);
            }
        }

    }


    private boolean checkPlayersHP(){
        int countLife = 0;
        for(Player player : players){
            if(!player.isDead()){
                countLife += 1;
            }
        }
        if(countLife >= 2){
            return true;
        }
        return false;

    }

    private  void turn(Player player){
        if(!player.isDead()){
            ui.drawStartTurn();
            player.getUiPlayer().drawOwnerTurn();
            player.sortTable();
            if(!player.useStartEffects()){
                System.out.println("Skip turn");
                return;
            }
            player.draw(2);
            ui.drawPlayers();
            player.getUiPlayer().drawPlayersHand();
            player.getUiPlayer().drawPlayersTable();

            player.playCard();
            if(!player.isDead()) {
                player.discarding();
                player.sortTable();
            }
        }
    }

}

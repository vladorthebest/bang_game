package sk.stuba.fei.uim.oop.game.bang;

import sk.stuba.fei.uim.oop.game.bang.player.Player;
import sk.stuba.fei.uim.oop.game.bang.player.abs.BasePlayer;
import sk.stuba.fei.uim.oop.game.bang.share.Deck;
import sk.stuba.fei.uim.oop.game.bang.share.ResetDeck;
import sk.stuba.fei.uim.oop.game.bang.share.UserInterface;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.LinkedList;

public class Bang {

    LinkedList<Player> players = new LinkedList<>();
    UserInterface ui = new UserInterface();
    Deck deck;
    ResetDeck resetDeck;
    public Bang(){
        int lenPlayers;
        do{
            lenPlayers = ZKlavesnice.readInt("How many players? (2-4)");
            if (lenPlayers < 2 || lenPlayers > 4)
                System.out.println("Invalid input");
        } while (lenPlayers < 2 || lenPlayers > 4);

        for(int i=0; i<lenPlayers; i++){
            players.add(new Player(ZKlavesnice.readString("Nickname for player " + (i+1)), ui, players));
        }
        ui.addPlayers(players);

    }

    public void start() {
        // Game
        deck = new Deck();
        resetDeck = new ResetDeck();

        for(Player player : players){
            player.draw(deck, player.getHP(), resetDeck);
        }
        while (checkPlayersHP()){
            players.removeIf(BasePlayer::isDead);
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
        if(countLife >= 2)
            return true;
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

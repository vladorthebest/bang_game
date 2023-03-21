package sk.stuba.fei.uim.oop.game.bang;

import sk.stuba.fei.uim.oop.game.bang.player.Player;
import sk.stuba.fei.uim.oop.game.bang.share.Deck;
import sk.stuba.fei.uim.oop.game.bang.share.UserInterface;

import java.util.LinkedList;
import java.util.Scanner;

public class Bang {

    Scanner in = new Scanner(System.in);
    LinkedList<Player> players = new LinkedList<>();
    UserInterface ui = new UserInterface();
    Deck deck;
    public Bang(){
        System.out.println("How many players?");
        int lenPlayers = in.nextInt();
        for(int i=0; i<lenPlayers; i++){
            System.out.println("Nickname for player " + (i+1));
            players.add(new Player(in.next()));
        }

    }

    public void start() {
        // Game
        deck = new Deck();
        for(Player player : players){
            player.initDraw(deck);
            System.out.println( player.getNickname() + player.getHand());
        }

        for(Player player : players){
            this.turn(player);
            System.out.println(player.getNickname() + player.getHand());
        }

    }

    public void turn(Player player){
        ui.drawStartTurn();
        ui.drawOwnerTurn(player);
        player.draw(2);
        ui.drawPlayersHand(player);
        player.playCard(players);
        player.discarding();
    }


}

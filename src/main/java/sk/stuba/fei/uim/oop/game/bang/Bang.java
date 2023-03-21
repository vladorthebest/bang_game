package sk.stuba.fei.uim.oop.game.bang;

import sk.stuba.fei.uim.oop.game.bang.player.Player;
import sk.stuba.fei.uim.oop.game.bang.share.Deck;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.LinkedList;
import java.util.Scanner;

public class Bang {

    Scanner in = new Scanner(System.in);
    LinkedList<Player> players = new LinkedList<Player>();

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
        Deck deck = new Deck();
        for(Player player : players){
            player.initDraw(deck);
            System.out.println(player.getNickname() + player.getHand());
        }


    }

    public void turn(){
        // TODO
    }


}

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
            players.add(new Player(in.next(), ui));
        }
        ui.addPlayers(players);

    }

    public void start() {
        // Game
        deck = new Deck();

            for(Player player : players){
                player.initDraw(deck);
                System.out.println( player.getNickname() + player.getHand());
            }
        while (checkPlayersHP()){
            for(Player player : players){
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
            ui.drawOwnerTurn(player);
            player.sortTable();
            player.draw(2);
            ui.drawPlayersHand(player);
            ui.drawPlayersTable(player);
            player.playCard(players);
            player.discarding();
            player.sortTable();
        }
    }

}

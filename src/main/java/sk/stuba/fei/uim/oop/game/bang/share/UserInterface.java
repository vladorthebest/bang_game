package sk.stuba.fei.uim.oop.game.bang.share;

import sk.stuba.fei.uim.oop.game.bang.player.Player;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.LinkedList;

public class UserInterface {

    LinkedList<Player> players;
    ZKlavesnice in = new ZKlavesnice();

    public void addPlayers(LinkedList<Player> players){
        this.players = players;
    }

    public void drawStartTurn(){
        System.out.println("=======================================================================================================================");
    }

    public Player choiseTarget() {
        while (true) {
            int indexPlayer = in.readInt("Input index target player: ") - 1;
            if (indexPlayer < 0) {
                break;
            } else if (indexPlayer >= players.size()) {
                System.out.println("Invalid index");
            } else {
                return players.get(indexPlayer);
            }
        }
        return null;
    }

    public void drawWinner(Player player) {
        System.out.println("\u001b[33;1m" + "Winner: " + player.getNickname() + "\u001b[0m");

    }

    public void drawPlayers(){
        int i=1;
        for(Player player: players){
            System.out.printf("Player%d: %s  HP: %d\n", i, player.getNickname(), player.getHP());
            i++;
        }
    }
}

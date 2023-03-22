package sk.stuba.fei.uim.oop.game.bang.share;

import sk.stuba.fei.uim.oop.game.bang.player.Player;

import java.util.LinkedList;
import java.util.Scanner;

public class UserInterface {

    LinkedList<Player> players;
    Scanner in = new Scanner(System.in);

    public void addPlayers(LinkedList<Player> players){
        this.players = players;
    }

    public void drawStartTurn(){
        System.out.println("=======================================================");
    }

    public void drawOwnerTurn(Player player){
        System.out.println("Turn " + player.getNickname());
    }

    public void drawPlayer(Player player){
        System.out.printf(buildPlayerBlock(player));
    }
    public void drawPlayersHand(Player player){
        System.out.println(player.getHand());
    }

    private String buildPlayerBlock(Player player){
        StringBuilder playerBlock = new StringBuilder("");
        String nicknameLine = nicknameLine(player.getNickname());
        String hpLine = hpLine(player.getHP(), nicknameLine.length());
        String topLine = topLine(nicknameLine.length());
        String midLine = midLine(nicknameLine.length());
        playerBlock.append(topLine);
        playerBlock.append(midLine);
        playerBlock.append(nicknameLine);
        playerBlock.append(hpLine);
        playerBlock.append(midLine);
        playerBlock.append(topLine);
        return playerBlock.toString();
    }
    private String nicknameLine(String nickname) {
        StringBuilder str = new StringBuilder("|  Nickname: ");
        str.append(nickname);
        str.append("  |");
        str.append("\n");
        return str.toString();
    }
    private String hpLine(int hp, int width) {
        StringBuilder str = new StringBuilder("|  HP: " + hp);

        for(int i = str.length(); i<width-2; i++){
            str.append(" ");
        }
        str.append("|");
        str.append("\n");
        return str.toString();
    }

    private String topLine(int width){
        StringBuilder str = new StringBuilder("+");
        for(int i=0; i<width-3; i++){
            str.append("-");
        }
        str.append("+");
        str.append("\n");
        return str.toString();
    }
    private String midLine(int width){
        StringBuilder str = new StringBuilder("|");
        for(int i=0; i<width-3; i++){
            str.append(" ");
        }
        str.append("|");
        str.append("\n");
        return str.toString();
    }

    public Player choiseTarget(){
        while (true){
            System.out.print("Input index target player: ");
            int indexPlayer = in.nextInt() - 1;
            if(indexPlayer < 0){
                break;
            }else if(indexPlayer >= players.size()){
                System.out.println("Invalid index");
            }else {
                return players.get(indexPlayer);
            }
        }
        return null;
    }
}

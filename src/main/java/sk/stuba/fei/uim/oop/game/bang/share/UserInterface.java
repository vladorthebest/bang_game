package sk.stuba.fei.uim.oop.game.bang.share;

import sk.stuba.fei.uim.oop.game.bang.player.Player;

public class UserInterface {
    public void drawStartTurn(){
        System.out.println("=======================================================");
    }

    public void drawOwnerTurn(Player player){
        System.out.println("Turn " + player.getNickname());
    }

    public void drawPlayer(Player player){
        System.out.printf("Name: %s HP: %d\n"  , player.getNickname(), player.getHP() );
    }
    public void drawPlayersHand(Player player){
        System.out.println(player.getHand());
    }
}

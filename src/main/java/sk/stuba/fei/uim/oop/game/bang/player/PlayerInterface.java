package sk.stuba.fei.uim.oop.game.bang.player;

public class PlayerInterface {
    private Player player;
    private  StringBuilder playerAnonyBlock;

    public PlayerInterface(Player owner){
        this.player = owner;
    }
    public void drawOwnerTurn(){
        System.out.println("Turn " + player.getNickname());
    }

    public void drawPlayersHand(){
        System.out.println(player.getHand());
    }
    public void drawPlayersTable(){
        System.out.println(player.getTable());
    }

    public void drawPlayer(){

        String nicknameLine = nicknameLine();
        String hpLine = hpLine(nicknameLine.length());
        System.out.println(this.buildPlayerBlock(hpLine, nicknameLine));
    }

    private String buildPlayerBlock(String hpLine, String nicknameLine){
        String topLine = topLine(nicknameLine.length());
        String midLine = midLine(nicknameLine.length());
        StringBuilder playerBlock = new StringBuilder("");
        playerBlock.append(topLine);
        playerBlock.append(midLine);
        playerBlock.append(nicknameLine);
        playerBlock.append(hpLine);
        playerBlock.append(midLine);
        playerBlock.append(topLine);
        return  playerBlock.toString();
    }


    private String nicknameLine() {
        StringBuilder str = new StringBuilder("|  Nickname: ");
        str.append(player.getNickname());
        str.append("  |");
        str.append("\n");
        return str.toString();
    }
    private String hpLine(int width) {
        StringBuilder str = new StringBuilder("|  " + "\u001b[31;1m" + "HP: " + player.getHP());

        for(int i = str.length(); i<width-2+"\u001b[31;1m".length(); i++){
            str.append(" ");
        }
        str.append("\u001b[0m");
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

}

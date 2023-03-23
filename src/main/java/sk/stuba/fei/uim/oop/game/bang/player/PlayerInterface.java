package sk.stuba.fei.uim.oop.game.bang.player;

public class PlayerInterface {
    private Player player;

    public PlayerInterface(Player owner){
        this.player = owner;
    }
    public void drawOwnerTurn(){
        System.out.println("Turn " + player.getNickname());
    }

    public void drawPlayer(){
        System.out.printf(buildPlayerBlock());
    }

    public void drawPlayersHand(){
        System.out.println(player.getHand());
    }
    public void drawPlayersTable(){
        System.out.println(player.getTable());
    }

    private String buildPlayerBlock(){
        StringBuilder playerBlock = new StringBuilder("");
        String nicknameLine = nicknameLine();
        String hpLine = hpLine(nicknameLine.length());
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
    private String nicknameLine() {
        StringBuilder str = new StringBuilder("|  Nickname: ");
        str.append(player.getNickname());
        str.append("  |");
        str.append("\n");
        return str.toString();
    }
    private String hpLine(int width) {
        StringBuilder str = new StringBuilder("|  HP: " + player.getHP());

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

}

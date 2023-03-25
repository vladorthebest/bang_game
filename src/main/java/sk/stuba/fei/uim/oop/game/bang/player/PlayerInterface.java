package sk.stuba.fei.uim.oop.game.bang.player;

public class PlayerInterface {
    private Player player;

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
        return topLine +
                midLine +
                nicknameLine +
                hpLine +
                midLine +
                topLine;
    }


    private String nicknameLine() {
        return "|  Nickname: " + player.getNickname() +
                "  |" +
                "\n";
    }
    private String hpLine(int width) {
        StringBuilder str = new StringBuilder("|  " + "\u001b[31;1m" + "HP: " + player.getHP());

        str.append(" ".repeat(Math.max(0, width - 2 + "\u001b[31;1m".length() - str.length())));
        str.append("\u001b[0m");
        str.append("|");
        str.append("\n");
        return str.toString();
    }

    private String topLine(int width){
        return "+" + "-".repeat(Math.max(0, width - 3)) +
                "+" +
                "\n";
    }
    private String midLine(int width){
        return "|" + " ".repeat(Math.max(0, width - 3)) +
                "|" +
                "\n";
    }

}

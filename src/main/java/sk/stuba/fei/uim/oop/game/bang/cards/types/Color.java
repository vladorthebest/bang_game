package sk.stuba.fei.uim.oop.game.bang.cards.types;

public enum  Color {
    BLUE("\033[0;34m"),
    BROWN("\u001b[33;1m");

    private String ansiCode;

    public String get() {
        return ansiCode;
    }

    Color(String ansiCode) {
        this.ansiCode = ansiCode;
    }

}

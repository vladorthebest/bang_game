package sk.stuba.fei.uim.oop.game.bang.player;

import sk.stuba.fei.uim.oop.game.bang.share.Deck;
import sk.stuba.fei.uim.oop.game.bang.cards.BaseCard;
import java.util.LinkedList;

public class Player {
    private String nickname;
    private int hp;
    private boolean isDead;
    // Hand with cards
    private LinkedList<BaseCard> hand;

    // Table with cards
    private LinkedList<BaseCard> table;

    public Player(String nickname){
        this.nickname = nickname;
        this.hp = 4;
        this.hand = new LinkedList<BaseCard>();
        this.table = new LinkedList<BaseCard>();
    }

    public void draw (Deck deck){
        return;
    }

    public void initDraw (Deck deck){
        for (int i = 0; i < this.hp; i++) {
            hand.add(deck.draw());
        }
    }
    public String getHand(){
        if (hand.isEmpty())
            return "No cards";
        StringBuilder sb = new StringBuilder();
        int index = 1;
        for (BaseCard card : hand) {
            sb.append(index++);
            sb.append(" ");
            sb.append(card.name);
            sb.append(", ");
        }
        return sb.toString();
    }

}

package sk.stuba.fei.uim.oop.game.bang.player;

import sk.stuba.fei.uim.oop.game.bang.cards.ActiveCard;
import sk.stuba.fei.uim.oop.game.bang.cards.EmptyCard;
import sk.stuba.fei.uim.oop.game.bang.share.Deck;
import sk.stuba.fei.uim.oop.game.bang.cards.BaseCard;
import java.util.LinkedList;
import java.util.Scanner;

public class Player {


    private StringBuilder nickname;
    Scanner in = new Scanner(System.in);
    private int hp;
    private boolean isDead;
    // Hand with cards
    private LinkedList<BaseCard> hand;

    // Table with cards
    private LinkedList<BaseCard> table;

    public Player(String nickname){
        this.nickname = new StringBuilder(nickname);
        this.hp = 4;
        this.hand = new LinkedList<BaseCard>();
        this.table = new LinkedList<BaseCard>();
    }

    public void draw (Deck deck){
        for (int i = 0; i < 2; i++) {
            hand.add(deck.draw());
        }
    }

    public void initDraw (Deck deck){
        for (int i = 0; i < this.hp; i++) {
            hand.add(deck.draw());
        }
    }

    public void discarding(){
        for (int i = hand.size(); i > this.hp; i--) {
            hand.remove();
        }
    }

    public String getNickname() {
        return nickname.toString();
    }

    public String getHand(){
        if (hand.isEmpty())
            return "No cards";
        StringBuilder sb = new StringBuilder();
        int index = 1;
        for (BaseCard card : hand) {
            sb.append(index++);
            sb.append(" ");
            sb.append(card);
            sb.append(", ");
        }
        return sb.toString();
    }

    public boolean useMissing(){
        return true;
    }

    public void takeHP(){

    }

    public void addHP(int hp){
        this.hp += hp;
    }

    public void playCard(LinkedList<Player> players){
        BaseCard card;
        System.out.println("Turn " + this.nickname);

        while (true){
            card = this.choiseCard();
            if(card.toString().isEmpty()){
                break;
            }
            if(card.needTarget()){
                card.use(this, this.choiseTarget(players));
            }else {
                card.use(this, this);
            }

            System.out.println(this.getNickname() + this.getHand());
        }
    }

    private BaseCard choiseCard(){
        int indexCard = -1;
        BaseCard card = new EmptyCard();
        while (true){
            System.out.print("Input index card: ");
            indexCard = in.nextInt() - 1;
            if(indexCard == -1){
                break;
            }else if(indexCard > hand.size()){
                System.out.println("Invalid index");
            }else {
                card = this.hand.get(indexCard);
                this.hand.remove(indexCard);
                break;
            }
        }
        return card;
    }

    private Player choiseTarget(LinkedList<Player> players){
        System.out.print("Input index target player: ");
        int indexPlayer = in.nextInt() - 1;
        return players.get(indexPlayer);
    }

}

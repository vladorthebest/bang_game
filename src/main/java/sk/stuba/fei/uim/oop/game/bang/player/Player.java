package sk.stuba.fei.uim.oop.game.bang.player;

import sk.stuba.fei.uim.oop.game.bang.cards.ActiveCard;
import sk.stuba.fei.uim.oop.game.bang.cards.EmptyCard;
import sk.stuba.fei.uim.oop.game.bang.share.Deck;
import sk.stuba.fei.uim.oop.game.bang.cards.BaseCard;
import sk.stuba.fei.uim.oop.game.bang.share.UserInterface;

import java.util.LinkedList;
import java.util.Scanner;

public class Player {

    private UserInterface ui;
    private StringBuilder nickname;
    Scanner in = new Scanner(System.in);
    private int hp;
    private boolean isDead;
    // Hand with cards
    private LinkedList<BaseCard> hand;

    private Deck deck;

    // Table with cards
    private LinkedList<BaseCard> table;

    public Player(String nickname, UserInterface ui){
        this.ui = ui;
        this.nickname = new StringBuilder(nickname);
        this.hp = 4;
        this.hand = new LinkedList<BaseCard>();
        this.table = new LinkedList<BaseCard>();
    }

    public void draw (int count){
        for (int i = 0; i < count; i++) {
            hand.add(this.deck.draw());
        }
    }

    public void initDraw (Deck deck){
        this.deck = deck;
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

    public int getHP(){
        return this.hp;
    }

    public void playCard(LinkedList<Player> players){
        BaseCard card;
        Player player;
        while (true){
            ui.drawPlayer(this);
            card = this.choiseCard();
            if(card == null){
                break;
            }

            if(card.needTarget()){
                player = ui.choiseTarget();
                if(player == null){
                    break;
                }
                card.use(this, player);
            }else {
                card.use(this, this);
            }
            ui.drawPlayersHand(this);

        }
    }

    private BaseCard choiseCard(){
        int indexCard = -1;
        BaseCard card = new EmptyCard();
        while (true){
            System.out.print("Input index card: ");
            indexCard = in.nextInt() - 1;
            if(indexCard < 0){
                break;
            }else if(indexCard >= hand.size()){
                System.out.println("Invalid index");
            }else {
                card = this.hand.get(indexCard);
                this.hand.remove(indexCard);
                return card;
            }
        }
        return null;
    }

    public void addCard(BaseCard card){
        this.hand.add(card);
    }

}

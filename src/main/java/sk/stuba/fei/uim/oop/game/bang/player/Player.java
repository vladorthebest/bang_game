package sk.stuba.fei.uim.oop.game.bang.player;

import sk.stuba.fei.uim.oop.game.bang.cards.EmptyCard;
import sk.stuba.fei.uim.oop.game.bang.effects.BaseEffect;
import sk.stuba.fei.uim.oop.game.bang.effects.EffectType;
import sk.stuba.fei.uim.oop.game.bang.effects.MissedEffect;
import sk.stuba.fei.uim.oop.game.bang.share.Deck;
import sk.stuba.fei.uim.oop.game.bang.cards.BaseCard;
import sk.stuba.fei.uim.oop.game.bang.share.UserInterface;

import java.text.Collator;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Player {

    // ARGUMENTS

    private UserInterface ui;
    private StringBuilder nickname;
    Scanner in = new Scanner(System.in);
    private int hp;
    private boolean isDead = false;
    // Hand with cards
    private LinkedList<BaseCard> hand;
    private LinkedList<BaseEffect> table;
    private Deck deck;


    // CONSTRUCTOR
    public Player(String nickname, UserInterface ui){
        this.ui = ui;
        this.nickname = new StringBuilder(nickname);
        this.hp = 4;
        this.hand = new LinkedList<>();
        this.table = new LinkedList<>();
        this.table.add(new MissedEffect());
    }


    // DRAW
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


    // GET
    public String getNickname() {
        return nickname.toString();
    }

    public boolean isDead() {
        if(this.hp == 0){
            this.isDead = true;
        }
        return isDead;
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

    public String getTable(){
        if (table.isEmpty())
            return "No Effects";
        StringBuilder sb = new StringBuilder();
        int index = 1;
        for (BaseEffect effect : table) {
            sb.append(" ");
            sb.append(table);
            sb.append(", ");
        }
        return sb.toString();
    }

    public LinkedList<BaseCard> getHandList(){
        return hand;
    }
    public LinkedList<BaseEffect> getTableList(){
        return table;
    }

    // USE EFFECTS

    public boolean addEffect(BaseEffect effect){
        table.add(effect);
        return true;
    }
    public void sortTable(){
        table.sort( new Comparator<BaseEffect>(){
            @Override
            public int compare(BaseEffect a,BaseEffect b){
                return b.getPriority() - a.getPriority();
            }
        });
    }

    public void useStartEffects(){
        for(BaseEffect effect : table){
            if(effect.getType() == EffectType.START){
                effect.use(this);
                table.remove(effect);
            }
        }
    }

    public boolean useMissingEffects(){
        boolean isWorked = false;
        for (Iterator<BaseEffect> iterator = table.iterator(); iterator.hasNext(); ) {
            BaseEffect effect = iterator.next();
            if(effect.getType() == EffectType.MISS){
                isWorked = effect.use(this);
                if(effect.isDisposable())
                    iterator.remove();
            }
        }
        return isWorked;
    }

    // HP
    public void damageHP(int dmg){
        this.hp -= dmg;
    }

    public void addHP(int hp){
        this.hp += hp;
    }

    public int getHP(){
        return this.hp;
    }

    // PLAY CARD
    public void playCard(LinkedList<Player> players){
        BaseCard card;
        Player player;
        while (true){
            ui.drawPlayer(this);
            card = this.choiseCard();
            if(card == null){
                break;
            }
            card.use(this);

            ui.drawPlayersHand(this);

        }
    }

    private BaseCard choiseCard(){
        int indexCard = -1;
        BaseCard card;
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

    public Player choiseTarget() {
        return ui.choiseTarget();
    }

}

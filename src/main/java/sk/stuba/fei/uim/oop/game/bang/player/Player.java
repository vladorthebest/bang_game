package sk.stuba.fei.uim.oop.game.bang.player;

import sk.stuba.fei.uim.oop.game.bang.cards.EmptyCard;
import sk.stuba.fei.uim.oop.game.bang.effects.BaseEffect;
import sk.stuba.fei.uim.oop.game.bang.effects.EffectType;
import sk.stuba.fei.uim.oop.game.bang.effects.MissedEffect;
import sk.stuba.fei.uim.oop.game.bang.share.Deck;
import sk.stuba.fei.uim.oop.game.bang.cards.BaseCard;
import sk.stuba.fei.uim.oop.game.bang.share.UserInterface;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.text.Collator;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Player extends BasePlayer{

    // ARGUMENTS
    private UserInterface ui;
    LinkedList<Player> players;
    private PlayerInterface uiPlayer;
    ZKlavesnice in = new ZKlavesnice();
    private Deck deck;


    // CONSTRUCTOR
    public Player(String nickname, UserInterface ui, LinkedList<Player> players){
        super(nickname);
        this.uiPlayer = new PlayerInterface(this);
        this.ui = ui;
        this.players = players;
    }

    public Player(UserInterface ui){
        super("Anonymous");
        this.uiPlayer = new PlayerInterface(this);
        this.ui = ui;
    }

    public PlayerInterface getUiPlayer() {
        return uiPlayer;
    }

    // DRAW
    public void draw (int count){
        for (int i = 0; i < count; i++) {
            hand.add(this.deck.draw());
        }
    }

    public void draw (Deck deck, int count){
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

    // USE EFFECTS

    public boolean addEffect(BaseEffect effect){
        for(BaseEffect alreadyEffect: table){
            if(alreadyEffect.toString() == effect.toString()){
                return false;
            }
        }
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

    public boolean useStartEffects(){
        boolean isWorked = false;
        for (Iterator<BaseEffect> iterator = table.iterator(); iterator.hasNext(); ) {
            BaseEffect effect = iterator.next();
            if(effect.getType() == EffectType.START){
                isWorked = effect.use(this);
                if( (effect.isDisposable() && isWorked) || effect.isAllwaysDisposable())
                    iterator.remove();

                if(this.isDead() || (effect.getName() == "Prison" && isWorked == true))
                    return false;
            }
        }
        return true;
    }

    public boolean useMissingEffects(){
        boolean isWorked = false;
        for (Iterator<BaseEffect> iterator = table.iterator(); iterator.hasNext(); ) {
            BaseEffect effect = iterator.next();
            if(effect.getType() == EffectType.MISS){
                isWorked = effect.use(this);
                if(effect.isDisposable() && isWorked)
                    iterator.remove();
                if (isWorked)
                    break;
            }
        }
        return isWorked;
    }

    // PLAY CARD
    public void playCard(){
        BaseCard card;
        Player player;
        while (true){
            uiPlayer.drawPlayer();
            card = this.choiseCard();
            if(card == null){
                break;
            }
            card.use(this);
            ui.drawPlayers();
            uiPlayer.drawPlayersHand();
            uiPlayer.drawPlayersTable();

        }
    }

    private BaseCard choiseCard(){
        int indexCard = -1;
        BaseCard card;
        while (true){
            indexCard = in.readInt("Input index card: ") - 1;
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

    public LinkedList<Player> getPlayers() {
        return players;
    }
}

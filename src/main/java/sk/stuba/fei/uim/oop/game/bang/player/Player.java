package sk.stuba.fei.uim.oop.game.bang.player;

import sk.stuba.fei.uim.oop.game.bang.cards.types.Color;
import sk.stuba.fei.uim.oop.game.bang.effects.abs.BaseEffect;
import sk.stuba.fei.uim.oop.game.bang.effects.types.EffectType;
import sk.stuba.fei.uim.oop.game.bang.player.abs.BasePlayer;
import sk.stuba.fei.uim.oop.game.bang.share.Deck;
import sk.stuba.fei.uim.oop.game.bang.cards.abs.BaseCard;
import sk.stuba.fei.uim.oop.game.bang.share.ResetDeck;
import sk.stuba.fei.uim.oop.game.bang.share.UserInterface;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.Iterator;
import java.util.LinkedList;

public class Player extends BasePlayer {

    // ARGUMENTS
    private UserInterface ui;
    LinkedList<Player> players;
    private PlayerInterface uiPlayer;
    private Deck deck;
    private ResetDeck resetDeck;

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
        BaseCard card;
        for (int i = 0; i < count; i++) {
            card = deck.draw();
            System.out.println(card);
            if(card == null){

                deck.getCards().addAll(resetDeck.getCards());
                System.out.println(deck.toString());
                card = deck.draw();
            }
            hand.add(card);
        }
    }

    public void draw (Deck deck, int count, ResetDeck resetDeck){
        this.deck = deck;
        this.resetDeck = resetDeck;
        BaseCard card;
        for (int i = 0; i < count; i++) {
            card = deck.draw();
            if(card == null){
                System.out.println("Deck is empty");
                deck.getCards().addAll(resetDeck.getCards());
                card = deck.draw();
            }
            hand.add(card);
        }
    }

    public ResetDeck getResetDeck() {
        return resetDeck;
    }

    public void discarding(){
        for (int i = hand.size(); i > this.hp; i--) {
            resetDeck.addCard(hand.getLast());
            hand.removeLast();
        }
    }

    // USE EFFECTS

    public boolean addEffect(BaseEffect effect){
        for(BaseEffect alreadyEffect: table){
            if(alreadyEffect.toString().equals(effect.toString())){
                return false;
            }
        }
        table.add(effect);
        return true;
    }


    public void sortTable(){
        table.sort((a, b) -> b.getPriority() - a.getPriority());
    }

    public boolean useStartEffects(){
        boolean isWorked;
        for (Iterator<BaseEffect> iterator = table.iterator(); iterator.hasNext(); ) {
            BaseEffect effect = iterator.next();
            if(effect.getType() == EffectType.START){
                isWorked = effect.use(this);
                if( (effect.isDisposable() && isWorked) || effect.isAllwaysDisposable())
                    iterator.remove();

                if(this.isDead() || (effect.getName().equals("Prison") && isWorked))
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
                if(effect.isDisposable() && isWorked){
                    iterator.remove();
                }
                if (isWorked)
                    break;
            }
        }
        return isWorked;
    }

    // PLAY CARD
    public void playCard(){
        BaseCard card;
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
        int indexCard;
        BaseCard card;
        while (true){
            indexCard = ZKlavesnice.readInt("Input index card: ") - 1;
            if(indexCard < 0){
                break;
            }else if(indexCard >= hand.size()){
                System.out.println("Invalid index");
            }else {
                card = this.hand.get(indexCard);
                if(card.getType() == Color.BROWN)
                    resetDeck.addCard(hand.get(indexCard));
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

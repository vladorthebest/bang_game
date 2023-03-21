package sk.stuba.fei.uim.oop.game.bang.share;

import sk.stuba.fei.uim.oop.game.bang.cards.BangCard;
import sk.stuba.fei.uim.oop.game.bang.cards.BaseCard;
import sk.stuba.fei.uim.oop.game.bang.cards.MissedCard;

import java.util.LinkedList;
import java.util.Random;

public class Deck {
    private final int COUNT_MISSED = 15;
    private final int COUNT_BANG = 30;

    private LinkedList<BaseCard> cards;
    Random randomGenerator = new Random();
    {
        cards = new LinkedList<BaseCard>();
    }

    public Deck(){
        for(int i=0; i<COUNT_MISSED; i++){
            cards.add(new MissedCard());
        }

        for(int i=0; i<COUNT_BANG; i++){
            cards.add(new BangCard());
        }
    }

    public BaseCard draw(){
        int len = cards.size();
        int randomInt = randomGenerator.nextInt(len);
        BaseCard card = cards.get(randomInt);
        cards.remove(randomInt);
        return card;
    }
}

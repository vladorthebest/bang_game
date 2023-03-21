package sk.stuba.fei.uim.oop.game.bang.share;

import sk.stuba.fei.uim.oop.game.bang.cards.BaseCard;

import java.util.LinkedList;
import java.util.Random;

public class Deck {
    private LinkedList<BaseCard> cards;
    Random randomGenerator = new Random();
    {
        cards = new LinkedList<BaseCard>();
    }

    public Deck(){
        for(int i=0; i<30; i++){
            cards.add(new BaseBlueCard());
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

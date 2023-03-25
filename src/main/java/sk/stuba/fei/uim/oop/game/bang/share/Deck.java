package sk.stuba.fei.uim.oop.game.bang.share;

import sk.stuba.fei.uim.oop.game.bang.cards.*;
import sk.stuba.fei.uim.oop.game.bang.cards.abs.BaseCard;

import java.util.LinkedList;
import java.util.Random;

public class Deck {
    private final int COUNT_MISSED = 15; // 15
    private final int COUNT_BANG = 30; // 30
    private final int COUNT_BEER = 8; // 8
    private final int COUNT_STAGECOACH = 4; // 4
    private final int COUNT_BARREL = 2; // 2
    private final int COUNT_PRISON = 3; // 3
    private final int COUNT_CAT_BALOU = 6; // 6
    private final int COUNT_INDIANS = 2; // 2
    private final int COUNT_DYNAMITE = 1; // 1

    private LinkedList<BaseCard> cards;
    Random randomGenerator = new Random();
    {
        cards = new LinkedList<>();
    }

    public Deck(){
        for(int i=0; i<COUNT_MISSED; i++){
            cards.add(new MissedCard());
        }
        for(int i=0; i<COUNT_DYNAMITE; i++){
            cards.add(new DynamiteCard());
        }

        for(int i=0; i<COUNT_BANG; i++){
            cards.add(new BangCard());
        }
        for(int i=0; i<COUNT_BEER; i++){
            cards.add(new BeerCard());
        }
        for(int i=0; i<COUNT_STAGECOACH; i++){
            cards.add(new StagecoachCard());
        }
        for(int i=0; i<COUNT_BARREL; i++){
            cards.add(new BarrelCard());
        }
        for(int i=0; i<COUNT_PRISON; i++){
            cards.add(new PrisonCard());
        }
        for(int i=0; i<COUNT_CAT_BALOU; i++){
            cards.add(new CatBalouCard());
        }
        for(int i=0; i<COUNT_INDIANS; i++){
            cards.add(new IndiansCard());
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

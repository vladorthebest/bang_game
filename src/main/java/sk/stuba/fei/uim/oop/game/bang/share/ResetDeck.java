package sk.stuba.fei.uim.oop.game.bang.share;

import sk.stuba.fei.uim.oop.game.bang.cards.abs.BaseCard;

import java.util.LinkedList;

public class ResetDeck {
    private LinkedList<BaseCard> cards;

    {
        cards = new LinkedList<>();
    }

    public LinkedList<BaseCard> getCards() {
        return cards;
    }

    public void addCard(BaseCard card){
        cards.add(card);
    }
}

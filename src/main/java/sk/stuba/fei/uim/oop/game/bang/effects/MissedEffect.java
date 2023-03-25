package sk.stuba.fei.uim.oop.game.bang.effects;

import sk.stuba.fei.uim.oop.game.bang.cards.abs.BaseCard;
import sk.stuba.fei.uim.oop.game.bang.effects.abs.PassiveEffect;
import sk.stuba.fei.uim.oop.game.bang.effects.types.EffectType;
import sk.stuba.fei.uim.oop.game.bang.player.Player;

import java.util.Iterator;

public class MissedEffect extends PassiveEffect {
    {
        this.name = "";
        this.priority = 2;
        this.type = EffectType.MISS;
        this.disposable = false;
        this.allwaysDisposable = false;
    }

    @Override
    public boolean use(Player ownerPlayer) {
        Iterator<BaseCard> iterator = ownerPlayer.getHandList().iterator();
        while (iterator.hasNext()) {
            BaseCard card = iterator.next();

            if(card.getName().equals("Missed")){
                ownerPlayer.getResetDeck().addCard(card);
                iterator.remove();
                return true;
            }

        }

        return false;
    }
}

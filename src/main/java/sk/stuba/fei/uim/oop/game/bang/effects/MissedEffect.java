package sk.stuba.fei.uim.oop.game.bang.effects;

import sk.stuba.fei.uim.oop.game.bang.cards.BaseCard;
import sk.stuba.fei.uim.oop.game.bang.player.Player;

import java.util.Iterator;

public class MissedEffect extends PassiveEffect{
    {
        this.name = "Miss";
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
                iterator.remove();
                return true;
            }

        }

        return false;
    }
}

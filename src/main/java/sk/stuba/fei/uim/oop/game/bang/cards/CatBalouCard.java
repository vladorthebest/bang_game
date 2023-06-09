package sk.stuba.fei.uim.oop.game.bang.cards;

import sk.stuba.fei.uim.oop.game.bang.cards.abs.BaseCard;
import sk.stuba.fei.uim.oop.game.bang.cards.abs.TargetCard;
import sk.stuba.fei.uim.oop.game.bang.cards.types.Color;
import sk.stuba.fei.uim.oop.game.bang.effects.abs.BaseEffect;
import sk.stuba.fei.uim.oop.game.bang.player.Player;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class CatBalouCard extends TargetCard {
    private Random randomGenerator = new Random();

    {
        this.name = "Cat Balou";
        this.type = Color.BROWN;
    }

    @Override
    public void use(Player usingPlayer) {
        Player targetPlayer = super.targeting(usingPlayer);
        LinkedList<BaseEffect> buf = new LinkedList<>();
        LinkedList<BaseEffect> targetTable = targetPlayer.getTableList();

        for (Iterator<BaseEffect> iterator = targetTable.iterator(); iterator.hasNext(); ) {
            BaseEffect effect = iterator.next();
            if(effect.isPassive()){
                buf.add(effect);
                iterator.remove();
            }
        }


        if (!checkTableHand(targetPlayer)){
            System.out.println("You cant use this card");
            usingPlayer.addCard(this);
        }

        targetTable.addAll(buf);

    }
    private boolean checkTableHand(Player targetPlayer){
        LinkedList<BaseEffect> targetTable = targetPlayer.getTableList();
        LinkedList<BaseCard> targetHand = targetPlayer.getHandList();

        if(targetHand.isEmpty() && targetTable.isEmpty()){
            System.out.println("Hand and Table are empty");
            return false;
        }else if (targetHand.isEmpty()){
            System.out.println("Hand is empty");
            discardingEffect(targetTable);
        } else if (targetTable.isEmpty()) {
            System.out.println("Table is empty");
            discardingCard(targetHand);
        } else {
            switch (ZKlavesnice.readInt("Choise: \n 1) Hand 2) Table")){
                case 1:
                    discardingCard(targetHand);
                    break;
                case 2:
                    discardingEffect(targetTable);
                    break;
            }
        }
        return true;
    }
    private void discardingCard(LinkedList<BaseCard> hand){
        int index = randomGenerator.nextInt(hand.size()-1);
        hand.remove(index);
    }
    private void discardingEffect(LinkedList<BaseEffect> table){
        int index = randomGenerator.nextInt(table.size());
        table.remove(index);
    }
}

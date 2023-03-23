package sk.stuba.fei.uim.oop.game.bang.player;

import sk.stuba.fei.uim.oop.game.bang.cards.BaseCard;
import sk.stuba.fei.uim.oop.game.bang.effects.BaseEffect;
import sk.stuba.fei.uim.oop.game.bang.effects.MissedEffect;
import sk.stuba.fei.uim.oop.game.bang.share.UserInterface;

import java.util.LinkedList;

public abstract class BasePlayer {
    protected int hp;
    protected boolean isDead = false;
    protected LinkedList<BaseCard> hand;
    protected LinkedList<BaseEffect> table;
    protected StringBuilder nickname;

    public BasePlayer(String nickname){
        this.nickname = new StringBuilder(nickname);
        this.hp = 4;
        this.hand = new LinkedList<>();
        this.table = new LinkedList<>();
        this.table.add(new MissedEffect());
    }

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
            sb.append(effect);
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
}

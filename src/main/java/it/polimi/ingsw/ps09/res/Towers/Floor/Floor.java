package it.polimi.ingsw.ps09.res.Towers.Floor;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * Created by ale on 10/05/2017.
 */
public class Floor {

    private int mDiceValue;
    private Object mBonus;
    private Object mCard;
    private Object mPawn;

    public Floor(int diceValue) {
        mDiceValue = diceValue;
    }

    public void setPawn(Object pawn) {
        mPawn = pawn;
    }

    public void setBonus(Object bonus) {
        mBonus = bonus;
    }

    public void setCard(Object card) {
        mCard = card;
    }

    public Object getPawn() {
        return mPawn;
    }

    public int getDiceValue() {
        return mDiceValue;
    }

    public Object getBonus() {
        return mBonus;
    }

    public Object getCard() {
        return mCard;
    }

}

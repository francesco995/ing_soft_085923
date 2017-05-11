package it.polimi.ingsw.ps09.res.Towers;

/**
 * Created by ale on 10/05/2017.
 */
public class Floor {

    private int mNumber;
    private int mDiceValue;
    private Object mBonus;
    private Object mCard;

    public void setNumber(int number) {
        mNumber = number;
    }

    public void setDiceValue(int diceValue) {
        mDiceValue = diceValue;
    }

    public void setBonus(Object bonus) {
        mBonus = bonus;
    }

    public void setCard(Object card) {
        mCard = card;
    }

    public int getNumber() {
        return mNumber;
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

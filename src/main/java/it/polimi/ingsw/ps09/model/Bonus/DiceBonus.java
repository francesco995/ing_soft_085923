package it.polimi.ingsw.ps09.model.Bonus;

/**
 * Created by franc on 10/07/2017.
 */
public class DiceBonus {
    private int mBonus;

    public DiceBonus() {
        mBonus = 0;
    }

    public int getBonus() {
        return mBonus;
    }

    public void setBonus(int malus) {
        mBonus = malus;
    }
    public int getMalus() {
        return mBonus;
    }

    public void setMalus(int malus) {
        mBonus = malus;
    }
}

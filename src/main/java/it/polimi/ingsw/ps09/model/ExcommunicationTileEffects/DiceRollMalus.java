package it.polimi.ingsw.ps09.model.ExcommunicationTileEffects;

/**
 * It applies a malus to the user dice value of the desired value marked in the tile file
 * The value should be entered positive but it will be converted if negative
 */
public class DiceRollMalus extends ExcommunicationTileEffect{

    private int mDiceMalus;

    public DiceRollMalus(int diceMalus) {
        mDiceMalus = diceMalus;
    }

    public int getDiceMalus() {
        return Math.abs(mDiceMalus);
    }


    @Override
    public String toString(){
        return ("Dice Malus -> " + mDiceMalus);
    }
}
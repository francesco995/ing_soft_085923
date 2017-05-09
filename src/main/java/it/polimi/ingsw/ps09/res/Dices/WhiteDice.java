package it.polimi.ingsw.ps09.res.Dices;

import java.util.Random;

/**
 * Created by franc on 09/05/2017.
 */
public class WhiteDice {
    private int mValue;


    public void roll(){
        Random mRandomGenerator = null;
        mValue = mRandomGenerator.nextInt((6 - 1) + 1) + 1;
    }

    public int getValue() {
        return mValue;
    }
}

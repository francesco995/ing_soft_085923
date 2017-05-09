package it.polimi.ingsw.ps09.res.Dices;

import java.util.Random;

/**
 * Created by franc on 09/05/2017.
 */
public class Dice {

    //VARIABLES
    private int mValue;

    //CONSTRUCTOR
    public Dice(){

    }

    //GETTER
    public int getValue() {
        return mValue;
    }

    //SETTER
    public void setValue(int mSetValue){
        mValue = mSetValue;
    }

    //METHODS
    public void roll(){
        Random mRandomGenerator = null;
        mValue = mRandomGenerator.nextInt((6 - 1) + 1) + 1;
    }

}

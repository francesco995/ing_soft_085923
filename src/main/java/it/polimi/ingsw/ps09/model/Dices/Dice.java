package it.polimi.ingsw.ps09.model.Dices;

import it.polimi.ingsw.ps09.Constants;

/**
 * Abstract class dice contains all necessary methods for it to function
 */
public abstract class Dice {


    //VARIABLES
    private int mValue;
    private String mColor;

    //GETTER/SETTER/CONSTRUCTOR

    public Dice(int value, String color) {
        mValue = value;
        mColor = color;
    }

    public int getValue() {
        return mValue;
    }

    public String getColor() {
        return mColor;
    }

    public void setValue(int value) {
        mValue = value;
    }

    /**
     * simulates the roll of a six sided dice
     */
    public void roll() {
        mValue = (int) (Math.random() * Constants.MAX_DICE_VALUE + 1);
    }

    @Override
    public String toString(){
        return ( "\n" + mColor + " Dice -> " + mValue );
    }

}

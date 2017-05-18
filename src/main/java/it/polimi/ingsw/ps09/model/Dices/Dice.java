package it.polimi.ingsw.ps09.model.Dices;


public class Dice {


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
        mValue = (int) (Math.random() * 6 + 1);
    }

}

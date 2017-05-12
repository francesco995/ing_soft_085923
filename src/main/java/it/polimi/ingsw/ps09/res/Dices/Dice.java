package it.polimi.ingsw.ps09.res.Dices;

/**

 * Created by francLorenti on 09/05/2017.
 */
public class Dice {

    //VARIABLES
    private int mValue;

    //GETTER
    public int getValue() {
        return mValue;
    }

    //METHODS
    public void roll() {
        mValue = (int) (Math.random() * 6 + 1);
    }

}

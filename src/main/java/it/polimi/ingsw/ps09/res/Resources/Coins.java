package it.polimi.ingsw.ps09.res.Resources;

/**
 * Created by franc on 09/05/2017.
 */
public class Coins {
    private int mValue = 0;

    public int getValue() {
        return mValue;
    }

    public Coins(){
        mValue = 0;
    }

    public Coins(int initialCoins){
        mValue = initialCoins;
    }

}

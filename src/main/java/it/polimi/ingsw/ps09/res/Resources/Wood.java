package it.polimi.ingsw.ps09.res.Resources;

/**
 * Created by franc on 09/05/2017.
 */
public class Wood {
    private int mValue = 0;

    Wood(){
        new Wood(0);
    }

    Wood(int initialWood){
        mValue = initialWood;
    }

    public int getValue() {
        return mValue;
    }

}


package it.polimi.ingsw.ps09.res.Resources;

/**
 * Created by franc on 09/05/2017.
 */
public class Stone {
    private int mValue = 0;

    public int getValue() {
        return mValue;
    }

    Stone(){
        new Stone(0);
    }

    Stone(int initialStone){
        mValue = initialStone;
    }

}

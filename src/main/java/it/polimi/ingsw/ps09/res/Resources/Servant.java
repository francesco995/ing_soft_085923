package it.polimi.ingsw.ps09.res.Resources;

/**
 * Created by franc on 09/05/2017.
 */
public class Servant {
    private int mValue = 0;

    public int getValue() {
        return mValue;
    }

    Servant(){
        new Servant(0);
    }

    Servant(int initialServants){
        mValue = initialServants;
    }
}

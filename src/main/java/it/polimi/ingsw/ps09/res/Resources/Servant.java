package it.polimi.ingsw.ps09.res.Resources;

/**
 * Created by franc on 09/05/2017.
 */
public class Servant {
    private int mValue = 0;

    public int getValue() {
        return mValue;
    }

    public Servant(){
        new Servant(0);
    }

    public Servant(int initialServants){
        mValue = initialServants;
    }
}

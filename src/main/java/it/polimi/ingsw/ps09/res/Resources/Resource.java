package it.polimi.ingsw.ps09.res.Resources;

/**
 * Created by franc on 09/05/2017.
 */
public class Resource {

    //VALUES
    private int mValue;

    //CONSTRUCTORS
    public Resource(){
        new Resource(0);
    }

    public Resource(int initialValue){
        mValue = initialValue;
    }

    //GETTERS
    public int getValue() {
        return mValue;
    }

    //SETTERS
    public void setValue(int newValue){
        mValue = newValue;
    }

    public void addValue(int addValue){
        mValue = mValue + addValue;
    }


}

package it.polimi.ingsw.ps09.model.Resources;

/**
 * Created by francGianni on 09/05/2017.
 */
public class Resource {

    //VARIABLES
    private int mValue;

    //CONSTRUCTORS
    public Resource(){
        this(0);
    }

    public Resource(int initialValue){
        mValue = initialValue;
    }

    //GETTERS
    public int getValue() {
        return mValue;
    }

    public String toString(){
        return String.valueOf(mValue);
    }

    //SETTERS
    public void setValue(int newValue){
        mValue = newValue;
    }

    public void addValue(Resource addValue){
        mValue = mValue + addValue.getValue();
    }



}

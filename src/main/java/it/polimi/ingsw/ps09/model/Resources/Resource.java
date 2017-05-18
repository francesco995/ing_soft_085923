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

    //ADD
    public void add(Resource add){
        mValue = mValue + add.getValue();
    }



}

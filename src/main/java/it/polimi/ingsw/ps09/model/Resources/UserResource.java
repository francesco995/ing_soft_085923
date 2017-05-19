package it.polimi.ingsw.ps09.model.Resources;

import it.polimi.ingsw.ps09.model.UserPoints;

import java.util.Comparator;

/**
 * Created by francGianni on 09/05/2017.
 */
public abstract class UserResource{

    //VARIABLES
    private int mValue;

    //CONSTRUCTORS
    public UserResource(){
        this(0);
    }

    public UserResource(int initialValue){
        mValue = initialValue;
    }

    //GETTERS
    public int getValue() {
        return mValue;
    }

    //ADD
    public void add(UserResource add){
        mValue = mValue + add.getValue();
    }

    @Override
    public String toString(){
        return String.valueOf(mValue);
    }

    /**
     * Compare this UserResource object to an other one
     * @param thanThis UserResource object to compare this. to
     * @return returns true if the UserResource that invokes the method
     * is GREATER or EQUALS the one passed as parameter
     */
    public boolean isGreaterOrEqual(UserResource thanThis){
        if(mValue >= thanThis.getValue())
            return true;
        return false;
    }




}

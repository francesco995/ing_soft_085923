package it.polimi.ingsw.ps09.model.Resources;

import it.polimi.ingsw.ps09.controller.Game.Game;
import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by francesco995 on 09/05/2017.
 */
public abstract class Resource {

    //VARIABLES
    private int mValue;

    //CONSTRUCTORS
    public Resource(){
        this(0);
    }

    public Resource(int initialValue){

        if(initialValue < 0 ){
            throw new IllegalArgumentException("Resource can't be negative!");
        }

        mValue = initialValue;
    }

    //GETTERS
    public int getValue() {
        return mValue;
    }

    @Override
    public String toString(){
        return String.valueOf(mValue);
    }

    //ADD
    public void add(Resource add){
        mValue = mValue + add.getValue();
    }

    //REMOVE
    /**
     * Remove Resource
     * Points can be checked with isGreaterOrEqual before removing to avoid Exceptions
     * @param remove Resource to remove
     * @throws UnsupportedOperationException if resource would go negative.
     */
    public void remove(Resource remove){
        mValue = mValue - remove.getValue();
        if(mValue < 0){
            throw new UnsupportedOperationException(
                    "ERROR || Game: " + Game.GAME_ID +
                            " tried to remove " + remove.getValue() +
                            " " + remove.getClass().getName().toString() +
                            " from player: " + Player.PLAYER_ID +
                            " now has " + mValue +
                            " Points can't be negative!!!");
        }
    }


    /**
     * Compare this Resource object to an other one
     * @param thanThis Resource object to compare this. to
     * @return returns true if the Resource that invokes the method
     * is GREATER or EQUALS the one passed as parameter
     */
    public boolean isGreaterOrEqual(Resource thanThis){
        if(mValue >= thanThis.getValue())
            return true;
        return false;
    }




}

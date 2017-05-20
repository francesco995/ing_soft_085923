package it.polimi.ingsw.ps09.model.Resources;

import it.polimi.ingsw.ps09.controller.Game;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;

import java.util.Comparator;

/**
 * Created by francesco995 on 09/05/2017.
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

    @Override
    public String toString(){
        return String.valueOf(mValue);
    }

    //ADD
    public void add(UserResource add){
        mValue = mValue + add.getValue();
    }

    //REMOVE
    /**
     * Remove Resource
     * Points can be checked with isGreaterOrEqual before removing to avoid Exceptions
     * @param remove Resource to remove
     * @throws UnsupportedOperationException if resource would go negative.
     */
    public void remove(UserResource remove){
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

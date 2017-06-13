package it.polimi.ingsw.ps09.model.Points;

import it.polimi.ingsw.ps09.controller.Game.Game;
import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by francesco995 on 09/05/2017.
 */
public abstract class Points {

    //VARIABLES
    private int mPoints;

    //CONSTRUCTORS
    public Points(){
        this(0);
    }

    public Points(int initialPoints) {

        if(initialPoints < 0) {
            throw new IllegalArgumentException("Points can't be negative");
        }

        mPoints = initialPoints;
    }

    //GETTERS
    public int getValue() {
        return mPoints;
    }

    //Override toString method to get points value
    public String toString(){
        return String.valueOf(mPoints);
    }

    //ADD Points

    public void add(Points add){
        mPoints = mPoints + add.getValue();
    }

    //CHECK IF HAS
    /**
     * Compare this Points object to an other one
     * @param thanThis Points object to compare this. to
     * @return returns true if the Points that invokes the method
     * is GREATER or EQUALS the one passed as parameter
     */
    public boolean isGreaterOrEqual(Points thanThis){
        if(mPoints >= thanThis.getValue())
            return true;
        return false;
    }

    //REMOVE

    /**
     * Remove Points
     * Points can be checked with isGreaterOrEqual before removing to avoid Exceptions
     * @param remove Points to remove
     * @throws UnsupportedOperationException if points would go negative.
     */
    public void remove(Points remove){
        mPoints = mPoints - remove.getValue();

        if(mPoints < 0){
            throw new UnsupportedOperationException(
                    "ERROR || Game: " + Game.GAME_ID +
                    " tried to remove " + remove.getValue() +
                    " " + remove.getClass().getName().toString() +
                    " from player: " + Player.PLAYER_ID +
                    " now has " + mPoints +
                    " Points can't be negative!!!");
        }
    }


}

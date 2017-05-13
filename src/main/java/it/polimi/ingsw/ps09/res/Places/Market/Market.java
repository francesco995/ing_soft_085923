package it.polimi.ingsw.ps09.res.Places.Market;

import com.sun.corba.se.spi.ior.ObjectKey;
import it.polimi.ingsw.ps09.res.Places.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ale on 09/05/2017.
 */
public class Market extends Place {

    private Object mPawn;
    private Object mBonus;
    private Object mDiceValue;

    public Object getPawn() {
        return mPawn;
    }

    public Object getBonus() {
        return mBonus;
    }

    public Object getDiceValue() {
        return mDiceValue;
    }

    public void setPawn(Object pawn) {
        mPawn = pawn;
    }

    public void setBonus(Object bonus) {
        mBonus = bonus;
    }

    public void setDiceValue(Object diceValue) {
        mDiceValue = diceValue;
    }

    //Check if MarketSpace is available
    public boolean isAvailable(){
        //TODO: Ale check number of player

        return true;
    }

    //Check if MarketSpace is free
    public boolean isFree(){

        if(mPawn==null)
            return true;

        else
            return false;
    }

}

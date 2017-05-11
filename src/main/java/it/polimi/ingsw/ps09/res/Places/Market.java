package it.polimi.ingsw.ps09.res.Places;

import it.polimi.ingsw.ps09.res.Resources.Places;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ale on 09/05/2017.
 */
public class Market extends Places {

    private Object mPawn;
    private Object mBonus;
    private int mDiceValue;

    public List<Market> initialize (){

        //Create A lis of market spaces
        List<Market> MarketSpaces = new ArrayList<Market>();

        //Add all Market Spaces to the list
        MarketSpaces.add(0, new MarketSpace1());
        MarketSpaces.add(1, new MarketSpace2());
        MarketSpaces.add(2, new MarketSpace3());
        MarketSpaces.add(3, new MarketSpace4());

        //Set minimum dice value to access market spaces
        setDiceValue(1);

        //Return a List of market spaces
        return MarketSpaces;

    }


    public Object getPawn() {
        return mPawn;
    }

    public Object getBonus() {
        return mBonus;
    }

    public int getDiceValue() {
        return mDiceValue;
    }

    public void setPawn(Object pawn) {
        mPawn = pawn;
    }

    public void setBonus(Object bonus) {
        mBonus = bonus;
    }

    public void setDiceValue(int diceValue) {
        mDiceValue = diceValue;
    }
}

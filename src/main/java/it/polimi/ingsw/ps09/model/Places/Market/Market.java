package it.polimi.ingsw.ps09.model.Places.Market;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ale on 12/05/2017.
 */
public class Market{

    //Create A lis of market spaces
    private  List<MarketSpace> mMarketSpaceSpaces = new ArrayList<>();

    /**
     *
     * @return List Market's marketspaces
     */

    //Initialize all MarketSpace Spaces
    public Market(){

        //Add all MarketSpace Spaces to the list

        try {
            mMarketSpaceSpaces.add(0, new MarketSpaceSpace1(1, 1));
            mMarketSpaceSpaces.add(1, new MarketSpaceSpace2(1, 2));
            mMarketSpaceSpaces.add(2, new MarketSpaceSpace3(1, 3));
            mMarketSpaceSpaces.add(3, new MarketSpaceSpace4(1, 4));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Market.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Set minimum dice value to access market spaces
        //TODO: Ale set MarketSpace's DiceValue once Dice is created by FraL

        //Return a List of market spaces
    }

    /**
     *
     * @return List Market's marketspaces
     */

    public List<MarketSpace> getMarketList(){
        return mMarketSpaceSpaces;
    }

    /**
     * Clear MarketSpaces for a new round
     */
    //Clear MarketSpaces for a new round
    public void clearAll(){
        mMarketSpaceSpaces.clear();

        try {
            mMarketSpaceSpaces.add(0, new MarketSpaceSpace1(1, 1));
            mMarketSpaceSpaces.add(1, new MarketSpaceSpace2(1, 2));
            mMarketSpaceSpaces.add(2, new MarketSpaceSpace3(1, 3));
            mMarketSpaceSpaces.add(3, new MarketSpaceSpace4(1, 4));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Market.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return All information about all market spaces into the market
     */

    @Override
    public String toString(){

        StringJoiner mStringMarket = new StringJoiner("\n", "", "");

        for (MarketSpace mMSpace : mMarketSpaceSpaces){

            mStringMarket.add("");
            mStringMarket.add("Market Space: " + mMSpace.getIndex());
            mStringMarket.add(mMSpace.toString());
            mStringMarket.add("");
        }

        return mStringMarket.toString();
    }

}

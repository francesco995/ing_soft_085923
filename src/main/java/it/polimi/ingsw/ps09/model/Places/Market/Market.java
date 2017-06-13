package it.polimi.ingsw.ps09.model.Places.Market;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by ale on 12/05/2017.
 */
public class Market {

    //Create A lis of market spaces
    private  List<MarketSpace> mMarketSpaceSpaces = new ArrayList<>();

    /**
     *
     * @return List Market's marketspaces
     */

    //Initialize all MarketSpace Spaces
    public Market (){

        //Add all MarketSpace Spaces to the list
        mMarketSpaceSpaces.add(0, new MarketSpaceSpace1());
        mMarketSpaceSpaces.add(1, new MarketSpaceSpace2());
        mMarketSpaceSpaces.add(2, new MarketSpaceSpace3());
        mMarketSpaceSpaces.add(3, new MarketSpaceSpace4());

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

    //Clear MarketSpaces for a new round
    public void clearAll(){
        mMarketSpaceSpaces.clear();
    }

    @Override
    public String toString(){

        StringJoiner mStringMarket = new StringJoiner("\n", "", "");

        for (int cont=0; cont<mMarketSpaceSpaces.size(); cont++){

            mStringMarket.add("");
            mStringMarket.add("Market Space: " + (cont + 1));
            mStringMarket.add(mMarketSpaceSpaces.get(cont).toString());
            mStringMarket.add("");
        }

        return mStringMarket.toString();
    }

}

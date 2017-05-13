package it.polimi.ingsw.ps09.res.Places.Market;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ale on 12/05/2017.
 */
public class CreateMarket {

    //Create A lis of market spaces
    private  List<Market> mMarketSpaces = new ArrayList<Market>();

    //Initialize all Market Spaces
    public List<Market> initialize (){

        //Add all Market Spaces to the list
        mMarketSpaces.add(0, new MarketSpace1());
        mMarketSpaces.add(1, new MarketSpace2());
        mMarketSpaces.add(2, new MarketSpace3());
        mMarketSpaces.add(3, new MarketSpace4());

        //Set minimum dice value to access market spaces
        //TODO: Ale set MarketSpace's DiceValue once Dice is created by FraL

        //Return a List of market spaces
        return mMarketSpaces;

    }

    //Clear MarketSpaces for a new round
    public void clearAll(){
        mMarketSpaces.clear();
    }

}

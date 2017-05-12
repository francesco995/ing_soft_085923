package it.polimi.ingsw.ps09.res.Places.Market;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ale on 12/05/2017.
 */
public class CreateMarket {

    //Initialize all Market Spaces
    public List<Market> initialize (){

        //Create A lis of market spaces
        List<Market> MarketSpaces = new ArrayList<Market>();

        //Add all Market Spaces to the list
        MarketSpaces.add(0, new MarketSpace1());
        MarketSpaces.add(1, new MarketSpace2());
        MarketSpaces.add(2, new MarketSpace3());
        MarketSpaces.add(3, new MarketSpace4());

        //Set minimum dice value to access market spaces
        //TODO: Ale set MarketSpace's DiceValue once Dice is created bye FraL

        //Return a List of market spaces
        return MarketSpaces;

    }

}

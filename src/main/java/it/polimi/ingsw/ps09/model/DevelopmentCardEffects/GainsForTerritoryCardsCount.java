package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

/**
 * Created by franc on 30/05/2017.
 */
public class GainsForTerritoryCardsCount extends DevelopmentCardEffect{

    //Gains when activated
    private UserResources mResourcesGains;
    private UserPoints mPointsGains;

    public GainsForTerritoryCardsCount(UserResources resourcesGains,
                                       UserPoints pointsGains) {

        mResourcesGains = resourcesGains;
        mPointsGains = pointsGains;
    }

    @Override
    public String toString(){

        String toString = "";

        if(mPointsGains.isGreaterOrEqual(
                new UserPoints(1, 1, 1))){

            toString += "Gain Points -> " + mPointsGains;

        }

        if(mResourcesGains.isGreaterOrEqual(
                new UserResources(1, 1, 1, 1))){

            toString += " and Resources -> " + mResourcesGains;

        }

        toString += " for each Territory";

        return toString;

    }



    @Override
    public void applyEffect(Player player) {


        for(int i=0; i< player.getTerritoriesCount(); i++){

            player.add(mResourcesGains);
            player.add(mPointsGains);

        }

    }
}

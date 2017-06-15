package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

/**
 * Created by franc on 30/05/2017.
 * Player gains resources and points based on how many Building cards has
 */
public class GainsForBuildingCardsCount implements DevelopmentCardEffect{
    //Gains when activated
    private UserResources mResourcesGains;
    private UserPoints mPointsGains;

    public GainsForBuildingCardsCount(UserResources resourcesGains,
                                      UserPoints pointsGains) {

        mResourcesGains = resourcesGains;
        mPointsGains = pointsGains;

    }

    /**
     * Apply effect to a Player
     * @param player Player to apply effect to
     */
    @Override
    public void applyEffect(Player player) {


        for (int i = 0; i < player.getBuildingsCount(); i++) {

            player.add(mResourcesGains);
            player.add(mPointsGains);

        }

    }

    /**
     * Describe object as a string to CLI Clients
     */
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

        toString += "for each Building";

        return toString;

    }
}
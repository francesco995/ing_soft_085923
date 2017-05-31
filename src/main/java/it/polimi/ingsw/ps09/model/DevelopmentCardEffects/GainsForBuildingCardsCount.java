package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

/**
 * Created by franc on 30/05/2017.
 */
public class GainsForBuildingCardsCount extends DevelopmentCardEffect{
    //Gains when activated
    private UserResources mResourcesGains;
    private UserPoints mUserPoints;

    public GainsForBuildingCardsCount(UserResources resourcesGains,
                                      UserPoints userPoints) {

        mResourcesGains = resourcesGains;
        mUserPoints = userPoints;

    }

    @Override
    public void applyEffect(Player player) {


        for (int i = 0; i < player.getBuildingsCount(); i++) {

            player.add(mResourcesGains);
            player.add(mUserPoints);

        }

    }
}
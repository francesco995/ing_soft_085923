package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

/**
 * Created by franc on 30/05/2017.
 */
public class GainsForVentureCardsCount extends DevelopmentCardEffect {
    //Gains when activated
    private UserResources mResourcesGains;
    private UserPoints mUserPointsGains;


    public GainsForVentureCardsCount(UserResources resourcesGains,
                                     UserPoints userPointsGains) {

        mResourcesGains = resourcesGains;
        mUserPointsGains = userPointsGains;
    }

    @Override
    public String toString(){
        return ("Gain Points -> " + mUserPointsGains +
                " and Resources -> " + mResourcesGains +
                " for each Venture");
    }


    @Override
    public void applyEffect(Player player) {


        for (int i = 0; i < player.getVenturesCount(); i++) {

            player.add(mResourcesGains);
            player.add(mUserPointsGains);

        }

    }
}
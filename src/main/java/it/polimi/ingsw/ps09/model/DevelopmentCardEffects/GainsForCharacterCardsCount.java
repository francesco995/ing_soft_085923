package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

/**
 * Created by francesco995 on 30/05/2017.
 */
public class GainsForCharacterCardsCount extends DevelopmentCardEffect {

    //Gains when activated
    private UserResources mResourcesGains;
    private UserPoints mUserPointsGains;

    public GainsForCharacterCardsCount(UserResources resourcesGains,
                                       UserPoints userPointsGains) {

        mResourcesGains = resourcesGains;
        mUserPointsGains = userPointsGains;
    }

    @Override
    public String toString(){
        return ("Gain Points -> " + mUserPointsGains +
                " and Resources -> " + mResourcesGains +
                " for each Character");
    }


    @Override
    public void applyEffect(Player player) {


        for (int i = 0; i < player.getCharactersCount(); i++) {

            player.add(mResourcesGains);
            player.add(mUserPointsGains);

        }


    }
}
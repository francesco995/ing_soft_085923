package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

/**
 * Created by francesco995 on 24/05/2017.
 */
public class GainResourcesEffect extends DevelopmentCardEffect {


    //Gains when activated
    private UserResources mResourcesGains;

    public GainResourcesEffect(UserResources resourcesGains) {
        mResourcesGains = resourcesGains;
    }

    @Override
    public void applyEffect(Player player) {

        player.add(mResourcesGains);

    }
}

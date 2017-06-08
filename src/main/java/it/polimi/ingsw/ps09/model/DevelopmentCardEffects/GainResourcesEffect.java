package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

/**
 * Created by francesco995 on 24/05/2017.
 * Gain UserResources
 */
public class GainResourcesEffect implements DevelopmentCardEffect {


    //Gains when activated
    private UserResources mResourcesGains;

    public GainResourcesEffect(UserResources resourcesGains) {
        mResourcesGains = resourcesGains;
    }

    @Override
    public String toString(){
        return String.format("Gain Resources -> " + mResourcesGains);
    }

    @Override
    public void applyEffect(Player player) {

        player.add(mResourcesGains);

    }
}

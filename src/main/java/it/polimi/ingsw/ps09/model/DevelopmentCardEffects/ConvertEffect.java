package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

public class ConvertEffect extends DevelopmentCardEffect{

    //Resources or Points cost to activate conversion
    private UserResources mResourceCost;
    private UserPoints mPointsCost;

    //Resources or Point gained in conversion

    private UserResources mResourcesGains;
    private UserPoints mPointsGains;

    //TODO: controllare se la scelta dell'attivazione va fatta qui o in GameLogic

    @Override
    public void applyEffect(Player player) {

        //cost payments
        player.remove(mResourceCost);
        player.remove(mPointsCost);

        //gains for conversion
        player.add(mResourcesGains);
        player.add(mPointsGains);


    }
}

package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

import java.util.List;

public class ConvertEffect extends DevelopmentCardEffect{

    //Resources or Points cost to activate conversion
    private List<UserResources> mResourceCost;
    private List<UserPoints> mPointsCost;

    //Resources or Point gained in conversion

    private List<UserResources> mResourcesGains;
    private List<UserPoints> mPointsGains;

    //TODO: controllare se la scelta dell'attivazione va fatta qui o in GameLogic


    public ConvertEffect(List<UserResources> resourceCost,
                         List<UserPoints> pointsCost,
                         List<UserResources> resourcesGains,
                         List<UserPoints> pointsGains) {

        mResourceCost = resourceCost;
        mPointsCost = pointsCost;
        mResourcesGains = resourcesGains;
        mPointsGains = pointsGains;

    }

    @Override
    public void applyEffect(Player player) {

        //TODO: Prompt User for cost/gain 0 or 1

        //cost payments
        player.remove(mResourceCost.get(0));
        player.remove(mPointsCost.get(0));

        //gains for conversion
        player.add(mResourcesGains.get(0));
        player.add(mPointsGains.get(0));


    }
}

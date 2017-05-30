package it.polimi.ingsw.ps09.model.DevelopmentCards;

import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.DevelopmentCardEffect;
import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.GainResourcesEffect;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

import java.util.List;

/**
 * Created by franc on 09/05/2017.
 */
public class Territory extends DevelopmentCard {

    //GREEN CARD

    //Harvest COST
    private int mProductionCost;

    //TODO: check if only one list of DEVCARDEFF works

    private List<DevelopmentCardEffect> mHarvestEffects;


    public Territory(String cardName,
                     int period,
                     int productionCost,
                     List<UserResources> resourcesCosts,
                     List<UserPoints> pointsCosts,
                     List<DevelopmentCardEffect> immediateEffects,
                     List<DevelopmentCardEffect> harvestEffects) {

        super(cardName, period, resourcesCosts, pointsCosts, immediateEffects);
        mProductionCost = productionCost;
        mHarvestEffects = harvestEffects;

    }
}


package it.polimi.ingsw.ps09.model.DevelopmentCards;

import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.DevelopmentCardEffect;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

import java.util.List;

/**
 * Created by franc on 09/05/2017.
 */
public class Building extends DevelopmentCard {

    //YELLOW CARD

    //Production COST
    private int mProductionCost;

    public Building(String cardName,
                    int period,
                    List<UserResources> resourcesCosts,
                    List<UserPoints> pointsCosts,
                    List<DevelopmentCardEffect> immediateEffects,
                    int productionCost,
                    List<DevelopmentCardEffect> productionEffects) {

        super(cardName, period, resourcesCosts, pointsCosts, immediateEffects);
        mProductionCost = productionCost;
        mProductionEffects = productionEffects;
    }


//Production Effect

    //TODO: check if only one list of DEVCARDEFF works

    private List<DevelopmentCardEffect> mProductionEffects;

}

package it.polimi.ingsw.ps09.model.DevelopmentCards;

import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.DevelopmentCardEffect;
import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.GainResourcesEffect;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

import java.util.List;
import java.util.StringJoiner;

/**
 * Created by francesco995 on 09/05/2017.
 * Territories cards are the green cards
 * they have all basic card content
 * they also introduce Harvest concept into game
 * They have a harvestCost and a List of harvestEffects (might me more than one to chose from)
 */
public class Territory extends DevelopmentCard {

    //GREEN CARD

    //HarvestArea COST
    private int mProductionCost;
    //TODO: fix typo and change mProdutionCost to mHarvestCost also in json cards

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

    public int getProductionCost() {
        return mProductionCost;
    }

    public List<DevelopmentCardEffect> getHarvestEffects() {
        return mHarvestEffects;
    }

    @Override
    public String toString(){

        StringJoiner mStringCard = new StringJoiner("\n     ", "", "");

        mStringCard.add(super.toString());

        mStringCard.add("HarvestArea Effects (Cost: " + mProductionCost + "):");
        mHarvestEffects.stream()
                .map(DevelopmentCardEffect::toString)
                .forEach(mStringCard::add);

        return mStringCard.toString();

    }


}


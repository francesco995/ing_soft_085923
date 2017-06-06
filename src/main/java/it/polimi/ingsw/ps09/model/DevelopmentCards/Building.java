package it.polimi.ingsw.ps09.model.DevelopmentCards;

import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.DevelopmentCardEffect;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

import java.util.List;
import java.util.StringJoiner;

/**
 * Created by francesco995 on 09/05/2017.
 */
public class Building extends DevelopmentCard {

    //YELLOW CARD

    //Production COST
    private int mProductionCost;

    private List<DevelopmentCardEffect> mProductionEffects;

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




    @Override
    public String toString(){

        StringJoiner mStringCard = new StringJoiner("\n     ", "", "");

        mStringCard.add(super.toString());

        mStringCard.add("Production Effects (Cost: " + mProductionCost + "):");
        mProductionEffects.stream()
                .map(DevelopmentCardEffect::toString)
                .forEach(mStringCard::add);

        return mStringCard.toString();

    }

    public int getProductionCost() {
        return mProductionCost;
    }

    public List<DevelopmentCardEffect> getProductionEffects() {
        return mProductionEffects;
    }
}

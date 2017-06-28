package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.DevelopmentCardEffect;
import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.GainPointsEffect;
import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.GainResourcesEffect;

import java.util.List;

/**
 * Created by franc on 28/06/2017.
 */
public class PersonalBonusTile {

    //Harvest Bonus

    List<DevelopmentCardEffect> mHarvestBonus;

    //Production Bonus

    List<DevelopmentCardEffect> mProductionBonus;



    //GETTER

    public List<DevelopmentCardEffect> getHarvestBonus() {
        return mHarvestBonus;
    }

    public List<DevelopmentCardEffect> getProductionBonus() {
        return mProductionBonus;
    }


    //CONSTRUCTOR


    public PersonalBonusTile(List<DevelopmentCardEffect> harvestBonus, List<DevelopmentCardEffect> productionBonus) {

        mHarvestBonus = harvestBonus;
        mProductionBonus = productionBonus;

    }


    //to string necessary for CLI
    @Override
    public String toString() {

        String toReturn ="Personal Bonus Tile: \n ";

        toReturn += "Harvest:";
        toReturn += mHarvestBonus.toString();

        toReturn += "\nProduction:";
        toReturn += mProductionBonus.toString();

        return toReturn;
    }
}

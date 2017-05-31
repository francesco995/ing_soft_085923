package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.DevelopmentCardEffect;

import java.util.List;

/**
 * Created by francesco995 on 31/05/2017.
 */
public class PermanentPlayerEffects {

    List<DevelopmentCardEffect> mDevelopmentCardsPermanentEffects;



    public void add(DevelopmentCardEffect developmentCardPermanentEffect){

        mDevelopmentCardsPermanentEffects.add(developmentCardPermanentEffect);

    }


}



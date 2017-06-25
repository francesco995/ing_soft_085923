package it.polimi.ingsw.ps09.model.DevelopmentCards;

import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.DevelopmentCardEffect;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

import java.util.List;
import java.util.StringJoiner;

/**
 * Created by franc on 09/05/2017.
 * Character card are the blue cards
 * they have all basic card content
 * they do not introduce new mechanic to game
 */
public class Character extends DevelopmentCard {

    //BLUE CARDS

    //Effects

    private List<DevelopmentCardEffect> mPermanentEffects;

    public Character(String cardName,
                     int period,
                     List<UserResources> resourcesCosts,
                     List<UserPoints> pointsCosts,
                     List<DevelopmentCardEffect> immediateEffects,
                     List<DevelopmentCardEffect> permanentEffects) {

        super(cardName, period, resourcesCosts, pointsCosts, immediateEffects);

        mPermanentEffects = permanentEffects;
    }

    public List<DevelopmentCardEffect> getPermanentEffects() {
        return mPermanentEffects;
    }

    @Override
    public String toString(){

        StringJoiner mStringCard = new StringJoiner("\n     ", "", "");

        mStringCard.add(super.toString());

        if(!mPermanentEffects.isEmpty()){
            mStringCard.add("Permanent Effects :");
            mPermanentEffects.stream()
                    .map(DevelopmentCardEffect::toString)
                    .forEach(mStringCard::add);
        }

        return mStringCard.toString();

    }


}

package it.polimi.ingsw.ps09.model.DevelopmentCards;

import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.DevelopmentCardEffect;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

import java.util.List;

/**
 * Created by franc on 09/05/2017.
 */
public class Character extends DevelopmentCard {

    //BLUE CARDS

    //Effects

    private List<DevelopmentCardEffect> mCardEffects ;

    public Character(String cardName,
                     int period,
                     List<UserResources> resourcesCosts,
                     List<UserPoints> pointsCosts,
                     List<DevelopmentCardEffect> immediateEffects,
                     List<DevelopmentCardEffect> cardEffects) {

        super(cardName, period, resourcesCosts, pointsCosts, immediateEffects);

        mCardEffects = cardEffects;
    }
}

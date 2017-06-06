package it.polimi.ingsw.ps09.model.DevelopmentCards;

import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.DevelopmentCardEffect;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

import java.util.List;

/**
 * Created by francesco995 on 09/05/2017.
 */
public class Venture extends DevelopmentCard {

    //PURPLE CARD


    //UserPoints REQUIREMENTS to get the card
    private UserPoints mPointsRequirements;

    //EndGame Effects

    private List<DevelopmentCardEffect> mEndGameEffects;



    public Venture(String cardName,
                   int period,
                   List<UserResources> resourcesCosts,
                   List<UserPoints> pointsCosts,
                   List<DevelopmentCardEffect> immediateEffects,
                   UserPoints pointsRequirements,
                   List<DevelopmentCardEffect> endGameEffects) {

        super(cardName, period, resourcesCosts, pointsCosts, immediateEffects);

        mPointsRequirements = pointsRequirements;
        mEndGameEffects = endGameEffects;




    }


    public UserPoints getPointsRequirements() {
        return mPointsRequirements;
    }

    public List<DevelopmentCardEffect> getEndGameEffects() {
        return mEndGameEffects;
    }
}
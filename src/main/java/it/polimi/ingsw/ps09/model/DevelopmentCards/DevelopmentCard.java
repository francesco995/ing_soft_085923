package it.polimi.ingsw.ps09.model.DevelopmentCards;

import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.DevelopmentCardEffect;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

import java.util.List;
import java.util.StringJoiner;


/**
 * Created by francesco995 on 10/05/2017.
 */

public abstract class DevelopmentCard {

    //VARIABLES

    //Card INFO
    private String mCardName;
    private final int CARD_N;
    private int mPeriod;


    //Instant COSTS in UserResources and UserPoints
    private List<UserResources> mResourcesCosts;
    private List<UserPoints> mPointsCosts;

    //Immediate Effects
    private List<DevelopmentCardEffect> mImmediateEffects;



    //Constructor
    public DevelopmentCard(String cardName,
                           int period,
                           List<UserResources> resourcesCosts,
                           List<UserPoints> pointsCosts,
                           List<DevelopmentCardEffect> immediateEffects) {

        mCardName = cardName;
        mPeriod = period;
        mResourcesCosts = resourcesCosts;
        mPointsCosts = pointsCosts;
        mImmediateEffects = immediateEffects;

        CARD_N = 0;
    }

    //TO STRING
    @Override
    public String toString(){

        StringJoiner mStringCard = new StringJoiner("\n     ", "", "");

        mStringCard.add("Card #" + CARD_N + ": " + mCardName);

        //TODO: test with all effects
        if(!mResourcesCosts.isEmpty()){

            mStringCard.add("Resources Costs:");

            mResourcesCosts.stream()
                    .map(UserResources::toString)
                    .forEach(mStringCard::add);

        }

        if(!mPointsCosts.isEmpty()){

            mStringCard.add("Points Costs:");

            mPointsCosts.stream()
                    .map(UserPoints::toString)
                    .forEach(mStringCard::add);

        }

        if(!mImmediateEffects.isEmpty()){

            mStringCard.add("Immediate Effects:");

            mImmediateEffects.stream()
                    .map(DevelopmentCardEffect::toString)
                    .forEach(mStringCard::add);

        }

        return mStringCard.toString();

    }


    //GETTERS
    public String getCardName() {
        return mCardName;
    }

    public int getPeriod() {
        return mPeriod;
    }

    public int getCARD_N() {
        return CARD_N;
    }

    public List<DevelopmentCardEffect> getImmediateEffects() {
        return mImmediateEffects;
    }

    public  List<UserResources> getResourcesCosts() {
        return mResourcesCosts;
    }

    public List<UserPoints> getPointsCosts() {
        return mPointsCosts;
    }


}

package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.LeaderCardEffects.LeaderCardEffect;

import java.util.List;
import java.util.StringJoiner;

public class LeaderCard {
    //CARD INFO

    private String mCardName;

    //Effects

    private List<LeaderCardEffect> mLeaderCardEffects;

    //CONSTRUCTOR

    public LeaderCard(String cardName, List<LeaderCardEffect> leaderCardEffects) {
        mCardName = cardName;
        mLeaderCardEffects = leaderCardEffects;
    }


    //GETTER

    public String getCardName() {
        return mCardName;
    }

    public List<LeaderCardEffect> getLeaderCardEffect() {
        return mLeaderCardEffects;
    }

    @Override
    public String toString(){

        StringJoiner mStringLeaderCard = new StringJoiner("\n", "", "");

        mStringLeaderCard.add("Order list:");
        mStringLeaderCard.add("Card name: " + mCardName.toString());
        mStringLeaderCard.add("Effect: " + mLeaderCardEffects.toString());

        return mStringLeaderCard.toString();
    }


}

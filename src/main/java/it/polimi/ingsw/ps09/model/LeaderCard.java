package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.LeaderCardEffects.LeaderCardEffect;

import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

public class LeaderCard {
    //CARD INFO

    private String mCardName;
    private Optional<Boolean> mPlayed;

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

        mStringLeaderCard.add("");
        mStringLeaderCard.add("Card name: " + mCardName.toString());
        mStringLeaderCard.add("Effect: " + mLeaderCardEffects.toString()
                .replace("[", "")
                .replace("]", ""));
        mStringLeaderCard.add("\n");

        return mStringLeaderCard.toString();
    }


}

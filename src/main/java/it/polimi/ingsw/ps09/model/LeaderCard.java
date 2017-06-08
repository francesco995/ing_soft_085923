package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.LeaderCardEffects.LeaderCardEffect;

import java.util.List;

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


}

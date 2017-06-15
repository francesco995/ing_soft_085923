package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by francesco995 on 05/06/2017.
 * Gain permanent placement action bonus when placing FamilyMembers for taking a specific card color
 */
public class GainFamilyMemberPlacementBonus implements DevelopmentCardEffect{

    private String mCardType;
    private int mBonusValue;

    public GainFamilyMemberPlacementBonus(String cardType, int bonusValue) {
        mCardType = cardType;
        mBonusValue = bonusValue;
    }


    /**
     * Apply effect to a Player
     * @param player Player to apply effect to
     */
    @Override
    public void applyEffect(Player player) {

        player.addFamilyMemberPlacementBonus(mCardType, mBonusValue);

    }


    /**
     * Describe object as a string to CLI Clients
     */
    @Override
    public String toString(){

        String toString = "";

        toString += "Gain bonus when placing " + mCardType.toLowerCase();

        toString += " cards: your family member has => +" + mBonusValue;

        toString += " power";

        return toString;

    }

}

package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by francesco995 on 05/06/2017.
 */
public class GainFamilyMemberPlacementBonus extends DevelopmentCardEffect{

    private String mCardType;
    private int mBonusValue;

    public GainFamilyMemberPlacementBonus(String cardType, int bonusValue) {
        mCardType = cardType;
        mBonusValue = bonusValue;
    }


    @Override
    public void applyEffect(Player player) {

    }
}

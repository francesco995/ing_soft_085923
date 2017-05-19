package it.polimi.ingsw.ps09.model.Places.Market;

import it.polimi.ingsw.ps09.model.BonusPlaceHolder;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.Place;

/**
 * Created by ale on 09/05/2017.
 */
public class MarketSpace extends Place {

    private FamilyMember mPawn;
    private BonusPlaceHolder mBonusPlaceHolder;
    private int mDiceValue;

    /**
     *
     * @return Family member into marketspace
     */
    public FamilyMember getPawn() {
        return mPawn;
    }

    /**
     *
     * @return BonusPlaceHolder that the player gain into the marketspace
     */
    public BonusPlaceHolder getBonusPlaceHolder() {
        return mBonusPlaceHolder;
    }

    /**
     *
     * @return Dice value to access into marketspace
     */
    public int getDiceValue() {
        return mDiceValue;
    }

    /**
     *
     * @param pawn Set the family member into marketspace
     */
    public void setPawn(FamilyMember pawn) {
        mPawn = pawn;
    }

    /**
     *
     * @param bonusPlaceHolder Set the marketspace's bonusPlaceHolder which the player will gain
     */
    public void setBonusPlaceHolder(BonusPlaceHolder bonusPlaceHolder) {
        mBonusPlaceHolder = bonusPlaceHolder;
    }

    /**
     *
     * @param diceValue Set the dice value required to access
     */
    public void setDiceValue(int diceValue) {
        mDiceValue = diceValue;
    }

    /**
     *
     * @return Boolean value: true if there's no family member into that marketspace,
     * false if there's one
     */
    //Check if MarketSpace is available
    public boolean isAvailable(){
        if(mPawn==null)
            return true;

        else
            return false;
    }

}

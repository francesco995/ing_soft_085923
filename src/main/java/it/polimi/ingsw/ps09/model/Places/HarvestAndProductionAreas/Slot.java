package it.polimi.ingsw.ps09.model.Places.HarvestAndProductionAreas;

import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.Place;

/**
 * Created by ale on 09/05/2017.
 */
public class Slot extends Place {

    private FamilyMember mPawn;
    private int mDiceValue;

    /**
     *
     * @param diceValue Dice value of the area
     * @param FamilyMember Family member who is in the area
     */

    public Slot(int diceValue, FamilyMember FamilyMember) {
        mDiceValue = diceValue;
        mPawn = FamilyMember;
    }

    /**
     *
     * @return Family member who is in the area
     */

    public FamilyMember getPawn() {
        return mPawn;
    }

    /**
     *
     * @return Dice value of the area
     */

    public int getDiceValue() {
        return mDiceValue;
    }

    /**
     *
     * @param pawn Family member to set
     */

    public void setPawn(FamilyMember pawn) {
        mPawn = pawn;
    }

    public boolean isFree(){
        if (mPawn==null)
            return true;

        else
            return false;
    }

    /**
     *
     * @param diceValue Set dice value of the area
     */

    public void setDiceValue(int diceValue) {
        mDiceValue = diceValue;
    }
}

package it.polimi.ingsw.ps09.model.Places.HarvestAndProductionAreas;

import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.Place;

/**
 * Created by ale on 09/05/2017.
 */
public class Slot extends Place {

    private FamilyMember mPawn;
    private int mDiceValue;

    public Slot(int diceValue, FamilyMember FamilyMember) {
        mDiceValue = diceValue;
        mPawn = FamilyMember;
    }

    public FamilyMember getPawn() {
        return mPawn;
    }

    public int getDiceValue() {
        return mDiceValue;
    }

    public void setPawn(FamilyMember pawn) {
        mPawn = pawn;
    }

    public boolean isFree(){
        if (mPawn==null)
            return true;

        else
            return false;
    }

    public void setDiceValue(int diceValue) {
        mDiceValue = diceValue;
    }
}

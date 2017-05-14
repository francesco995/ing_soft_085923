package it.polimi.ingsw.ps09.res.Places.HarvestAndProductionAreas;

import com.sun.org.apache.bcel.internal.generic.FADD;
import it.polimi.ingsw.ps09.res.FamilyMember.FamilyMember;
import it.polimi.ingsw.ps09.res.Places.Place;

import java.util.List;

/**
 * Created by ale on 09/05/2017.
 */
public class Slot extends Place {

    private FamilyMember mPawn;
    private int mDiceValue;

    public Slot(){

    }

    public Slot(int diceValue, FamilyMember FamilyMember) {
        mDiceValue = diceValue;
        mPawn = FamilyMember;
    }

    public Object getPawn() {
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

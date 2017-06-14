package it.polimi.ingsw.ps09.model.Places.HarvestAndProductionAreas;

import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.Place;

import java.util.StringJoiner;

/**
 * Created by ale on 09/05/2017.
 */
public class Slot extends Place {

    private FamilyMember mFamilyMember;
    private int mDiceValue;

    /**
     *
     * @param diceValue Dice value of the area
     * @param familyMember Family member who is in the area
     */

    public Slot(int diceValue, FamilyMember familyMember) {
        mDiceValue = diceValue;
        mFamilyMember = familyMember;
    }

    /**
     *
     * @return Family member who is in the area
     */

    public FamilyMember getFamilyMember() {
        return mFamilyMember;
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
     * @param familyMember Family member to set
     */

    public void setFamilyMember(FamilyMember familyMember) {
        mFamilyMember = familyMember;
    }

    public boolean isFree(){
        if (mFamilyMember ==null)
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

    @Override
    public String toString(){

        StringJoiner mStringSlot = new StringJoiner("\n     ", "", "");

        mStringSlot.add("");
        mStringSlot.add("Dice value: " + mDiceValue);
        mStringSlot.add("Family Member: " + mFamilyMember);



        return mStringSlot.toString();
    }
}

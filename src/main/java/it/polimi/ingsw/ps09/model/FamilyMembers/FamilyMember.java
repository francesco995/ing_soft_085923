package it.polimi.ingsw.ps09.model.FamilyMembers;


import it.polimi.ingsw.ps09.model.Dices.Dice;

import java.util.StringJoiner;

/**
 * Abstract class familyMember
 * Basic variables are power(the placement value of the familyMember it's set every turn by the diceValues
 * Color and family are string used to describe the familyMember
 * isUsable is set to true every start of round and to false when the familyMember is no longer usable
 * It implements the toString necessary to display familyMember content
 */
public abstract class FamilyMember {

    //VARIABLES
    private int mPower;
    private String mColor;
    private String mFamily;
    private boolean mIsUsable;
    //METHODS
    public FamilyMember(int power, String color, String family) {
        mPower = power;
        mColor = color;
        mFamily = family;
    }

    public int getPower() {
        return mPower;
    }

    public String getColor() {
        return mColor;
    }

    public void setPower(Dice dice) {
        mPower = dice.getValue();
    }

    public int morePower(int addToTotal) {
        return mPower + addToTotal;
    }

    public int lessPower(int removeFromTotal) {
        return mPower - removeFromTotal;
    }

    public String getFamily() {
        return mFamily;
    }

    public boolean isUsable() {
        return mIsUsable;
    }

    public void used(){
        mIsUsable = false;
    }
    public void setUsable(){
        mIsUsable = true;
    }

    @Override
    public String toString(){

        String mIsUsableString;
        if(mIsUsable)
            mIsUsableString = "Yes";
        else
            mIsUsableString ="No";

        String mStringFamilyMember ="\n";

        mStringFamilyMember += "Family: " +mFamily;
        mStringFamilyMember += "  |  Color:" + mColor;
        mStringFamilyMember += "  |  Power:" + mPower;
        mStringFamilyMember += "  | Available-->" + mIsUsableString;


        return mStringFamilyMember.toString();

    }

}

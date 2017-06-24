package it.polimi.ingsw.ps09.model.FamilyMembers;


import it.polimi.ingsw.ps09.model.Dices.Dice;

import java.util.StringJoiner;

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

        StringJoiner mStringFamilyMember = new StringJoiner("\n", "", "");

        mStringFamilyMember.add("");
        mStringFamilyMember.add("Family: " + mFamily);
        mStringFamilyMember.add("Color: " + mColor);
        mStringFamilyMember.add("Power: " + mPower);

        if(mIsUsable==true)
            mIsUsableString = "Yes";
        else
            mIsUsableString = "No";

        mStringFamilyMember.add("Available: " + mIsUsableString);

        return mStringFamilyMember.toString();


    }

}

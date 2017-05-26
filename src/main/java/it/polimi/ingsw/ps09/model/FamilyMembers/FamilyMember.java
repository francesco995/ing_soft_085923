package it.polimi.ingsw.ps09.model.FamilyMembers;


import it.polimi.ingsw.ps09.model.Dices.Dice;

public class FamilyMember {

    //VARIABLES
    private int mPower;
    private String mColor;
    private String mFamily;

    //METHODS
    public FamilyMember(int power, String color, String family) {
        mPower = power;
        mColor = color;
        mFamily = family;
    }

    public int getPower() {
        return mPower;
    }

    public void setPower(Dice dice) {
        mPower = dice.getValue();
    }

    public int morePower(int addToTotal) {
        return mPower + addToTotal;
    }

    public int lessPower(int removeToTotal) {
        return mPower - removeToTotal;
    }

    public String getFamily() {
        return mFamily;
    }
}

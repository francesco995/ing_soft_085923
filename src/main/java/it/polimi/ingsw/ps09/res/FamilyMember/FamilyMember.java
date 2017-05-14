package it.polimi.ingsw.ps09.res.FamilyMember;


import it.polimi.ingsw.ps09.res.Dices.Dice;

public class FamilyMember {
    //VARIABILI
    private int mPower;
    private String mColor;
    private String mFamily;
    //METHODS
    public FamilyMember(int power,String color, String family) {
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

    public int morePower(int addToTotal)
    {
        return mPower+addToTotal;
    }

    public int lessPower(int removeToTotal)
    {
        return mPower-removeToTotal;
    }

    public String getFamily() {
        return mFamily;
    }
}

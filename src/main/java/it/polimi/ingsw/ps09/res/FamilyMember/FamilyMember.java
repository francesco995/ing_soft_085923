package it.polimi.ingsw.ps09.res.FamilyMember;


import it.polimi.ingsw.ps09.res.Dices.Dice;

public class FamilyMember {
    //VARIABILI
    private int mPower;
    private String mColor;
    //METHODS
    public FamilyMember(int power,String color) {
        mPower = power;
        mColor = color;
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
}

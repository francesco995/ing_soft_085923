package it.polimi.ingsw.ps09.model.FamilyMembers;


import it.polimi.ingsw.ps09.controller.Game.Game;
import it.polimi.ingsw.ps09.model.Dices.Dice;
import it.polimi.ingsw.ps09.model.Player;

import java.util.StringJoiner;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

/**
 * Abstract class familyMember
 * Basic variables are power(the placement value of the familyMember it's set every turn by the diceValues
 * Color and family are string used to describe the familyMember
 * isUsable is set to true every start of round and to false when the familyMember is no longer usable
 * It implements the toString necessary to display familyMember content
 */
public abstract class FamilyMember {

    //LOGGER
    private static final Logger mLogger = Logger.getAnonymousLogger();

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

    public void morePower(int addToTotal) {

        mPower += addToTotal;

        mLogger.log(INFO, "Game: " + Game.GAME_ID + " player " +
                Player.PLAYER_ID + " increase family member power by " + addToTotal +
                " now has " + mPower + " power");
    }

    public void lessPower(int removeFromTotal) {

        mPower =- removeFromTotal;

        mLogger.log(INFO, "Game: " + Game.GAME_ID + " player " +
                Player.PLAYER_ID + " decrease family member power by " + removeFromTotal +
                " now has " + mPower + " power");
    }

    public String getFamily() {
        return mFamily;
    }

    public int getPlayerId(){
        return Player.PLAYER_ID;
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
        mStringFamilyMember += "  | Available--> " + mIsUsableString;


        return mStringFamilyMember.toString();

    }

}

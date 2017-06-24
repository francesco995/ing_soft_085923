package it.polimi.ingsw.ps09.model.Places.Market;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.ps09.model.BoardBonus;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.Place;

import java.util.StringJoiner;

/**
 * Created by ale on 09/05/2017.
 */
public class MarketSpace extends Place {

    private FamilyMember mFamilyMember;
    protected BoardBonus mBoardBonus;
    private int mDiceValue;
    private int mIndex;

    public MarketSpace(int DiceValue, int Index) {
        mDiceValue = DiceValue;
        mIndex = Index;
    }

    /**
     *
     * @return Family member into marketspace
     */
    public FamilyMember getFamilyMember() {
        return mFamilyMember;
    }

    /**
     *
     * @return BoardBonus that the player gain into the marketspace
     */
    public BoardBonus getBoardBonus() {
        return mBoardBonus;
    }

    /**
     *
     * @return Dice value to access into marketspace
     */
    public int getDiceValue() {
        return mDiceValue;
    }

    /**
     *
     * @param familyMember Set the family member into marketspace
     */
    public void setFamilyMember(FamilyMember familyMember) {
        mFamilyMember = familyMember;
    }

    /**
     *
     * @param boardBonus Set the marketspace's boardBonus which the player will gain
     */
    public void setBoardBonus(BoardBonus boardBonus) {
        mBoardBonus = boardBonus;
    }

    /**
     *
     * @param diceValue Set the dice value required to access
     */
    public void setDiceValue(int diceValue) {
        mDiceValue = diceValue;
    }

    public int getIndex(){
        return mIndex;
    }

    /**
     *
     * @return Boolean value: true if there's no family member into that marketspace,
     * false if there's one
     */
    //Check if MarketSpace is available
    public boolean isAvailable(){
        if(mFamilyMember ==null)
            return true;

        else
            return false;
    }

    /**
     *
     * @return All market space's information
     */
    @Override
    public String toString(){


        StringJoiner mStringMarket = new StringJoiner("\n     ", "", "");

        mStringMarket.add("");
        mStringMarket.add("Family Member: " + mFamilyMember);

        mStringMarket.add("Bonus: "
                + mBoardBonus.getPointsBonus().toString()
                + mBoardBonus.getResourcesBonus().toString()
                + " Privilage count: " + mBoardBonus.getPrivilegesCount());

        mStringMarket.add("Dice Value: " + mDiceValue);

        return mStringMarket.toString();
    }

}

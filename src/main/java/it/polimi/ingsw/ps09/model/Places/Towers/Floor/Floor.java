package it.polimi.ingsw.ps09.model.Places.Towers.Floor;

import it.polimi.ingsw.ps09.model.BoardBonus;
import it.polimi.ingsw.ps09.model.DevelopmentCards.DevelopmentCard;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;

import java.util.StringJoiner;

/**
 * Created by ale on 10/05/2017.
 */
public class Floor {

    private int mDiceValue;
    private BoardBonus mBoardBonus;
    private DevelopmentCard mCard;
    private FamilyMember mFamilyMember;

    /**
     *
     * @param diceValue Set dice value to access on the floor
     */
    public Floor(int diceValue) {
        mDiceValue = diceValue;
    }

    /**
     *
     * @param familyMember Set floor's family memeber
     */
    public void setFamilyMember(FamilyMember familyMember) {
        mFamilyMember = familyMember;
    }

    /**
     *
     * @param boardBonus Set floor's boardBonus you get when access to a specified floor
     */
    public void setBoardBonus(BoardBonus boardBonus) {
        mBoardBonus = boardBonus;
    }

    /**
     *
     * @param card Set floor's card
     */
    public void setCard(DevelopmentCard card) {
        mCard = card;
    }

    /**
     *
     * @return Get family member object who is on the floor
     */
    public FamilyMember getFamilyMember() {
        return mFamilyMember;
    }

    /**
     *
     * @return Get floor's dice value
     */
    public int getDiceValue() {
        return mDiceValue;
    }

    /**
     *
     * @return Get the floor's instant bonus which is gained when a family member is set on that floor
     */
    public BoardBonus getBoardBonus() {
        return mBoardBonus;
    }

    /**
     *
     * @return Get floor's development card
     */
    public DevelopmentCard getCard() {
        return mCard;
    }

    /**
     *
     * @return Boolean value: true if the specified floor is available, false if not
     */
    public boolean isAvailable(){
        if(mFamilyMember ==null)
            return true;

        else
            return false;
    }

    @Override
    public String toString(){

        StringJoiner mStringFloor = new StringJoiner("\n          ", "", "");

        mStringFloor.add("");
        mStringFloor.add("Dice value: " + mDiceValue);
        mStringFloor.add("Bonus: " + mBoardBonus);
        mStringFloor.add("Card: " + mCard);
        mStringFloor.add("Family Memeber: " + mFamilyMember);
        mStringFloor.add("\n");



        return mStringFloor.toString();
    }

}

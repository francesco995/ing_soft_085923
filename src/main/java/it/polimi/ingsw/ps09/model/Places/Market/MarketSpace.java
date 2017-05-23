package it.polimi.ingsw.ps09.model.Places.Market;

import it.polimi.ingsw.ps09.model.BoardBonus;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.Place;

/**
 * Created by ale on 09/05/2017.
 */
public class MarketSpace extends Place {

    private FamilyMember mPawn;
    private BoardBonus mBoardBonus;
    private int mDiceValue;

    /**
     *
     * @return Family member into marketspace
     */
    public FamilyMember getPawn() {
        return mPawn;
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
     * @param pawn Set the family member into marketspace
     */
    public void setPawn(FamilyMember pawn) {
        mPawn = pawn;
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

    /**
     *
     * @return Boolean value: true if there's no family member into that marketspace,
     * false if there's one
     */
    //Check if MarketSpace is available
    public boolean isAvailable(){
        if(mPawn==null)
            return true;

        else
            return false;
    }

}

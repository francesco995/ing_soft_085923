package it.polimi.ingsw.ps09.model.Places.Towers.Floor;

import it.polimi.ingsw.ps09.model.DevelopmentCards.DevelopmentCard;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Resources.Bonus;

/**
 * Created by ale on 10/05/2017.
 */
public class Floor {

    private int mDiceValue;
    private Bonus mBonus;
    private DevelopmentCard mCard;
    private FamilyMember mPawn;

    /**
     *
     * @param diceValue Set dice value to access on the floor
     */
    public Floor(int diceValue) {
        mDiceValue = diceValue;
    }

    /**
     *
     * @param pawn Set floor's family memeber
     */
    public void setPawn(FamilyMember pawn) {
        mPawn = pawn;
    }

    /**
     *
     * @param bonus Set floor's bonus you get when access to a specified floor
     */
    public void setBonus(Bonus bonus) {
        mBonus = bonus;
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
    public FamilyMember getPawn() {
        return mPawn;
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
    public Bonus getBonus() {
        return mBonus;
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
        if(mPawn==null)
            return true;

        else
            return false;
    }

}

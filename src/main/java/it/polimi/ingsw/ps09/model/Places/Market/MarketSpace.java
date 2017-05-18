package it.polimi.ingsw.ps09.model.Places.Market;

import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.Place;
import it.polimi.ingsw.ps09.model.Resources.Bonus;

/**
 * Created by ale on 09/05/2017.
 */
public class MarketSpace extends Place {

    private FamilyMember mPawn;
    private Bonus mBonus;
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
     * @return Bonus that the player gain into the marketspace
     */
    public Bonus getBonus() {
        return mBonus;
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
     * @param bonus Set the marketspace's bonus which the player will gain
     */
    public void setBonus(Bonus bonus) {
        mBonus = bonus;
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

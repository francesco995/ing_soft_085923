package it.polimi.ingsw.ps09.model.Places.Market;

import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.Place;
import it.polimi.ingsw.ps09.model.Bonus;

/**
 * Created by ale on 09/05/2017.
 */
public class MarketSpace extends Place {

    private FamilyMember mPawn;
    private Bonus mBonus;
    private int mDiceValue;

    public FamilyMember getPawn() {
        return mPawn;
    }

    public Bonus getBonus() {
        return mBonus;
    }

    public int getDiceValue() {
        return mDiceValue;
    }

    public void setPawn(FamilyMember pawn) {
        mPawn = pawn;
    }

    public void setBonus(Bonus bonus) {
        mBonus = bonus;
    }

    public void setDiceValue(int diceValue) {
        mDiceValue = diceValue;
    }

    //Check if MarketSpace is available
    public boolean isAvailable(){
        if(mPawn==null)
            return true;

        else
            return false;
    }

}

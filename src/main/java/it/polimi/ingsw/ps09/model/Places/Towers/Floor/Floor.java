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

    public Floor(int diceValue) {
        mDiceValue = diceValue;
    }

    public void setPawn(FamilyMember pawn) {
        mPawn = pawn;
    }

    public void setBonus(Bonus bonus) {
        mBonus = bonus;
    }

    public void setCard(DevelopmentCard card) {
        mCard = card;
    }

    public FamilyMember getPawn() {
        return mPawn;
    }

    public int getDiceValue() {
        return mDiceValue;
    }

    public Bonus getBonus() {
        return mBonus;
    }

    public DevelopmentCard getCard() {
        return mCard;
    }

    public boolean isAvailable(){
        if(mPawn==null)
            return true;

        else
            return false;
    }

}

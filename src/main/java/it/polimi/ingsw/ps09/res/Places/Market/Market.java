package it.polimi.ingsw.ps09.res.Places.Market;

import com.sun.corba.se.spi.ior.ObjectKey;
import it.polimi.ingsw.ps09.res.FamilyMember.FamilyMember;
import it.polimi.ingsw.ps09.res.Places.Place;
import it.polimi.ingsw.ps09.res.Resources.Bonus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ale on 09/05/2017.
 */
public class Market extends Place {

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

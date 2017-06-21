package it.polimi.ingsw.ps09.model.Places.Market;

import it.polimi.ingsw.ps09.model.BoardBonus;
import it.polimi.ingsw.ps09.model.Bonus.HarvestAndProductionBonus;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.FamilyMembers.OrangeFamilyMember;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by walle on 14/06/17.
 */
public class MarketSpaceTest {

    MarketSpace mMarketSpace;
    FamilyMember mFamilyMember;
    BoardBonus mBonus;

    @Before
    public void setUp() throws Exception {

        mMarketSpace = new MarketSpace(1);
        mFamilyMember = new OrangeFamilyMember("Orange");

        //TODO: rifare bonus qui
        //mBonus = new BoardBonus();
    }

    @Test
    public void setFamilyMember() throws Exception {
        mMarketSpace.setFamilyMember(mFamilyMember);

        assertEquals(mFamilyMember, mMarketSpace.getFamilyMember());
    }

    @Test
    public void setBoardBonus() throws Exception {
        mMarketSpace.setBoardBonus(mBonus);
    }

    @Test
    public void setDiceValue() throws Exception {
        mMarketSpace.setDiceValue(3);

        assertEquals(3, mMarketSpace.getDiceValue());
    }

    @Test
    public void isAvailableMustBeTrue() throws Exception {
        assertEquals(true, mMarketSpace.isAvailable());

    }

    @Test
    public void isAvailableMustBeFalse() throws Exception {
        mMarketSpace.setFamilyMember(mFamilyMember);

        assertEquals(false, mMarketSpace.isAvailable());

    }

}
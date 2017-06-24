package it.polimi.ingsw.ps09.model.Places.Market;

import it.polimi.ingsw.ps09.model.BoardBonus;
import it.polimi.ingsw.ps09.model.Bonus.HarvestAndProductionBonus;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.FamilyMembers.OrangeFamilyMember;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;
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
    UserResources mUserResources = new UserResources(1,2,1,3);
    UserPoints mUserPoints = new UserPoints(1,1,3);

    @Before
    public void setUp() throws Exception {

        mMarketSpace = new MarketSpace(1, 1);
        mFamilyMember = new OrangeFamilyMember("Orange");

        mBonus = new BoardBonus(mUserResources, mUserPoints, 1);
    }

    @Test
    public void setFamilyMemberTest() throws Exception {
        mMarketSpace.setFamilyMember(mFamilyMember);

        assertEquals(mFamilyMember, mMarketSpace.getFamilyMember());
    }

    @Test
    public void setBoardBonusTest() throws Exception {
        mMarketSpace.setBoardBonus(mBonus);
    }

    @Test
    public void setDiceValueTest() throws Exception {
        mMarketSpace.setDiceValue(3);

        assertEquals(3, mMarketSpace.getDiceValue());
    }

    @Test
    public void isAvailableMustBeTrueTest() throws Exception {
        assertEquals(true, mMarketSpace.isAvailable());

    }

    @Test
    public void isAvailableMustBeFalseTest() throws Exception {
        mMarketSpace.setFamilyMember(mFamilyMember);

        assertEquals(false, mMarketSpace.isAvailable());

    }

}
package it.polimi.ingsw.ps09.model.Places.Market;

import it.polimi.ingsw.ps09.model.FamilyMembers.OrangeFamilyMember;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by walle on 13/06/17.
 */
public class MarketTest {

    private Market mMarket;
    private OrangeFamilyMember mFamilyMember = new OrangeFamilyMember("Smith");

    @Before
    public void setUp() throws Exception {

        mMarket = new Market();
        mMarket.getMarketList().get(0).setFamilyMember(mFamilyMember);
    }

    @Test
    public void diceValueIsEqualOneTest(){

        assertEquals(1, mMarket.getMarketList().get(0).getDiceValue());

    }

    @Test
    public void clearAllDeleteFamilyMemberTest(){

        mMarket.clearAll();

        assertEquals(null, mMarket.getMarketList().get(0).getFamilyMember());
    }

    @Test
    public void clearAllDoNotDeleteDiceValueTest(){

        assertEquals(1, mMarket.getMarketList().get(0).getDiceValue());
    }

}
package it.polimi.ingsw.ps09.model.Places.Market;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by walle on 13/06/17.
 */
public class MarketTest {

    private Market mMarket;

    @Before
    public void setUp() throws Exception {

        mMarket = new Market();
    }

    @Test
    public void diceValueIsEqualOne(){

        assertEquals(1, mMarket.getMarketList().get(0).getDiceValue());

    }

    @Test
    public void clearAllDeleteFamilyMember(){

        assertEquals(null, mMarket.getMarketList().get(0).getFamilyMember());
    }

    @Test
    public void clearAllDoNotDeleteDiceValue(){

        assertEquals(1, mMarket.getMarketList().get(0).getDiceValue());
    }

}
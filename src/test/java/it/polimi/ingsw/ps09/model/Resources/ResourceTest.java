package it.polimi.ingsw.ps09.model.Resources;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Created by francesco995 on 21/05/2017.
 */
public class ResourceTest {

    Coins mCoins;

    @Before
    public void setUp() throws Exception {
        mCoins = new Coins(10);
    }

    @Test
    public void addCoins() throws Exception {

        mCoins.add(new Coins(10));

        assertEquals(20, mCoins.getValue());

    }

    @Test
    public void removeTest() throws Exception {

        mCoins.remove(new Coins(10));

        assertEquals(0, mCoins.getValue());

    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeMoreCoinsThanAvailableThrowsException() throws Exception {

        mCoins.remove(new Coins(11));

    }

    @Test
    public void isGreaterOrEqualReturnsTrueWhenEqual() throws Exception {

        assertTrue(mCoins.isGreaterOrEqual(new Coins(10)));
    }

    @Test
    public void isGreaterOrEqualReturnsTrueWhenGreater() throws Exception {

        assertTrue(mCoins.isGreaterOrEqual(new Coins(9)));
    }

}
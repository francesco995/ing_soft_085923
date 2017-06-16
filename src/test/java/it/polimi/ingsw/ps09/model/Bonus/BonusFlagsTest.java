package it.polimi.ingsw.ps09.model.Bonus;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by franc on 16/06/2017.
 */
public class BonusFlagsTest {

    BonusFlags mTest;

    @Before
    public void setUp() throws Exception {
        mTest = new BonusFlags();
    }

    @Test
    public void isFlagContainedFoundReturnsFalse() throws Exception {

        mTest.putBonus("test");
        assertFalse(mTest.getBonus("test"));

    }

    @Test
    public void isFlagNotContainedReturnsTrue() throws Exception {

        assertTrue(mTest.getBonus("test"));

    }

}
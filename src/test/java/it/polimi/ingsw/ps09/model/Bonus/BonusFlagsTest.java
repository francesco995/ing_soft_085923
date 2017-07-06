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
    public void isFlagContainedFoundReturnsTure() throws Exception {

        mTest.putBonus("test");
        assertTrue(mTest.getBonus("test"));

    }

    @Test
    public void isFlagNotContainedReturnsFalse() throws Exception {

        assertFalse(mTest.getBonus("test"));

    }

}
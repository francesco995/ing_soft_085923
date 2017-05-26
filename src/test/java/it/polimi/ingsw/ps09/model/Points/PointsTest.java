package it.polimi.ingsw.ps09.model.Points;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by francesco995 on 26/05/2017.
 */
public class PointsTest {

    VictoryPoints mVictoryPoints;

    @Before
    public void setUp() throws Exception {
        mVictoryPoints = new VictoryPoints(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createNegativePointsThrowException () throws Exception{

        mVictoryPoints = new VictoryPoints(-1);

    }

    @Test
    public void addCoins() throws Exception {

        mVictoryPoints.add(new VictoryPoints(10));

        assertEquals(20, mVictoryPoints.getValue());

    }

    @Test
    public void removeTest() throws Exception {

        mVictoryPoints.remove(new VictoryPoints(10));

        assertEquals(0, mVictoryPoints.getValue());

    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeMorePointsThanAvailableThrowsException() throws Exception {

        mVictoryPoints.remove(new VictoryPoints(11));

    }

    @Test
    public void isGreaterOrEqualReturnsTrueWhenEqual() throws Exception {

        assertTrue(mVictoryPoints.isGreaterOrEqual(new VictoryPoints(10)));
    }

    @Test
    public void isGreaterOrEqualReturnsTrueWhenGreater() throws Exception {

        assertTrue(mVictoryPoints.isGreaterOrEqual(new VictoryPoints(9)));
    }

}
package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.Points.FaithPoints;
import it.polimi.ingsw.ps09.model.Points.MilitaryPoints;
import it.polimi.ingsw.ps09.model.Points.VictoryPoints;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by francesco995 on 26/05/2017.
 */
public class UserPointsTest {

    UserPoints mUserPoints;

    @Before
    public void setUp() throws Exception {

        mUserPoints = new UserPoints(10, 10,10);

    }

    @Test
    public void getFaithPointsTest() throws Exception {

        assertEquals(10, mUserPoints.getFaithPoints().getValue());

    }

    @Test
    public void getMilitaryPointsTest() throws Exception {

        assertEquals(10, mUserPoints.getMilitaryPoints().getValue());

    }

    @Test
    public void getVictoryPointsTest() throws Exception {

        assertEquals(10, mUserPoints.getVictoryPoints().getValue());

    }

    @Test
    public void addUserPointsTest() throws Exception {

        mUserPoints.add(new UserPoints(5, 5, 5));

        assertEquals(15, mUserPoints.getVictoryPoints().getValue());
        assertEquals(15, mUserPoints.getMilitaryPoints().getValue());
        assertEquals(15, mUserPoints.getFaithPoints().getValue());

    }

    @Test
    public void addFaithPointsTest() throws Exception {

        mUserPoints.add(new FaithPoints(10));

        assertEquals(20, mUserPoints.getFaithPoints().getValue());

    }

    @Test
    public void addMilitaryPointsTest() throws Exception {

        mUserPoints.add(new MilitaryPoints(10));

        assertEquals(20, mUserPoints.getMilitaryPoints().getValue());

    }

    @Test
    public void addVictoryPointsTest() throws Exception {

        mUserPoints.add(new VictoryPoints(10));

        assertEquals(20, mUserPoints.getVictoryPoints().getValue());

    }

    @Test
    public void removeUserPointsTest() throws Exception {

        mUserPoints.remove( new UserPoints(5, 5, 5));

        assertEquals(5, mUserPoints.getVictoryPoints().getValue());
        assertEquals(5, mUserPoints.getMilitaryPoints().getValue());
        assertEquals(5, mUserPoints.getFaithPoints().getValue());

    }

    @Test
    public void removeFaithPointsTest() throws Exception {

        mUserPoints.remove(new FaithPoints(10));

        assertEquals(0, mUserPoints.getFaithPoints().getValue());

    }

    @Test
    public void removeMilitaryPointsTest() throws Exception {

        mUserPoints.remove(new MilitaryPoints(10));

        assertEquals(0, mUserPoints.getMilitaryPoints().getValue());

    }

    @Test
    public void removeVictoryPointsTest() throws Exception {

        mUserPoints.remove(new VictoryPoints(10));

        assertEquals(0, mUserPoints.getVictoryPoints().getValue());

    }

    @Test
    public void clearFaithPointsTest() throws Exception {

        mUserPoints.clearFaithPoints();

        assertEquals(0, mUserPoints.getFaithPoints().getValue());

    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeMoreUserPointsThanPlayerHasTest() throws Exception {

        mUserPoints.remove( new UserPoints(50, 50, 50));

    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeMoreFaithPointsThanPlayerHasTest() throws Exception {

        mUserPoints.remove(new FaithPoints(50));

    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeMoreMilitaryPointsThanPlayerHasTest() throws Exception {

        mUserPoints.remove(new MilitaryPoints(50));

    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeMoreVictoryPointsThanPlayerHasTest() throws Exception {

        mUserPoints.remove(new VictoryPoints(50));

    }

}
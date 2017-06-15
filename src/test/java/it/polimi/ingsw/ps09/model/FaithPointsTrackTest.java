package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.Points.FaithPoints;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by franc on 14/06/2017.
 */
public class FaithPointsTrackTest {

    FaithPointsTrack mTest;
    @Before
    public void setUp() throws Exception {

         mTest = new FaithPointsTrack();

    }


    @Test
    public void isConvertingintoVictoryPoints() throws Exception {

        int x = 3;
        FaithPoints mPoints = new FaithPoints(x);
        assertEquals(mTest.getVictoryPointsBonus().get(x), mTest.convertToBonus(mPoints));

    }

}
package it.polimi.ingsw.ps09.model.Decks;

import it.polimi.ingsw.ps09.Constants;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by franc on 16/06/2017.
 */
public class LeaderCardsDeckTest {

    LeaderCardsDeck mTest;

    @Before
    public void setUp() throws Exception {
        mTest = new LeaderCardsDeck();
    }

    @Test
    public void areAllCardLoaded() throws Exception {
        assertTrue(Constants.CARD_TOTAL == mTest.getDeck().size());
    }
    @Test
    public void areAllCardDrawn() throws Exception {
        assertTrue(Constants.HAND_SIZE == mTest.cardDraw().size());
    }

}
package it.polimi.ingsw.ps09.model.Decks;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by franc on 16/06/2017.
 */


public class ExcommunicationTilesDeckTest {

    ExcommunicationTilesDeck mTest;
    @Before
    public void setUp() throws Exception {
        mTest = new ExcommunicationTilesDeck();
        System.out.println("");
    }

    @Test
    public void drawCard() throws Exception {

        assertFalse(mTest.drawCard(1).getPeriod()!= mTest.getDeck().get(1).get(1).getPeriod());
    }

}


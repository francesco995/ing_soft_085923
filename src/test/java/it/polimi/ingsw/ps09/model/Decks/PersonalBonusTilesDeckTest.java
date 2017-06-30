package it.polimi.ingsw.ps09.model.Decks;

import it.polimi.ingsw.ps09.Constants;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by franc on 30/06/2017.
 */
public class PersonalBonusTilesDeckTest {
    PersonalBonusTilesDeck mTest;
    @Before
    public void setUp() throws Exception {

        mTest = new PersonalBonusTilesDeck();
    }

    @Test
    public void isDeckLoaded(){

        assertTrue(mTest.getDeck().size() == Constants.TILE_TOTAL);

    }
}
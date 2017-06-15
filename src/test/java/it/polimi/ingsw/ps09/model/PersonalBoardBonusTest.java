package it.polimi.ingsw.ps09.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by franc on 15/06/2017.
 */
public class PersonalBoardBonusTest {

    PersonalBoardBonus mTest;

    @Before
    public void setUp() throws Exception {

        mTest = new PersonalBoardBonus();

    }

    @Test
    public void endTerritoriesBonus() throws Exception {

        int x = 3;

        assertEquals(mTest.getTerritoriesBonus().get(x), mTest.EndTerritoriesBonus(x));

    }

    @Test
    public void endCharactersBonus() throws Exception {

        int x = 3;
        assertEquals(mTest.getCharacterBonus().get(x), mTest.EndCharactersBonus(x));

    }

}
package it.polimi.ingsw.ps09.model.Dices;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by francesco995 on 23/05/2017.
 */
public class DiceTest {

    WhiteDice mDice;

    @Before
    public void setUp() throws Exception {

        mDice = new WhiteDice();
    }

    @Test
    public void getValueReturnsValue() throws Exception {

        mDice.setValue(5);

        assertEquals(5, mDice.getValue());
    }

    @Test
    public void getColorReturnsColor() throws Exception {

        assertEquals("White", mDice.getColor());
    }

    @Test
    public void rollValueIsBetweenOneAndSix() throws Exception {

        boolean isValid = true;
        for(int i=0; i<100000; i++){
            mDice.roll();
            if( mDice.getValue()>6 || mDice.getValue()<1 )
                isValid = false;
        }

        assertTrue(isValid);

    }

}
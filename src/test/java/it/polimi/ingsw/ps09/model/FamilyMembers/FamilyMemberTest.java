package it.polimi.ingsw.ps09.model.FamilyMembers;

import it.polimi.ingsw.ps09.model.Dices.BlackDice;
import it.polimi.ingsw.ps09.model.Dices.Dice;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by franc on 15/06/2017.
 */
public class FamilyMemberTest {

    BlackFamilyMember mTest;
    @Before
    public void setUp() throws Exception {

        String familyColor = "blue";
        mTest = new BlackFamilyMember(familyColor);
    }

    @Test
    public void isPowerSet(){

        Dice mDice = new BlackDice();
        mDice.roll();
        mTest.setPower(mDice);
        assertEquals(mDice.getValue(), mTest.getPower());

    }

    @Test
    public void hasFamilyMemberMorePower() throws Exception {

        assertTrue(mTest.getPower() < mTest.morePower(1));

    }

    @Test
    public void hasFamilyMemberLessPower() throws Exception {

        assertTrue(mTest.getPower() > mTest.lessPower(1));

    }
}
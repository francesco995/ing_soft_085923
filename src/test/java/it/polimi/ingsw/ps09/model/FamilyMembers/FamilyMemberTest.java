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

        int powerBefore = mTest.getPower();
        mTest.morePower(1);
        assertTrue(mTest.getPower() > powerBefore);

    }

    @Test
    public void hasFamilyMemberLessPower() throws Exception {

        Dice mDice = new BlackDice();
        mDice.roll();
        mTest.setPower(mDice);
        int powerBefore = mTest.getPower();
        mTest.lessPower(1);
        assertTrue(mTest.getPower() < powerBefore);

    }

    @Test
    public void isNowUsable() throws Exception {

        mTest.setUsable();
        assertTrue(mTest.isUsable());

    }
    @Test
    public void isNowUnusable() throws Exception {

        mTest.used();
        assertFalse(mTest.isUsable());

    }
}
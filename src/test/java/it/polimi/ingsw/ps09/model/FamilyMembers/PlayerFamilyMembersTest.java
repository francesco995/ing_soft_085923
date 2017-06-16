package it.polimi.ingsw.ps09.model.FamilyMembers;

import it.polimi.ingsw.ps09.model.Dices.BlackDice;
import it.polimi.ingsw.ps09.model.Dices.Dice;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by franc on 16/06/2017.
 */
public class PlayerFamilyMembersTest {

    PlayerFamilyMembers mTest;
    @Before
    public void setUp() throws Exception {
        mTest = new PlayerFamilyMembers("yellow");
    }

    @Test
    public void isPlayerColorSetted() throws Exception {
        assertTrue(mTest.getFamilyMember("black").getFamily().equalsIgnoreCase("yellow"));
    }
/*
    @Test
    public void isPowerSetted() throws Exception {
        Dice mDice = new BlackDice();
        mDice.roll();
        mTest.setFamilyMemberPower("black", mDice);
        assertEquals(mDice.getValue(), mTest.getFamilyMember("black").getPower());
    }*/

}
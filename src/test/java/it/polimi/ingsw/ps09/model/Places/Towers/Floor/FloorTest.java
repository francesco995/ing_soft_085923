package it.polimi.ingsw.ps09.model.Places.Towers.Floor;

import it.polimi.ingsw.ps09.model.FamilyMembers.BlackFamilyMember;
import it.polimi.ingsw.ps09.model.FamilyMembers.OrangeFamilyMember;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by walle on 14/06/17.
 */
public class FloorTest {

    private Floor mFloor;
    private OrangeFamilyMember mFamilyMember1;
    private BlackFamilyMember mFamilyMember2;

    @Before
    public void setUp() throws Exception {
        //mFloor = new Floor(1);
        mFamilyMember1 = new OrangeFamilyMember("Smith");
        mFamilyMember2 = new BlackFamilyMember("Smith");

    }

    @Test
    public void setFamilyMember() throws Exception {
        mFloor.setFamilyMember(mFamilyMember1);

        assertEquals(mFamilyMember1, mFloor.getFamilyMember());
    }

    @Test
    public void setBoardBonus() throws Exception {
    }

    @Test
    public void setCard() throws Exception {
    }

    @Test
    public void isAvailable() throws Exception {
        mFloor.setFamilyMember(mFamilyMember1);

        assertEquals(false, mFloor.isAvailable());
    }

}
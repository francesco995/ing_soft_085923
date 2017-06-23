package it.polimi.ingsw.ps09.model.Places.HarvestAndProductionAreas;

import it.polimi.ingsw.ps09.model.FamilyMembers.BlackFamilyMember;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.FamilyMembers.OrangeFamilyMember;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by walle on 22/06/17.
 */
public class SlotTest {

    private OrangeFamilyMember mOrangeFamilyMember;
    private BlackFamilyMember mBlackFamilyMember;
    private Slot mSlot;

    @Before
    public void setUp() throws Exception {

        mOrangeFamilyMember = new OrangeFamilyMember("Smith");
        mBlackFamilyMember = new BlackFamilyMember("Simpson");

        mSlot = new Slot(7, mOrangeFamilyMember);

    }

    @Test
    public void setFamilyMemberTest() throws Exception{

        mSlot.setFamilyMember(mBlackFamilyMember);

        assertEquals(true, mSlot.getFamilyMember().equals(mBlackFamilyMember));

    }

    @Test
    public void getFamilyMemberTest() throws Exception{

        assertEquals(true, mSlot.getFamilyMember().equals(mOrangeFamilyMember));

    }

    @Test
    public void getDiceValueTest() throws Exception{

        assertEquals(7, mSlot.getDiceValue());
    }

    @Test
    public void setDiceValueTest() throws Exception{

        mSlot.setDiceValue(2);

        assertEquals(2, mSlot.getDiceValue());

    }

}
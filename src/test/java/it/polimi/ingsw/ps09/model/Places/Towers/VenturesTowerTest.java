package it.polimi.ingsw.ps09.model.Places.Towers;

import it.polimi.ingsw.ps09.model.FamilyMembers.BlackFamilyMember;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.FamilyMembers.OrangeFamilyMember;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by walle on 28/06/17.
 */
public class VenturesTowerTest {

    private VenturesTower mVenturesTower;
    private FamilyMember mOrangeFamily;
    private FamilyMember mBlackFamily;

    @Before
    public void setUp() throws Exception {

        mVenturesTower = new VenturesTower();
        mOrangeFamily = new OrangeFamilyMember("Smith");
        mBlackFamily = new BlackFamilyMember("Smith");
        mVenturesTower.getFloor(1).setFamilyMember(mBlackFamily);

    }

    @Test
    public void SetFamilyMemberTest() throws Exception {
        mVenturesTower.getFloors().get(0).setFamilyMember(mOrangeFamily);

        assertEquals(mOrangeFamily, mVenturesTower.getFloors().get(0).getFamilyMember());
    }

    @Test
    public void hasFamilyMemberTest() throws Exception {

        assertEquals(true, mVenturesTower.hasFamilyMember());
    }

    @Test
    public void MustBeFreeTest() throws Exception {

        assertEquals(true, mVenturesTower.isFree(0));
    }

    @Test
    public void MustNotBeFreeTest() throws Exception {

        assertEquals(false, mVenturesTower.isFree(1));
    }

    @Test
    public void hasSameFamilyMemberTest() throws Exception {
        mVenturesTower.getFloors().get(3).setFamilyMember(mOrangeFamily);

        assertEquals(true, mVenturesTower.hasSameFamilyMember(mBlackFamily));
    }

    @Test
    public void clearAllTest() throws Exception {
        mVenturesTower.clearAll();

        assertEquals(4, mVenturesTower.getFloors().size());

    }

    @Test
    public void getColorTest() throws Exception{

        assertEquals(true, mVenturesTower.getColor().equals("purple"));
    }

}
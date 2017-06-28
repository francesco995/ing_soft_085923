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
public class BuildingsTowerTest {

    private BuildingsTower mBuildingsTower;
    private FamilyMember mOrangeFamily;
    private FamilyMember mBlackFamily;

    @Before
    public void setUp() throws Exception {
        mBuildingsTower = new BuildingsTower();
        mOrangeFamily = new OrangeFamilyMember("Smith");
        mBlackFamily = new BlackFamilyMember("Smith");
        mBuildingsTower.getFloor(1).setFamilyMember(mBlackFamily);
    }

    @Test
    public void SetFamilyMemberTest() throws Exception {
        mBuildingsTower.getFloors().get(0).setFamilyMember(mOrangeFamily);

        assertEquals(mOrangeFamily, mBuildingsTower.getFloors().get(0).getFamilyMember());
    }

    @Test
    public void hasFamilyMemberTest() throws Exception {

        assertEquals(true, mBuildingsTower.hasFamilyMember());
    }

    @Test
    public void MustBeFreeTest() throws Exception {

        assertEquals(true, mBuildingsTower.isFree(0));
    }

    @Test
    public void MustNotBeFreeTest() throws Exception {

        assertEquals(false, mBuildingsTower.isFree(1));
    }

    @Test
    public void hasSameFamilyMemberTest() throws Exception {
        mBuildingsTower.getFloors().get(3).setFamilyMember(mOrangeFamily);

        assertEquals(true, mBuildingsTower.hasSameFamilyMember(mBlackFamily));
    }

    @Test
    public void clearAllTest() throws Exception {
        mBuildingsTower.clearAll();

        assertEquals(4, mBuildingsTower.getFloors().size());

    }

    @Test
    public void getColorTest() throws Exception{

        assertEquals(true, mBuildingsTower.getColor().equals("yellow"));
    }

}
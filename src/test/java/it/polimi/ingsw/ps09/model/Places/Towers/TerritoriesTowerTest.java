package it.polimi.ingsw.ps09.model.Places.Towers;

import it.polimi.ingsw.ps09.model.FamilyMembers.BlackFamilyMember;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.FamilyMembers.OrangeFamilyMember;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by walle on 14/06/17.
 */
public class TerritoriesTowerTest {

    private TerritoriesTower mTerritoriesTower;
    private FamilyMember mOrangeFamily;
    private FamilyMember mBlackFamily;

    @Before
    public void setUp() throws Exception {
        mTerritoriesTower = new TerritoriesTower();
        mOrangeFamily = new OrangeFamilyMember("Smith");
        mBlackFamily = new BlackFamilyMember("Smith");
        mTerritoriesTower.getFloors().get(1).setFamilyMember(mBlackFamily);
    }

    @Test
    public void SetFamilyMemberTest() throws Exception {
        mTerritoriesTower.getFloors().get(0).setFamilyMember(mOrangeFamily);

        assertEquals(mOrangeFamily, mTerritoriesTower.getFloors().get(0).getFamilyMember());
    }

    @Test
    public void hasFamilyMemberTest() throws Exception {

        assertEquals(true, mTerritoriesTower.hasFamilyMember());
    }

    @Test
    public void MustBeFreeTest() throws Exception {

        assertEquals(true, mTerritoriesTower.isFree(0));
    }

    @Test
    public void MustNotBeFreeTest() throws Exception {

        assertEquals(false, mTerritoriesTower.isFree(1));
    }

    @Test
    public void hasSameFamilyMemberTest() throws Exception {
        mTerritoriesTower.getFloors().get(3).setFamilyMember(mOrangeFamily);

        assertEquals(true, mTerritoriesTower.hasSameFamilyMember(mBlackFamily));
    }

    @Test
    public void clearAllTest() throws Exception {
        mTerritoriesTower.clearAll();

        assertEquals(4, mTerritoriesTower.getFloors().size());

    }

    @Test
    public void getColorTest() throws Exception{

        assertEquals(true, mTerritoriesTower.getColor().equals("green"));
    }

}
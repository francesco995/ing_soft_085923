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
public class TowerTest {

    private TerritoriesTower mTerritoriesTower;
    private FamilyMember mOrangeFamily;
    private FamilyMember mBlackFamily;

    @Before
    public void setUp() throws Exception {
        mTerritoriesTower = new TerritoriesTower();
        mOrangeFamily = new OrangeFamilyMember("Smith");
        mBlackFamily = new BlackFamilyMember("Smith");
    }

    @Test
    public void SetterAndGetterWork() throws Exception {
        mTerritoriesTower.getFloors().get(0).setFamilyMember(mOrangeFamily);

        assertEquals(mOrangeFamily, mTerritoriesTower.getFloors().get(0).getFamilyMember());
    }

    @Test
    public void hasFamilyMember() throws Exception {
        mTerritoriesTower.getFloors().get(0).setFamilyMember(mOrangeFamily);

        assertEquals(false, mTerritoriesTower.getFloors().get(0).isAvailable());
    }

    @Test
    public void MustNotBeFree() throws Exception {
        mTerritoriesTower.getFloors().get(0).setFamilyMember(mOrangeFamily);

        assertEquals(false, mTerritoriesTower.isFree(0));
    }

    @Test
    public void MustBeFree() throws Exception {
        mTerritoriesTower.getFloors().get(0).setFamilyMember(mOrangeFamily);

        assertEquals(true, mTerritoriesTower.isFree(1));
    }

    @Test
    public void hasSameFamilyMember() throws Exception {
        mTerritoriesTower.getFloors().get(3).setFamilyMember(mOrangeFamily);

        assertEquals(true, mTerritoriesTower.hasSameFamilyMember(mBlackFamily));
    }

    @Test
    public void clearAll() throws Exception {
        mTerritoriesTower.getFloors().get(2).setFamilyMember(mBlackFamily);
        mTerritoriesTower.clearAll();

        assertEquals(4, mTerritoriesTower.getFloors().size());

    }

}
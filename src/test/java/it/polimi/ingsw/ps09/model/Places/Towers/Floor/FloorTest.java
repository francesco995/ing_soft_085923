package it.polimi.ingsw.ps09.model.Places.Towers.Floor;

import com.sun.prism.impl.BaseMesh;
import it.polimi.ingsw.ps09.model.FamilyMembers.BlackFamilyMember;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.FamilyMembers.OrangeFamilyMember;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by walle on 14/06/17.
 */
public class FloorTest {

    private Floor mBuildingTowerFloor;
    private Floor mVentureTowerFloor;
    private OrangeFamilyMember mFamilyMember1;
    private BlackFamilyMember mFamilyMember2;

    @Before
    public void setUp() throws Exception {
        mBuildingTowerFloor = new Floor(1, "Building/Floor1.json");
        mVentureTowerFloor = new Floor(3, "Venture/Floor3.json");

        mFamilyMember1 = new OrangeFamilyMember("Smith");
        mFamilyMember2 = new BlackFamilyMember("Smith");

        mBuildingTowerFloor.setFamilyMember(mFamilyMember1);

    }

    @Test
    public void getBoardBonusPrivilegeCountTest() throws Exception {

        assertEquals(0, mBuildingTowerFloor.getBoardBonus().getPrivilegesCount());

    }

    @Test
    public void getFamilyMemberTest() throws Exception{


        assertEquals(true, mBuildingTowerFloor.getFamilyMember().equals(mFamilyMember1));

    }

    @Test
    public void isAvailableTest() throws Exception{

        assertEquals(false, mBuildingTowerFloor.isAvailable());

    }

    @Test
    public void setFamilyMemberTest() throws Exception{

        mVentureTowerFloor.setFamilyMember(mFamilyMember1);

        assertEquals(false, mVentureTowerFloor.isAvailable());

    }

    @Test
    public void getDiceValueTest() throws Exception{

        assertEquals(3, mVentureTowerFloor.getDiceValue());
    }

}
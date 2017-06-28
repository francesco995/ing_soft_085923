package it.polimi.ingsw.ps09.model.Places.HarvestAndProductionAreas;

import it.polimi.ingsw.ps09.model.FamilyMembers.BlackFamilyMember;
import it.polimi.ingsw.ps09.model.FamilyMembers.OrangeFamilyMember;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by walle on 22/06/17.
 */
public class HarvestTest {

    private OrangeFamilyMember mOrangeFamilyMember;
    private BlackFamilyMember mBlackFamilyMember;
    private Harvest mHarvest;

    @Before
    public void setUp() throws Exception {

        mOrangeFamilyMember = new OrangeFamilyMember("Smith");
        mBlackFamilyMember = new BlackFamilyMember("Simpson");
        mHarvest = new Harvest();
        mHarvest.addMember(mBlackFamilyMember);

    }

    @Test
    public void getListSizeTest() throws Exception{

        assertEquals(1, mHarvest.getList().size());

    }

    @Test
    public void addMemberTest() throws Exception{

        mHarvest.addMember(mOrangeFamilyMember);

        assertEquals(2, mHarvest.getList().size());


    }

    @Test
    public void isAvailableTest() throws Exception{

        assertEquals(false, mHarvest.isAvailable(mBlackFamilyMember));

    }

    @Test
    public void clearAllTest() throws Exception{

        mHarvest.clearAll();

        assertEquals(0, mHarvest.getList().size());

    }


}
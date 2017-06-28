package it.polimi.ingsw.ps09.model.Places;

import it.polimi.ingsw.ps09.model.FamilyMembers.BlackFamilyMember;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.FamilyMembers.OrangeFamilyMember;
import it.polimi.ingsw.ps09.model.FamilyMembers.WhiteFamilyMember;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by walle on 28/06/17.
 */
public class CouncilTest {

    private Council  mCouncil = new Council();

    private OrangeFamilyMember mFamilyMember1 = new OrangeFamilyMember("Smith");
    private BlackFamilyMember mFamilyMember2 = new BlackFamilyMember("Smith");
    private WhiteFamilyMember mFamilyMember3 = new WhiteFamilyMember("Jhon");

    private List<FamilyMember> mList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        mCouncil.addFamilyMember(mFamilyMember1);
        mCouncil.addFamilyMember(mFamilyMember2);

        mList.add(mFamilyMember1);
        mList.add(mFamilyMember2);
    }

    @Test
    public void getFamilyMemberTEst() throws Exception{
        assertEquals(mFamilyMember1, mCouncil.getFamilyMember(0));

    }

    @Test
    public void addFamilyMemberTest() throws Exception{

        mCouncil.addFamilyMember(mFamilyMember2);

        assertEquals(true, mFamilyMember2.equals(mCouncil.getFamilyMember(2)));

    }

    @Test
    public void getListTest() throws Exception{
        assertEquals(true, mList.equals(mCouncil.getList()) );
    }

    @Test
    public void deleteDuplicateFamilyMemberTest() throws Exception{
        mCouncil.deleteDuplicateFamilyMember();

        assertEquals(1, mCouncil.getList().size());

    }



}
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
public class CharactersTowerTest {

    private CharactersTower mCharactersTower;
    private FamilyMember mOrangeFamily;
    private FamilyMember mBlackFamily;

    @Before
    public void setUp() throws Exception {

        mCharactersTower = new CharactersTower();
        mOrangeFamily = new OrangeFamilyMember("Smith");
        mBlackFamily = new BlackFamilyMember("Smith");
        mCharactersTower.getFloor(1).setFamilyMember(mBlackFamily);
    }

    @Test
    public void SetFamilyMemberTest() throws Exception {
        mCharactersTower.getFloors().get(0).setFamilyMember(mOrangeFamily);

        assertEquals(mOrangeFamily, mCharactersTower.getFloors().get(0).getFamilyMember());
    }

    @Test
    public void hasFamilyMemberTest() throws Exception {

        assertEquals(true, mCharactersTower.hasFamilyMember());
    }

    @Test
    public void MustBeFreeTest() throws Exception {

        assertEquals(true, mCharactersTower.isFree(0));
    }

    @Test
    public void MustNotBeFreeTest() throws Exception {

        assertEquals(false, mCharactersTower.isFree(1));
    }

    @Test
    public void hasSameFamilyMemberTest() throws Exception {
        mCharactersTower.getFloors().get(3).setFamilyMember(mOrangeFamily);

        assertEquals(true, mCharactersTower.hasSameFamilyMember(mBlackFamily));
    }

    @Test
    public void clearAllTest() throws Exception {
        mCharactersTower.clearAll();

        assertEquals(4, mCharactersTower.getFloors().size());

    }

    @Test
    public void getColorTest() throws Exception{

        assertEquals(true, mCharactersTower.getColor().equals("blue"));
    }

}
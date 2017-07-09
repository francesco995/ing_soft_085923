package it.polimi.ingsw.ps09.model.FamilyMembers;

/**
 * Simple blackFamilyMember object
 */
public class BlackFamilyMember extends FamilyMember {
    //initialized to 0
    public BlackFamilyMember(String family, int playerID) {

        super(0,"Black",family, playerID);
    }

    public BlackFamilyMember(String family) {

        super(0,"Black",family, 0);
    }

}

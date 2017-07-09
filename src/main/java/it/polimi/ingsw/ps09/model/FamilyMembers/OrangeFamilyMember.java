package it.polimi.ingsw.ps09.model.FamilyMembers;


/**
 * Simple orangeFamilyMember object
 */
public class OrangeFamilyMember extends FamilyMember {
    //initialized to 0
    public OrangeFamilyMember(String family, int playerID) {

        super(0,"Orange",family, playerID);
    }

    public OrangeFamilyMember(String family) {

        super(0,"Orange",family, 0);
    }
}

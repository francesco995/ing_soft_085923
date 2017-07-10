package it.polimi.ingsw.ps09.model.FamilyMembers;

/**
 * Simple whiteFamilyMember object
 */
public class WhiteFamilyMember extends FamilyMember {
    //initialized to 0
    public WhiteFamilyMember(String family, int playerId) {

        super(0,"White",family, playerId);
    }

    public WhiteFamilyMember(String family) {

        super(0,"White",family, 0);
    }

}

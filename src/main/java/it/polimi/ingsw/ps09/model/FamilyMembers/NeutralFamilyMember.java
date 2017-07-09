package it.polimi.ingsw.ps09.model.FamilyMembers;

/**
 * Simple neutralFamilyMember object
 */
public class NeutralFamilyMember extends FamilyMember{

    //initialized to 0
    public NeutralFamilyMember(String family, int playerId) {

        super(0,"Neutral",family, playerId);
    }

    public NeutralFamilyMember(String family) {

        super(0,"Neutral",family, 0);
    }
}

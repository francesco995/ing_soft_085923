package it.polimi.ingsw.ps09.model.FamilyMembers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by francesco995 on 10/06/2017.
 */
public class PlayerFamilyMembers {

    private Map<String, FamilyMember> mPlayerFamilyMembers = new HashMap<String, FamilyMember>();


    public PlayerFamilyMembers() {

        //TODO: ask ale about family attribute
        mPlayerFamilyMembers.put("BLACK", new BlackFamilyMember("FAMILY"));
        mPlayerFamilyMembers.put("ORANGE",new OrangeFamilyMember(("FAMILY")));
        mPlayerFamilyMembers.put("WHITE", new WhiteFamilyMember("FAMILY"));
        mPlayerFamilyMembers.put("NEUTRAL", new NeutralFamilyMember("FAMILY"));

    }
}

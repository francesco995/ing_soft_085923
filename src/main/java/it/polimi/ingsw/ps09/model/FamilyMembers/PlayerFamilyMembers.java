package it.polimi.ingsw.ps09.model.FamilyMembers;

import it.polimi.ingsw.ps09.model.Dices.Dice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by francesco995 on 10/06/2017.
 * It creates all necessary familyMembers for a single player as an HashMap<String, FamilyMember>
 *
 */
public class PlayerFamilyMembers {

    private Map<String, FamilyMember> mPlayerFamilyMembers = new HashMap<String, FamilyMember>();


    public PlayerFamilyMembers(String playerColor, int playerID) {

        mPlayerFamilyMembers.put("BLACK", new BlackFamilyMember(playerColor, playerID));
        mPlayerFamilyMembers.put("ORANGE",new OrangeFamilyMember(playerColor, playerID));
        mPlayerFamilyMembers.put("WHITE", new WhiteFamilyMember(playerColor, playerID));
        mPlayerFamilyMembers.put("NEUTRAL", new NeutralFamilyMember(playerColor, playerID));

    }

    public PlayerFamilyMembers(String playerColor) {

        mPlayerFamilyMembers.put("BLACK", new BlackFamilyMember(playerColor));
        mPlayerFamilyMembers.put("ORANGE",new OrangeFamilyMember(playerColor));
        mPlayerFamilyMembers.put("WHITE", new WhiteFamilyMember(playerColor));
        mPlayerFamilyMembers.put("NEUTRAL", new NeutralFamilyMember(playerColor));

    }

    public FamilyMember getFamilyMember(String color){
        return mPlayerFamilyMembers.get(color.toUpperCase());
    }

    //TODO: check with FRAG if it controls if color same
    public void setFamilyMemberPower(String color, Dice powerDice){
        mPlayerFamilyMembers.get(color).setPower(powerDice);
    }
}

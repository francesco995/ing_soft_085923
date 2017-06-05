package it.polimi.ingsw.ps09.model.Bonus;

import it.polimi.ingsw.ps09.model.Resources.Resource;
import it.polimi.ingsw.ps09.model.UserResources;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by francesco995 on 04/06/2017.
 */
public class FamilyMemberPlacementResourcesDiscount {

    private Map<String, UserResources> mBonus = new HashMap<String, UserResources>(){{
        put("BUILDING", new UserResources());
        put("CHARACTER", new UserResources());
        put("TERRITORY", new UserResources());
        put("VENTURE", new UserResources());
    }};


    public UserResources getBonus(String cardType){
        return mBonus.get(cardType.toUpperCase());
    }


    public void addBonus(String cardType, UserResources addBonus){

        UserResources tempBonus = mBonus.get(cardType.toUpperCase());
        tempBonus.add(addBonus);

        mBonus.put(
                cardType.toUpperCase(), tempBonus );
    }

    //TODO: test




}

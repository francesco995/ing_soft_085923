package it.polimi.ingsw.ps09.model.Bonus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by franc on 13/06/2017.
 */
public class BonusFlags {
    private Map<String,Boolean> mFlags= new HashMap<String, Boolean>();

    public void putBonus(String bonus)
    {
        mFlags.put(bonus, false) ;
    }


    public boolean getBonus(String bonusName) {
        if(!mFlags.containsKey(bonusName)){
            return true;
        }
        else
            return mFlags.get(bonusName).booleanValue();
    }
}

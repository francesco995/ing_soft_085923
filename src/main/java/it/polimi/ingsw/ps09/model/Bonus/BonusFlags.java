package it.polimi.ingsw.ps09.model.Bonus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by franc on 13/06/2017.
 * List of all the booleans flag that a player can have, its initially empty then is gradually filled
 * with various flags set to false so that the game can check for them before some special actions
 */
public class BonusFlags {
    private HashMap<String,Boolean> mFlags= new HashMap<String, Boolean>();

    public void putBonus(String bonus)
    {
        mFlags.put(bonus, true) ;
    }
    public void putMalus(String malus)
    {
        mFlags.put(malus, true) ;
    }
    /**
     *
     * @param bonusName the bonus that must be searched in the bonus flags map
     * @return true if not present, else returns the value of the flag (usually false)
     */
    public boolean getBonus(String bonusName) {
        if(!mFlags.containsKey(bonusName)){
            return false;
        }
        else
            return mFlags.get(bonusName).booleanValue();
    }
    public boolean getMalus(String malusName){
        if(!mFlags.containsKey(malusName)){
            return false;
        }
        else
            return mFlags.get(malusName).booleanValue();
    }
}

package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.Resources.Coins;
import it.polimi.ingsw.ps09.model.Resources.Servant;
import it.polimi.ingsw.ps09.model.Resources.Stone;
import it.polimi.ingsw.ps09.model.Resources.Wood;

/**
 * Created by francGianni on 12/05/2017.
 */
public class UserResources {

    //VARIABLES

    private Coins mCoins;
    private Servant mServant;
    private Stone mStone;
    private Wood mWood;

    public UserResources(Coins initialCoins,
                         Servant initialServant,
                         Stone initialStone,
                         Wood initialWood){
        mCoins = initialCoins;
        mServant = initialServant;
        mStone = initialStone;
        mWood = initialWood;
    }

    public UserResources(){
        this(0);
    }

    public UserResources(int initialCoins){
        this(initialCoins, 3, 2, 2);
    }

    public UserResources(int initialCoins, int initialServant, int initialStone, int initialWood){
        this(new Coins(initialCoins),
                new Servant(initialServant),
                new Stone(initialStone),
                new Wood(initialWood));
    }


    //GETTERS

    public Coins getCoins() {
        return mCoins;
    }

    public Servant getServant() {
        return mServant;
    }

    public Stone getStone() {
        return mStone;
    }

    public Wood getWood() {
        return mWood;
    }

    //SETTERS

    public void setCoins(Coins coins) {
        mCoins = coins;
    }

    public void setServant(Servant servant) {
        mServant = servant;
    }

    public void setStone(Stone stone) {
        mStone = stone;
    }

    public void setWood(Wood wood) {
        mWood = wood;
    }

    //Add resources

    public void addCoins(Coins addCoins){
        mCoins.addValue(addCoins);
    }

    public void addServant(Servant addServant){
        mServant.addValue(addServant);
    }

    public void addStone(Stone addStone){
        mStone.addValue(addStone);
    }

    public void addWood(Wood addWood){
        mWood.addValue(addWood);
    }


}

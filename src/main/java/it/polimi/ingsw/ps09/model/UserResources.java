package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.Constants;
import it.polimi.ingsw.ps09.model.Resources.Coins;
import it.polimi.ingsw.ps09.model.Resources.Servant;
import it.polimi.ingsw.ps09.model.Resources.Stone;
import it.polimi.ingsw.ps09.model.Resources.Wood;

/**
 * Created by francGianni on 12/05/2017.
 */
public class UserResources {

    //CONSTANTS
    //private static final int INITIAL_SERVANT = 3;
    //private static final int INITIAL_STONE = 2;
    //private static final int INITIAL_WOOD = 2;

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
        this(initialCoins, Constants.INITIAL_SERVANT, Constants.INITIAL_STONE, Constants.INITIAL_WOOD);
    }

    public UserResources(int initialCoins, int initialServant, int initialStone, int initialWood){
        this(new Coins(initialCoins),
                new Servant(initialServant),
                new Stone(initialStone),
                new Wood(initialWood));
    }


    @Override
    public String toString(){

        String toString = "|";

        if(mCoins.isGreaterOrEqual(new Coins(1)))
            toString += " Coins: " + mCoins + " | ";

        if(mServant.isGreaterOrEqual(new Servant(1)))
            toString += " Servant: " + mServant + " | ";

        if(mStone.isGreaterOrEqual(new Stone(1)))
            toString += " Stone: " + mStone + " | ";

        if(mWood.isGreaterOrEqual(new Wood(1)))
            toString += " Wood: " + mWood + " | ";

        return toString;
    }

    public boolean isGreaterOrEqual(UserResources thanThis){
        return
                mCoins.isGreaterOrEqual(thanThis.getCoins()) ||
                mServant.isGreaterOrEqual(thanThis.getServant()) ||
                mStone.isGreaterOrEqual(thanThis.getStone()) ||
                mWood.isGreaterOrEqual(thanThis.getWood());
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

    //Add resources

    public void add(Coins addCoins){
        mCoins.add(addCoins);
    }

    public void add(Servant addServant){
        mServant.add(addServant);
    }

    public void add(Stone addStone){
        mStone.add(addStone);
    }

    public void add(Wood addWood){
        mWood.add(addWood);
    }

    public void add(UserResources userResources){
        add(userResources.getCoins());
        add(userResources.getServant());
        add(userResources.getStone());
        add(userResources.getWood());
    }


    //Remove resources

    public void remove(Coins removeCoins){
        mCoins.remove(removeCoins);
    }

    public void remove(Servant removeServant){
        mServant.remove(removeServant);
    }

    public void remove(Stone removeStone){
        mStone.remove(removeStone);
    }

    public void remove(Wood removeWood){
        mWood.remove(removeWood);
    }

    public void remove(UserResources userResources){
        remove(userResources.getCoins());
        remove(userResources.getServant());
        remove(userResources.getStone());
        remove(userResources.getWood());
    }


}

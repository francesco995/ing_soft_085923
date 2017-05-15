package it.polimi.ingsw.ps09.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ale on 14/05/2017.
 */
public class Order {

    private List<String> mOrderList = new ArrayList<>();

    //Set a player in a set position
    public void setPlayerNameInPos(String name, int pos){
        mOrderList.set(pos, name);
    }

    //Get the list of player's order
    public List getPlayerList(){
        return mOrderList;
    }

}

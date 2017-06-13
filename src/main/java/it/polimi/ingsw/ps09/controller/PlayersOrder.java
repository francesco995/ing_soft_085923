package it.polimi.ingsw.ps09.controller;

import java.util.*;

/**
 * Created by francesco995 on 18/05/2017.
 */
public class PlayersOrder {

    private List<Integer> mPlayersOrder = new LinkedList<>();

    //OTHER VARIABLES
    Random mRandom = new Random();

    public PlayersOrder(List<Integer> userIds){

        mPlayersOrder = new ArrayList<>(userIds);

    }

    public int getUserIdByIndex(int index){
        return mPlayersOrder.get(index);
    }



}

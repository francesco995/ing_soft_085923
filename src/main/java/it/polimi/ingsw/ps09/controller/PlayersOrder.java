package it.polimi.ingsw.ps09.controller;

import it.polimi.ingsw.ps09.view.Prompter;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by francesco995 on 18/05/2017.
 */
public class PlayersOrder{

    private ArrayList<Integer> mPlayersOrder;

    public PlayersOrder(ArrayList<Integer> userIds){

        mPlayersOrder = new ArrayList<>();

        userIds.stream().forEach(id -> mPlayersOrder.add(id));

    }

    private void updated() {
        //setChanged();
        //notifyObservers();
    }

    public int getUserIdByIndex(int index){
        return mPlayersOrder.get(index);
    }

    public List<Integer> getPlayersOrder(){
        return mPlayersOrder;
    }

    public void shufflePlayers(){
        long seed = System.nanoTime();
        Collections.shuffle(mPlayersOrder, new Random(seed));
    }

    public void rearrangePlayers(ArrayList<Integer> councilIds){

        Collections.reverse(councilIds);

        councilIds.stream().forEach(id -> {
            if(mPlayersOrder.contains(id)){

                mPlayersOrder.remove(id);
                mPlayersOrder.add(0, id);

            }
        });


    }




}

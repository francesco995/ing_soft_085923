package it.polimi.ingsw.ps09.controller;

import java.util.*;

/**
 * Created by francesco995 on 18/05/2017.
 */
public class PlayersOrder {

    private List<Integer> mPlayersOrder = new LinkedList<>();

    //OTHER VARIABLES
    Random mRandom = new Random();

    public PlayersOrder(Queue<Integer> userIds){

       for(int userId : userIds){
           mPlayersOrder.add(userId);
       }

    }

    private int getRandomNumber(int max){
        return mRandom.nextInt(max);
    }

    public int getUserIdByIndex(int index){
        return mPlayersOrder.get(index);
    }

    //TODO: FraG aggiungere metodo per cambiare l'ordine dei giocatori

}

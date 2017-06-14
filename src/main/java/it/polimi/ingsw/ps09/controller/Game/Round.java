package it.polimi.ingsw.ps09.controller.Game;

/**
 * Created by francesco995 on 14/06/2017.
 */
public class Round {

    private Round(){
        //NO INSTANCE
    }

    protected static void startRound(Game game){

        RoundSetup.setupRound(game);

    }


}

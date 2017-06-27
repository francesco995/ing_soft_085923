package it.polimi.ingsw.ps09.controller.Game;

import it.polimi.ingsw.ps09.model.LeaderCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by walle on 26/06/17.
 */
public class LeaderCardsExchange {

    //TODO: shuffle leader cards before draw

    public static void startExchange(Game game) {

        LeaderCardsOrder mLeaderCardsOrder;
        ArrayList<LeaderCardsOrder> mLeaderCardsOrderList = new ArrayList<>();

        //Initialize and draw LeaderCard for each player.
        for (int cont = 0; cont < game.PLAYERS_NUMBER; cont++) {
            ArrayList<LeaderCard> mLeaderCardsList = new ArrayList<LeaderCard>();
            mLeaderCardsList = game.mLeaderCardsDeck.cardDraw();

            mLeaderCardsOrder = new LeaderCardsOrder(cont, game.mPlayersOrder.getPlayersOrder().get(cont), mLeaderCardsList);
            mLeaderCardsOrderList.add(mLeaderCardsOrder);
        }

        //Loop until there are no more leader cards to exchange
        while((mLeaderCardsOrderList.get(0).getLeaderCardList().size())!=0) {
            mLeaderCardsOrderList = chooseLeaderCard(game, mLeaderCardsOrderList);
            mLeaderCardsOrderList = leaderCardListExchange(mLeaderCardsOrderList);
        }
    }

    //Each player choose a leader card
    private static ArrayList<LeaderCardsOrder> chooseLeaderCard(Game game, ArrayList<LeaderCardsOrder> LeaderCardsOrderList){

        int choice = 0;

        //LOOP USED TO GET CHOOSE
        for (int cont = 0; cont < game.PLAYERS_NUMBER; cont++) {

            //Retrieve choice

            game.mConnections.get(LeaderCardsOrderList.get(cont).getPlayerID()).sendLeaderCardsList((ArrayList)LeaderCardsOrderList.get(cont).getLeaderCardList());
            choice = Integer.valueOf(game.mConnections.get(LeaderCardsOrderList.get(cont).getPlayerID()).getMessage());

            //Add chosen LeaderCard to player's LeaderCard permanent list
            game.mPlayers.get(LeaderCardsOrderList.get(cont).getPlayerID()).add(LeaderCardsOrderList.get(cont).getLeaderCardList().get(choice - 1));

            //Remove chosen leader card form temporary leader card list
            LeaderCardsOrderList.get(cont).getLeaderCardList().remove(choice);
        }


        return LeaderCardsOrderList;

    }


    //Exchange leader card between player
    private static ArrayList<LeaderCardsOrder> leaderCardListExchange(ArrayList<LeaderCardsOrder> LeaderCardsOrderList){

        //LOOP TO START A NEW CHOICE LOOP
        int mTemporaryLastPlayerID = 0;

        //Get the last playerID of mLeaderCardsOrderList
        mTemporaryLastPlayerID = LeaderCardsOrderList.get(LeaderCardsOrderList.size()-1).getPlayerID();

        //Loop through mLeaderCardsOrderList IN INVERSE ORDER to switch PlayerID.
        //It's a easy way to exchange LeaderCards without passing the entire lits.
        for(int cont=(LeaderCardsOrderList.size()-1); cont==0; cont--) {

            if(cont!=0)
                LeaderCardsOrderList.get(cont-1).setPlayerID(LeaderCardsOrderList.get(cont).getPlayerID());

            else if(cont==0)
                LeaderCardsOrderList.get(cont).setPlayerID(mTemporaryLastPlayerID);
        }


        return LeaderCardsOrderList;

    }



}

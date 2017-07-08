package it.polimi.ingsw.ps09.controller.Game;

import it.polimi.ingsw.ps09.model.LeaderCard;

import java.util.ArrayList;

/**
 * Created by walle on 26/06/17.
 */
public abstract class LeaderCardsExchange {


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
        while((mLeaderCardsOrderList.get(0).getLeaderCardList().size())>0) {
            chooseLeaderCard(game, mLeaderCardsOrderList);
            leaderCardListExchange(mLeaderCardsOrderList);
        }
    }

    //Each player choose a leader card
    private static void chooseLeaderCard(Game game, ArrayList<LeaderCardsOrder> LeaderCardsOrderList){

        int choice;
        int cont;

        //LOOP USED TO GET CHOOSE
        for (cont=0; cont < game.PLAYERS_NUMBER; cont++) {

            //Retrieve choice

            game.mConnections.get(LeaderCardsOrderList.get(cont).getPlayerID()).sendLeaderCardsList((ArrayList)LeaderCardsOrderList.get(cont).getLeaderCardList());

            choice = game.mConnections.get(LeaderCardsOrderList.get(cont).getPlayerID()).getLeaderCardChoice();

            choice--;
            //Add chosen LeaderCard to player's LeaderCard permanent list
            game.mPlayers.get(LeaderCardsOrderList.get(cont).getPlayerID()).add(LeaderCardsOrderList.get(cont).getLeaderCardList().get(choice));

            //Remove chosen leader card from temporary leader card list
            LeaderCardsOrderList.get(cont).getLeaderCardList().remove(choice);
        }

    }


    //Exchange leader card between player
    private static void leaderCardListExchange(ArrayList<LeaderCardsOrder> LeaderCardsOrderList){

        //LOOP TO START A NEW CHOICE LOOP
        ArrayList<LeaderCard> mTemporaryFirstLeaderCardList;
        int mListSize = LeaderCardsOrderList.size();


        //Get the first playerID of mLeaderCardsOrderList
        mTemporaryFirstLeaderCardList = (ArrayList)LeaderCardsOrderList.get(0).getLeaderCardList();

        //Loop through mLeaderCardsOrderList IN INVERSE ORDER to switch LeaderCardsList.
        for(int cont=0; cont<=(mListSize-1); cont++) {


            if(cont==(mListSize-1)){
                LeaderCardsOrderList.get(cont).setLeaderCardList(mTemporaryFirstLeaderCardList);
            }

            else {
                LeaderCardsOrderList.get(cont).setLeaderCardList((ArrayList<LeaderCard>) LeaderCardsOrderList.get(cont+1).getLeaderCardList());

            }

        }

    }

}

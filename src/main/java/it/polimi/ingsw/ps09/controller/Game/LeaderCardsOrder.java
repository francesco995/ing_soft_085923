package it.polimi.ingsw.ps09.controller.Game;

import it.polimi.ingsw.ps09.model.LeaderCard;

import java.util.List;
import java.util.StringJoiner;

/**
 * Created by walle on 27/06/17.
 */
public class LeaderCardsOrder {

    private int mOrder;
    private int mPlayerID;
    private List<LeaderCard> mLeaderCardList;

    public LeaderCardsOrder(int order, int playerID, List<LeaderCard> leaderCardList) {
        mOrder = order;
        mPlayerID = playerID;
        mLeaderCardList = leaderCardList;
    }

    public int getOrder() {
        return mOrder;
    }

    public int getPlayerID() {
        return mPlayerID;
    }

    public List<LeaderCard> getLeaderCardList() {
        return mLeaderCardList;
    }

    public void setOrder(int order) {
        mOrder = order;
    }

    public void setPlayerID(int playerID) {
        mPlayerID = playerID;
    }

    public void setLeaderCardList(List<LeaderCard> leaderCardList) {
        mLeaderCardList = leaderCardList;
    }

    @Override
    public String toString(){

        StringJoiner mStringLeaderOrder = new StringJoiner("\n", "", "");

        mStringLeaderOrder.add("");
        mStringLeaderOrder.add("Player order: " + mOrder);
        mStringLeaderOrder.add("PlayrID: " + mPlayerID);
        mStringLeaderOrder.add("LeaderCardList: " + mLeaderCardList.toString());

        return mStringLeaderOrder.toString();
    }
}

package it.polimi.ingsw.ps09.controller.Network.Server.PlayerConnections;

import it.polimi.ingsw.ps09.controller.PlayersOrder;
import it.polimi.ingsw.ps09.model.Actions.FamilyMemberActions.FamilyMemberAction;
import it.polimi.ingsw.ps09.model.Actions.PlacementActions.PlacementAction;
import it.polimi.ingsw.ps09.model.Actions.PlayerActions.PlayerAction;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.LeaderCard;
import it.polimi.ingsw.ps09.model.Player;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by francesco995 on 15/06/2017.
 */
public interface PlayerConnection{

    String getUserName();
    void sendMessage(String message);
    void startGame();
    void setGameData(Board board, HashMap<Integer, Player> players, PlayersOrder playersOrder);
    void setUserID(int userID);
    void sendUpdatedData();
    String getMessage();
    void sendPlacementActionsList(ArrayList<PlacementAction> playerActionsList);
    void sendFamilyMemberActionsList(ArrayList<FamilyMemberAction> familyMemberActionsList);
    void sendPlayerActionsList(ArrayList<PlayerAction> playerActionsList);
    void sendLeaderCardsList(ArrayList<LeaderCard> leaderCardsList);
    void waitActionReady();
    int getActionChoice();
    String getActionType();
    void resetActionReady();
    void waitLeaderCardChoiceReady();
    int getLeaderCardChoice();
    void run();
    void start();

}

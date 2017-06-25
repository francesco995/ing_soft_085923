package it.polimi.ingsw.ps09.controller.Network.Client.ServerConnections;

import it.polimi.ingsw.ps09.controller.PlayersOrder;
import it.polimi.ingsw.ps09.model.Actions.PlacementActions.PlacementAction;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by francesco995 on 15/06/2017.
 */
public interface ServerConnection{

    boolean hasAction();
    void setHasAction(boolean hasAction);
    boolean gameStarted();
    Board getBoard();
    HashMap<Integer, Player> getPlayers();
    PlayersOrder getPlayersOrder();
    String getUserName();
    String getMessage();
    ArrayList<PlacementAction> getPlayerActionsList();
    List<String> getAllMessages();
    boolean hasIncomingMessages();
    void sendMessage(String message);
    boolean isConnected();
    int getPort();
    String getAddress();
    void run();
    void start();


}

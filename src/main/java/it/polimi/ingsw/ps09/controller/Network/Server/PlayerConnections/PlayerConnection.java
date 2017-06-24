package it.polimi.ingsw.ps09.controller.Network.Server.PlayerConnections;

import it.polimi.ingsw.ps09.controller.PlayersOrder;
import it.polimi.ingsw.ps09.model.Actions.Action;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    int doAction(ArrayList<Action> playerActionsList);
    void run();
    void start();

}

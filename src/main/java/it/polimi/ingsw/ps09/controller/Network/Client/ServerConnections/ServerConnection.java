package it.polimi.ingsw.ps09.controller.Network.Client.ServerConnections;

import it.polimi.ingsw.ps09.controller.PlayersOrder;
import it.polimi.ingsw.ps09.model.Actions.FamilyMemberActions.FamilyMemberAction;
import it.polimi.ingsw.ps09.model.Actions.PlacementActions.PlacementAction;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.LeaderCard;
import it.polimi.ingsw.ps09.model.PersonalBonusTile;
import it.polimi.ingsw.ps09.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by francesco995 on 15/06/2017.
 */
public interface ServerConnection{

    boolean hasPlacementAction();
    boolean hasFamilyMemberAction();
    boolean hasPlayerActions();
    void setHasPlacementAction(boolean hasPlacementAction);
    void doPlacementAction(int actionIndex);
    boolean gameStarted();
    Board getBoard();
    HashMap<Integer, Player> getPlayers();
    PlayersOrder getPlayersOrder();
    String getUserName();
    String getMessage();
    boolean hasCouncilAction();
    void sendCouncilChoices(ArrayList<Integer> choices);
    int getCouncilChoices();
    boolean isGameEnded();
    ArrayList<PlacementAction> getPlacementActionsList();
    List<String> getAllMessages();
    ArrayList<FamilyMemberAction> getFamilyMemberActionsList();
    void doFamilyMemberAction(int actionIndex);
    boolean hasLeaderCardChoice();
    ArrayList<LeaderCard> getLeaderCardsChoiceList();
    boolean hasPersonalBonusTileChoice();
    void waitPersonalBoardBonusTileChoiceList();
    ArrayList<PersonalBonusTile> getPersonalBonusTilesList();
    void choosePersonalBoardBonusTile(int index);
    boolean canSupportVatican();
    void vaticanReportChoice(int choice);
    void waitLeaderCardsChoiceList();
    void chooseLeaderCard(int index);
    boolean hasIncomingMessages();
    void sendMessage(String message);
    boolean isConnected();
    int getPort();
    String getAddress();
    void run();
    void start();
    void close();
}

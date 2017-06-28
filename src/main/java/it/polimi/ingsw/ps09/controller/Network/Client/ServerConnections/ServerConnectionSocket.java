package it.polimi.ingsw.ps09.controller.Network.Client.ServerConnections;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.ps09.model.Actions.FamilyMemberActions.FamilyMemberAction;
import it.polimi.ingsw.ps09.model.Actions.PlacementActions.PlacementAction;
import it.polimi.ingsw.ps09.model.Actions.PlayerActions.PlayerAction;
import it.polimi.ingsw.ps09.view.CLIClientGame;
import it.polimi.ingsw.ps09.controller.Game.Game;
import it.polimi.ingsw.ps09.controller.PlayersOrder;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.DevelopmentCardEffect;
import it.polimi.ingsw.ps09.model.DevelopmentCards.DevelopmentCard;
import it.polimi.ingsw.ps09.model.ExcommunicationTileEffects.ExcommunicationTileEffect;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.GsonAdapters.*;
import it.polimi.ingsw.ps09.model.LeaderCardEffects.LeaderCardEffect;
import it.polimi.ingsw.ps09.model.Player;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.*;

/**
 * Created by francesco995 on 15/06/2017.
 * <p>
 * Thread instantiated by the user app to connect to the Server
 */
public class ServerConnectionSocket extends Thread implements ServerConnection {

    //Game
    private Board mBoard;

    //Map of Players by ID
    private HashMap<Integer, Player> mPlayers;

    //The Players Order manager
    private PlayersOrder mPlayersOrder;

    private boolean mHasPlacementAction;
    private ArrayList<PlacementAction> mPlacementActionsList;

    private boolean mHasFamilyMemberAction;
    private ArrayList<FamilyMemberAction> mFamilyMemberActionsList;

    private boolean mHasPlayerActions;
    private ArrayList<PlayerAction> mPlayerActionsList;

    private Socket mSocket;

    private InetAddress mSERVER_ADDRESS;
    private int mSERVER_PORT = 1024;

    private String mMessage;

    private BufferedReader mMessageReader;
    private BufferedWriter mMessageSender;

    private Queue<String> mIncomingMessages;

    private String mUserName;
    private int mPlayerId;

    private boolean mIsConnected = false;
    private boolean mGameStarted = false;

    Gson mGson = null;
    GsonBuilder mGsonBuilder;

    /**
     * Socket Connection from player client to the server
     * @param serverAddress Address of the Server to connect to
     * @param userName UserName of the Player connecting to the Server
     * @throws IOException
     */
    public ServerConnectionSocket(String serverAddress, String userName) throws IOException {

        mSERVER_ADDRESS = InetAddress.getByName(serverAddress);
        mUserName = userName;
        mIncomingMessages = new LinkedList<>();

        mPlayers = new HashMap<>();

        mHasPlacementAction = false;
        mHasFamilyMemberAction = false;
        mHasPlayerActions = false;

        //Create Gson Builder
        mGsonBuilder = new GsonBuilder();

        //Register adapters
        mGsonBuilder.registerTypeAdapter(DevelopmentCard.class, new DevelopmentCardAdapter());
        mGsonBuilder.registerTypeAdapter(DevelopmentCardEffect.class, new DevelopmentCardEffectAdapter());
        mGsonBuilder.registerTypeAdapter(ExcommunicationTileEffect.class, new ExcommunicationTileEffectAdapter());
        mGsonBuilder.registerTypeAdapter(PlacementAction.class, new ActionAdapter());
        mGsonBuilder.registerTypeAdapter(Game.class, new GameAdapter());
        mGsonBuilder.registerTypeAdapter(FamilyMember.class, new FamilyMemberAdapter());
        mGsonBuilder.registerTypeAdapter(LeaderCardEffect.class, new LeaderCardEffectAdapter());
        mGsonBuilder.registerTypeAdapter(FamilyMemberAction.class, new FamilyMemberActionAdapter());

        mGson = mGsonBuilder.create();

    }

    /**
     * Check if the Player associated with this connection has a Placement Action available to do
     * @return true if Player has PlacementAction(s) to do
     */
    public boolean hasPlacementAction() {
        return mHasPlacementAction;
    }

    /**
     * Check if the Player associated with this connection has a FamilyMember Action available to do
     * @return true if Player has FamilyMemberAction(s) to do
     */
    public boolean hasFamilyMemberAction() {
        return mHasFamilyMemberAction;
    }

    /**
     * Check if the Player associated with this connection has a Player Action available to do
     * @return true if Player has PlayerAction(s) to do
     */
    public boolean hasPlayerActions() {
        return mHasPlayerActions;
    }

    /**
     * Set HasAction parameter
     * @param hasPlacementAction
     */
    public void setHasPlacementAction(boolean hasPlacementAction){
        mHasPlacementAction = hasPlacementAction;
    }

    /**
     * Check if game is actually started
     * @return true if game has started, false otherwise
     */
    public boolean gameStarted(){
        return mGameStarted;
    }

    /**
     * Get latest version of Board
     * @return Board received from server after las change
     */
    public Board getBoard() {
        return mBoard;
    }

    /**
     * Get latest version of Players
     * @return Players received from server after las change
     */
    public HashMap<Integer, Player> getPlayers() {
        return mPlayers;
    }

    /**
     * Get latest version of PlayersOrder
     * @return PlayersOrder received from server after las change
     */
    public PlayersOrder getPlayersOrder() {
        return mPlayersOrder;
    }


    /**
     * Get the UserName of the player associated with this connection
     * @return UserName string
     */
    public String getUserName() {
        return mUserName;
    }

    /**
     * Get first message received
     * @return First message on the received messages Queue
     */
    public String getMessage() {

        while (!hasIncomingMessages()) {
            sleep(50);
        }
        return mIncomingMessages.poll();
    }

    /**
     * Get updated PlacementActions list for player
     * @return List of valid PlacementActions for player
     */
    public ArrayList<PlacementAction> getPlacementActionsList() {
        return mPlacementActionsList;
    }

    /**
     * Get updated PlacementActions list for player
     * @return List of valid PlacementActions for player
     */
    public ArrayList<FamilyMemberAction> getFamilyMemberActionsList() {
        return mFamilyMemberActionsList;
    }




    /**
     * Get all incoming messages not yet ridden
     * @return List of received messages
     */
    public List<String> getAllMessages() {
        List<String> messages = new LinkedList<>();

        while (!mIncomingMessages.isEmpty()) {
            messages.add(mIncomingMessages.poll());
        }

        return messages;
    }


    /**
     * Check if connection has incoming messages
     * @return Returns true if has new messages, false otherwise
     */
    public boolean hasIncomingMessages() {

        if (!mIncomingMessages.isEmpty())
            return true;

        return false;
    }


    /**
     * Sends a message via the socket output stream
     * @param message Message to send
     */
    public void sendMessage(String message) {
        //TODO: maybe switch to boolean return
        try {
            mMessageSender.write(message);
            mMessageSender.write("\n");
            mMessageSender.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * Wait for a message, and deserialize updated Players
     * it expects as many messages as there are players in PlayersOrder
     */
    private void updatePlayers() {

        mPlayersOrder.getPlayersOrder().stream().forEach(
                id -> mPlayers.put(id, mGson.fromJson(waitForMessage(), Player.class)));

    }

    /**
     * Wait for a message, and deserialize Placement Actions
     * first message is the number of actions to deserialize, next X messages are the serialized actions
     */
    private void updatePlacementActions() {

        mPlacementActionsList = new ArrayList<>();
        int actionsN = Integer.valueOf(waitForMessage());

        for (int i = 0; i < actionsN; i++)
            mPlacementActionsList.add(mGson.fromJson(waitForMessage(), PlacementAction.class));

        CLIClientGame.alertActions();

    }

    /**
     * Wait for a message, and deserialize FamilyMember Actions
     * first message is the number of actions to deserialize, next X messages are the serialized actions
     */
    private void updateFamilyMemberActions() {

        mFamilyMemberActionsList = new ArrayList<>();
        int actionsN = Integer.valueOf(waitForMessage());

        for (int i = 0; i < actionsN; i++)
            mFamilyMemberActionsList.add(mGson.fromJson(waitForMessage(), FamilyMemberAction.class));

        //CLIClientGame.alertActions(); TODO: alert for different actions

    }

    /**
     * Wait for a message, and deserialize Player Actions
     * first message is the number of actions to deserialize, next X messages are the serialized actions
     */
    private void updatePlayerActions() {

        mPlayerActionsList = new ArrayList<>();
        int actionsN = Integer.valueOf(waitForMessage());

        for (int i = 0; i < actionsN; i++)
            mPlayerActionsList.add(mGson.fromJson(waitForMessage(), PlayerAction.class));

        //CLIClientGame.alertActions(); TODO: alert for different actions

    }

    /**
     * Wait for a message, and deserialize updated PlayersOrder
     */
    private void updatePlayersOrder() {

        mPlayersOrder = mGson.fromJson(waitForMessage(), PlayersOrder.class);

    }

    /**
     * Wait for a message, and deserialize updated Board
     */
    private void updateBoard() {

        mBoard = mGson.fromJson(waitForMessage(), Board.class);

    }


    public void doPlacementAction(int actionIndex){

        sendMessage("doPlacementAction");

        sendMessage(String.valueOf(actionIndex));
    }

    public void doFamilyMemberAction(int actionIndex){

        sendMessage("doFamilyMemberAction");

        sendMessage(String.valueOf(actionIndex));
    }


    /**
     * Sleep for x seconds unless Interrupted
     * @param mS milliseconds to sleep for
     */
    private void sleep(int mS) {

        try {
            Thread.sleep(mS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    /**
     * Check if socket is connected
     * @return true if connected, false if not
     */
    public boolean isConnected() {
        return mIsConnected;
    }

    /**
     * Return the port the socket is connected to
     * @return Port as int
     */
    public int getPort() {
        return mSocket.getPort();
    }

    /**
     * Return the address the socket is connected to
     * @return Address as string
     */
    public String getAddress() {
        return mSocket.getInetAddress().toString();
    }


    /**
     * Wait until input socket has a message, then return the message
     * @return The received message
     */
    private synchronized String waitForMessage() {

        String message;

        waitForSocketReady();

        try {

            message = mMessageReader.readLine();
            //sendMessage("ok");

        } catch (IOException e) {
            e.printStackTrace();
            message = "";
        }


        return message;
    }

    /**
     * Wait for input socket to be ready with a complete message
     */
    private void waitForSocketReady() {
        try {
            while (!mMessageReader.ready())
                sleep(50);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        try {

            //Connects to Server
            mSocket = new Socket(mSERVER_ADDRESS, mSERVER_PORT);

            //Incoming and Outgoing Messages
            mMessageSender = new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream()));
            mMessageReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));

            //Request connection to server
            mMessageSender.write(mUserName + "\n");
            mMessageSender.flush();

            if (mSocket.isConnected())
                mIsConnected = true;

            for(int i = 0; i < 3; i++) {
                switch (waitForMessage()) {
                    case "board": {
                        updateBoard();
                        break;
                    }

                    case "players": {
                        updatePlayers();
                        break;
                    }

                    case "order": {
                        updatePlayersOrder();
                        break;
                    }
                }
            }

            //When game start, the server will send a message to all players with their id to notify game has started
            mPlayerId = Integer.valueOf(waitForMessage());

            mGameStarted = true;


            do {

                //Wait for incoming messages
                mMessage = waitForMessage();
                //Check if message is a known command

                switch (mMessage) {

                    case "board": {
                        updateBoard();
                        break;
                    }

                    case "players": {
                        updatePlayers();
                        break;
                    }

                    case "order": {
                        updatePlayersOrder();
                        break;
                    }

                    case "placementActions": {
                        updatePlacementActions();
                        mHasPlacementAction = true;
                        break;
                    }

                    case "familyMemberActions": {
                        updateFamilyMemberActions();
                        mHasFamilyMemberAction = true;
                        break;
                    }

                    case "playerActions": {
                        updatePlayerActions();
                        mHasPlayerActions = true;
                        break;
                    }

                    case "noAction": {
                        mHasPlacementAction = false;
                        mHasPlayerActions = false;
                        mHasFamilyMemberAction = false;
                        break;
                    }

                    case "close": {
                        mSocket.close();
                        break;
                    }

                    default: {
                        //Add new messages to IncomingMessages
                        mIncomingMessages.add(mMessage);
                        break;
                    }
                }


            } while (!mMessage.equalsIgnoreCase("close"));

            //Close connection
            mSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

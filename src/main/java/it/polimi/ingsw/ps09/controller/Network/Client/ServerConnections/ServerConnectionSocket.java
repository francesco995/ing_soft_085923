package it.polimi.ingsw.ps09.controller.Network.Client.ServerConnections;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.ps09.view.CLIClientGame;
import it.polimi.ingsw.ps09.controller.Game.Game;
import it.polimi.ingsw.ps09.controller.PlayersOrder;
import it.polimi.ingsw.ps09.model.Actions.Action;
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

    private boolean mHasAction;
    private ArrayList<Action> mPlayerActionsList;

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

    public ServerConnectionSocket(String serverAddress, String userName) throws IOException {

        mSERVER_ADDRESS = InetAddress.getByName(serverAddress);
        mUserName = userName;
        mIncomingMessages = new LinkedList<>();

        mPlayers = new HashMap<>();

        mHasAction = false;

        //Create Gson Builder
        mGsonBuilder = new GsonBuilder();

        //Register adapters
        mGsonBuilder.registerTypeAdapter(DevelopmentCard.class, new DevelopmentCardAdapter());
        mGsonBuilder.registerTypeAdapter(DevelopmentCardEffect.class, new DevelopmentCardEffectAdapter());
        mGsonBuilder.registerTypeAdapter(ExcommunicationTileEffect.class, new ExcommunicationTileEffectAdapter());
        mGsonBuilder.registerTypeAdapter(Action.class, new ActionAdapter());
        mGsonBuilder.registerTypeAdapter(Game.class, new GameAdapter());
        mGsonBuilder.registerTypeAdapter(FamilyMember.class, new FamilyMemberAdapter());
        mGsonBuilder.registerTypeAdapter(LeaderCardEffect.class, new LeaderCardEffectAdapter());

        mGson = mGsonBuilder.create();

    }

    public boolean hasAction() {
        return mHasAction;
    }

    public void setHasAction(boolean hasAction){
        mHasAction = hasAction;
    }

    public boolean gameStarted(){
        return mGameStarted;
    }

    public Board getBoard() {
        return mBoard;
    }

    public HashMap<Integer, Player> getPlayers() {
        return mPlayers;
    }

    public PlayersOrder getPlayersOrder() {
        return mPlayersOrder;
    }

    public String getUserName() {
        return mUserName;
    }

    public String getMessage() {

        while (!hasIncomingMessages()) {
            sleep(50);
        }
        return mIncomingMessages.poll();
    }

    public ArrayList<Action> getPlayerActionsList() {
        return mPlayerActionsList;
    }

    public List<String> getAllMessages() {
        List<String> messages = new LinkedList<>();

        while (!mIncomingMessages.isEmpty()) {
            messages.add(mIncomingMessages.poll());
        }

        return messages;
    }


    public boolean hasIncomingMessages() {

        if (!mIncomingMessages.isEmpty())
            return true;

        return false;
    }


    public void sendMessage(String message) {
        //TODO: maybe switch to boolean return
        try {
            mMessageSender.write(message);
            mMessageSender.write("\n");
            mMessageSender.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(message);

    }

    /**
     * Send the server requests to get updated data
     */
    public void updateData() {



    }

    private void updatePlayers() {

        mPlayersOrder.getPlayersOrder().stream().forEach(
                id -> mPlayers.put(id, mGson.fromJson(waitForMessage(), Player.class)));

    }

    private void updateActions() {

        mPlayerActionsList = new ArrayList<>();
        int actionsN = Integer.valueOf(waitForMessage());

        for (int i = 0; i < actionsN; i++)
            mPlayerActionsList.add(mGson.fromJson(waitForMessage(), Action.class));

        CLIClientGame.alertActions();

    }

    private void updatePlayersOrder() {

        mPlayersOrder = mGson.fromJson(waitForMessage(), PlayersOrder.class);

    }

    private void updateBoard() {

        mBoard = mGson.fromJson(waitForMessage(), Board.class);

    }

    private void sleep(int mS) {

        try {
            Thread.sleep(mS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public boolean isConnected() {
        return mIsConnected;
    }

    public int getPort() {
        return mSocket.getPort();
    }

    public String getAddress() {
        return mSocket.getInetAddress().toString();
    }


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
            mMessageSender.write("connect\n");
            mMessageSender.flush();

            //Wait for Server response with a new free port
            mSERVER_PORT = Integer.parseInt(mMessageReader.readLine());

            //Close old connection
            mSocket.close();

            //Sleep 5 seconds to let the server create new socket
            sleep(5000);

            //Start connection to new Port
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

                    case "actions": {
                        updateActions();
                        mHasAction = true;
                        break;
                    }

                    case "noAction": {
                        mHasAction = false;
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

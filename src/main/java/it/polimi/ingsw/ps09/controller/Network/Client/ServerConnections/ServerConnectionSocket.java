package it.polimi.ingsw.ps09.controller.Network.Client.ServerConnections;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.polimi.ingsw.ps09.controller.Game.Game;
import it.polimi.ingsw.ps09.controller.PlayersOrder;
import it.polimi.ingsw.ps09.model.Actions.Action;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.DevelopmentCardEffect;
import it.polimi.ingsw.ps09.model.DevelopmentCards.DevelopmentCard;
import it.polimi.ingsw.ps09.model.ExcommunicationTileEffects.ExcommunicationTileEffect;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.GsonAdapters.*;
import it.polimi.ingsw.ps09.model.Player;

import java.io.*;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.Socket;
import java.util.*;

/**
 * Created by francesco995 on 15/06/2017.
 *
 * Thread instantiated by the user app to connect to the Server
 */
public class ServerConnectionSocket extends Thread implements ServerConnection {

    //Game
    private Board mBoard;

    //Map of Players by ID
    private HashMap<Integer, Player> mPlayers;

    //The Players Order manager
    private PlayersOrder mPlayersOrder;

    private Socket mSocket;

    private InetAddress mSERVER_ADDRESS;
    private int mSERVER_PORT = 100;

    private String mMessage;

    private BufferedReader mMessageReader;
    private BufferedWriter mMessageSender;

    private Queue<String> mIncomingMessages;

    private String mUserName;

    private boolean mIsConnected = false;

    Gson mGson = null;
    GsonBuilder mGsonBuilder;

    public ServerConnectionSocket(String serverAddress, String userName) throws IOException {

        mSERVER_ADDRESS = InetAddress.getByName(serverAddress);
        mUserName = userName;
        mIncomingMessages = new LinkedList<>();

        mPlayers = new HashMap<>();

        //Create Gson Builder
        mGsonBuilder = new GsonBuilder();

        //Register adapters
        mGsonBuilder.registerTypeAdapter(DevelopmentCard.class, new DevelopmentCardAdapter());
        mGsonBuilder.registerTypeAdapter(DevelopmentCardEffect.class, new DevelopmentCardEffectAdapter());
        mGsonBuilder.registerTypeAdapter(ExcommunicationTileEffect.class, new ExcommunicationTileEffectAdapter());
        mGsonBuilder.registerTypeAdapter(Action.class, new ActionAdapter());
        mGsonBuilder.registerTypeAdapter(Game.class, new GameAdapter());
        mGsonBuilder.registerTypeAdapter(FamilyMember.class, new FamilyMemberAdapter());

        mGson = mGsonBuilder.create();

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

    public void updateView(){

        sendMessage("board");
        mBoard = mGson.fromJson(getMessage(), Board.class);

        sendMessage("playersOrder");

        mPlayersOrder = mGson.fromJson(getMessage(), PlayersOrder.class);

        sendMessage("players");

        mPlayersOrder.getPlayersOrder().stream().forEach(
                id -> mPlayers.put(id, mGson.fromJson(getMessage(), Player.class)));

    }

    public String getUserName() {
        return mUserName;
    }


    public String getMessage(){

        while(!hasIncomingMessages()){
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return mIncomingMessages.poll();
    }


    public List<String> getAllMessages(){
        List<String> messages = new LinkedList<>();

        while (!mIncomingMessages.isEmpty()){
            messages.add(mIncomingMessages.poll());
        }

        return messages;
    }


    public boolean hasIncomingMessages(){

        if(!mIncomingMessages.isEmpty())
            return true;

        return false;
    }

    public void sendMessage(String message){
    //TODO: maybe switch to boolean return

        try {
            mMessageSender.write(message);
            mMessageSender.write("\n");
            mMessageSender.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public boolean isConnected(){
        return mIsConnected;
    }

    public int getPort(){
        return mSocket.getPort();
    }

    public String getAddress(){
        return mSocket.getInetAddress().toString();
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
            Thread.sleep(5000);

            //Start connection to new Port
            mSocket = new Socket(mSERVER_ADDRESS, mSERVER_PORT);

            //Incoming and Outgoing Messages
            mMessageSender = new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream()));
            mMessageReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));

            //Request connection to server
            mMessageSender.write(mUserName + "\n");
            mMessageSender.flush();

            if(mSocket.isConnected())
                mIsConnected = true;

            do {

                //Wait for incoming messages
                mMessage = mMessageReader.readLine();


                if(mMessage.equals("update")){
                    updateView();
                }
                else{
                    //Add new messages to IncomingMessages
                    mIncomingMessages.add(mMessage);
                }

            }while(!mMessage.equalsIgnoreCase("close"));

            mSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

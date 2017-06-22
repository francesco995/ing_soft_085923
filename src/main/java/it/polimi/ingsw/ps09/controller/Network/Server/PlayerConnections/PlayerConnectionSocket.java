package it.polimi.ingsw.ps09.controller.Network.Server.PlayerConnections;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;


/**
 * Created by francesco995 on 15/06/2017.
 *
 * Thread instantiated by the Server app to connect to a Player
 */
public class PlayerConnectionSocket extends Thread implements PlayerConnection, Observer{

    //LOGGER
    private static final Logger mLogger = Logger.getAnonymousLogger();

    //Game
    private Board mBoard;

    //Map of Players by ID
    private HashMap<Integer, Player> mPlayers;

    //The Players Order manager
    private PlayersOrder mPlayersOrder;

    //A ServerSocket listening and a Socket to answer
    private ServerSocket mLocalSocket;
    private Socket mRemoteSocket;

    private BufferedReader mMessageReader;
    private BufferedWriter mMessageSender;

    private String mMessage;

    private Queue<String> mIncomingMessages;

    private String mUserName;

    private int mUserID;

    Gson mGson = null;
    GsonBuilder mGsonBuilder;






    public PlayerConnectionSocket(int port) throws IOException {

        //Start ServerSocket on port 100
        mLocalSocket = new ServerSocket(port);


        mIncomingMessages = new LinkedList<>();

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

        //Create Gson
        mGson = mGsonBuilder.create();

        this.start();

    }

    @Override
    public void update(Observable o, Object arg){

       /* if(o instanceof  Board)
            sendMessage("board");

        if(o instanceof Player)
            sendMessage("player");

        if(o instanceof PlayersOrder)
            sendMessage("order");*/

    }

    private void sleep(int mS){

        try {
            Thread.sleep(mS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public synchronized void sendUpdatedData(){
        sendBoard();
        sendPlayersOrder();
        sendPlayers();
    }


    private void sendBoard(){
        mLogger.log(INFO, "Game: " + Game.GAME_ID + " sending Board to user " + mUserID);
        sendMessage("board");
        sendMessage(mGson.toJson(mBoard, Board.class));
    }

    private void sendPlayersOrder(){
        mLogger.log(INFO, "Game: " + Game.GAME_ID + " sending Players Order to user " + mUserID);
        sendMessage("order");
        sendMessage(mGson.toJson(mPlayersOrder, PlayersOrder.class));
    }

    private void sendPlayers(){
        mLogger.log(INFO, "Game: " + Game.GAME_ID + " sending Players to user " + mUserID);
        sendMessage("players");
        mPlayersOrder.getPlayersOrder().stream().forEach(
                id -> sendMessage(mGson.toJson(mPlayers.get(id), Player.class))
        );
    }

    public void sendActions(ArrayList<Action> playerActionsList){
        mLogger.log(INFO, "Game: " + Game.GAME_ID + " sending Actions list to user " + mUserID);
        sendMessage("actions");
        sendMessage(String.valueOf(playerActionsList.size()));
        playerActionsList.stream().forEach(a -> {
            sendMessage(mGson.toJson(a, Action.class));
        });
    }

    public String getMessage(){

        while(!hasIncomingMessages()){
        }
        return mIncomingMessages.poll();
    }

    @Override
    public String getUserName(){
        return mUserName;
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

    public void setGameData(Board board, HashMap<Integer, Player> players, PlayersOrder playersOrder){
        mBoard = board;
        mPlayers = players;
        mPlayersOrder = playersOrder;

    }

    public void startGame(){
        sendUpdatedData();
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


        //String confirm = waitForMessage();

    }

    public void setUserID(int userID) {
        mUserID = userID;
    }

    private String waitForMessage() {
        String message;

        waitForInputSocketReady();

        try {
            waitForInputSocketReady();
            message = mMessageReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            message = "";
        }

        return message;
    }

    private void waitForInputSocketReady(){
        try {
            while(!mMessageReader.ready())
                sleep(100);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void run() {

        mLogger.log(INFO, "Starting new Connection on port " + mLocalSocket.getLocalPort());

        try {

            //Start listening to the socket
            mRemoteSocket = mLocalSocket.accept();

            //Read the incoming message
            mMessageReader = new BufferedReader(new InputStreamReader(mRemoteSocket.getInputStream()));

            //Setup the message sender
            mMessageSender = new BufferedWriter(new OutputStreamWriter(mRemoteSocket.getOutputStream()));

            mUserName = mMessageReader.readLine();

            mLogger.log(INFO, "User " + mUserName +
                    " connected on port " + mLocalSocket.getLocalPort() +
                    " form address " + mRemoteSocket.getInetAddress());

            do {

                //Read message from Player
                mMessage = waitForMessage();

                switch(mMessage){

                    //TODO: remove unused messages
                    case "board": {
                        sendBoard();
                        break;
                    }

                    case "playersOrder":{
                        sendPlayersOrder();
                        break;
                    }

                    case "players": {
                        sendPlayers();
                        break;
                    }

                    case "actions": {

                        break;
                    }

                    default: {
                        mIncomingMessages.add(mMessage);
                    }

                }


            }while(!mMessage.equalsIgnoreCase("close"));

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            mRemoteSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            mLocalSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

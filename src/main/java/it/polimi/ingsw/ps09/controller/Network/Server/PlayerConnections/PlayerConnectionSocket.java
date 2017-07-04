package it.polimi.ingsw.ps09.controller.Network.Server.PlayerConnections;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.ps09.Constants;
import it.polimi.ingsw.ps09.controller.*;
import it.polimi.ingsw.ps09.controller.Game.Game;
import it.polimi.ingsw.ps09.controller.Timer;
import it.polimi.ingsw.ps09.model.*;
import it.polimi.ingsw.ps09.model.Actions.FamilyMemberActions.FamilyMemberAction;
import it.polimi.ingsw.ps09.model.Actions.PlacementActions.PlacementAction;
import it.polimi.ingsw.ps09.model.Actions.PlayerActions.PlayerAction;
import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.DevelopmentCardEffect;
import it.polimi.ingsw.ps09.model.DevelopmentCards.DevelopmentCard;
import it.polimi.ingsw.ps09.model.ExcommunicationTileEffects.ExcommunicationTileEffect;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.GsonAdapters.*;
import it.polimi.ingsw.ps09.model.LeaderCardEffects.LeaderCardEffect;

import java.io.*;
import java.net.Socket;
import java.util.*;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;


/**
 * Created by francesco995 on 15/06/2017.
 *
 * Thread instantiated by the Server app to connect to a Player
 */
public class PlayerConnectionSocket extends Thread implements PlayerConnection{

    //LOGGER
    private static final Logger mLogger = Logger.getAnonymousLogger();

    //Game
    private Board mBoard;

    //Map of Players by ID
    private HashMap<Integer, Player> mPlayers;

    //The Players Order manager
    private PlayersOrder mPlayersOrder;

    //A ServerSocket listening and a Socket to answer
    private Socket mRemoteSocket;

    private BufferedReader mMessageReader;
    private BufferedWriter mMessageSender;

    private String mMessage;

    private Queue<String> mIncomingMessages;

    private String mUserName;

    private int mUserID;

    private Gson mGson = null;
    private GsonBuilder mGsonBuilder;


    private int mActionChoice;
    private String mActionType;
    private boolean mHasActionReady = false;

    private int mLeaderCardChoice;
    private boolean mHasLeaderCardChoiceReady = false;

    private int mPersonalBoardBonusTileChoice;
    private boolean mHasPersonalBoardBonusTileChoiceReady = false;



    public PlayerConnectionSocket(Socket remoteSocket, String userName) throws IOException {

        mRemoteSocket = remoteSocket;
        mUserName = userName;

        mIncomingMessages = new LinkedList<>();

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

        //Create Gson
        mGson = mGsonBuilder.create();

        this.start();

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

    public boolean hasActionReady(){
        return mHasActionReady;
    }

    public void resetActionReady(){
        mHasActionReady = false;
    }


    public int getActionChoice() {
        return mActionChoice;
    }

    public String getActionType() {
        return mActionType;
    }

    public void waitActionReady(){
        while(!mHasActionReady){
            sleep(100);
        }
    }

    public void waitLeaderCardChoiceReady(){
        while(!mHasLeaderCardChoiceReady){
            sleep(100);
        }
    }

    public int getLeaderCardChoice(){
        waitLeaderCardChoiceReady();
        mHasLeaderCardChoiceReady = false;
        return mLeaderCardChoice;
    }

    public void waitPersonalBoardBonusTileChoice(){
        while(!mHasPersonalBoardBonusTileChoiceReady){
            sleep(100);
        }
    }

    public int getPersonalBoardBonusTileChoice(){
        waitPersonalBoardBonusTileChoice();
        mHasPersonalBoardBonusTileChoiceReady = false;
        return mPersonalBoardBonusTileChoice;
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

    public void sendPlacementActionsList(ArrayList<PlacementAction> placementActionsList){
        mLogger.log(INFO, "Game: " + Game.GAME_ID + " sending Placement Actions list to user " + mUserID);
        sendMessage("placementActions");
        sendMessage(String.valueOf(placementActionsList.size()));
        placementActionsList.stream().forEach(a -> sendMessage(mGson.toJson(a, PlacementAction.class)));
    }

    public void sendFamilyMemberActionsList(ArrayList<FamilyMemberAction> familyMemberActionsList){
        mLogger.log(INFO, "Game: " + Game.GAME_ID + " sending FamilyMember Actions list to user " + mUserID);
        sendMessage("familyMemberActions");
        sendMessage(String.valueOf(familyMemberActionsList.size()));
        familyMemberActionsList.stream().forEach(a -> sendMessage(mGson.toJson(a, FamilyMemberAction.class)));
    }

    public void sendPlayerActionsList(ArrayList<PlayerAction> playerActionsList){
        mLogger.log(INFO, "Game: " + Game.GAME_ID + " sending Player Actions list to user " + mUserID);
        sendMessage("playerActions");
        sendMessage(String.valueOf(playerActionsList.size()));
        playerActionsList.stream().forEach(a -> sendMessage(mGson.toJson(a, PlayerAction.class)));
    }

    public void sendLeaderCardsList(ArrayList<LeaderCard> leaderCardsList){
        mLogger.log(INFO, "Game: " + Game.GAME_ID + " sending Leader Cards list to user " + mUserID);
        sendMessage("leaderCardChoice");
        sendMessage(String.valueOf(leaderCardsList.size()));
        leaderCardsList.stream().forEach(l -> sendMessage(mGson.toJson(l, LeaderCard.class)));

    }

    public void sendPersonalBoardBonusTilesList(ArrayList<PersonalBonusTile> personalBoardBonuses){
        mLogger.log(INFO, "Game: " + Game.GAME_ID + " sending Personal Board Bonus Tiles list to user " + mUserID);
        sendMessage("personalBonusTileChoice");
        sendMessage(String.valueOf(personalBoardBonuses.size()));
        personalBoardBonuses.stream().forEach(b -> sendMessage(mGson.toJson(b, PersonalBonusTile.class)));

    }

    public String getMessage(){

        while(mIncomingMessages.isEmpty())
            sleep(50);

        return mIncomingMessages.poll();

    }

    public String getMessage(int timeout, String defaultTimeout){

        it.polimi.ingsw.ps09.controller.Timer timer = new Timer(timeout);
        timer.start();

        while(mIncomingMessages.isEmpty() && !timer.isExpired())
            sleep(50);

        if(mIncomingMessages.isEmpty())
            return defaultTimeout;

        return getMessage();

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

    private boolean hasIncomingMessages(){

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

        try {
            mMessageSender.write(message);
            mMessageSender.write("\n");
            mMessageSender.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if(Constants.ADVANCED_TESTING_SERVER) {
            mLogger.log(INFO, message);
        }
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


        if(Constants.ADVANCED_TESTING_SERVER) {
            mLogger.log(INFO, message);
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

        mLogger.log(INFO, "Starting new Connection on port " + mRemoteSocket.getLocalPort());

        try {

            //Read the incoming message
            mMessageReader = new BufferedReader(new InputStreamReader(mRemoteSocket.getInputStream()));

            //Setup the message sender
            mMessageSender = new BufferedWriter(new OutputStreamWriter(mRemoteSocket.getOutputStream()));

            mLogger.log(INFO, "User " + mUserName +
                    " connected on port " + mRemoteSocket.getLocalPort() +
                    " form address " + mRemoteSocket.getInetAddress());

            do {

                //Read message from Player
                mMessage = waitForMessage();

                switch(mMessage){

                    case "leaderCardChoice":{

                        mLeaderCardChoice = Integer.valueOf(waitForMessage());
                        mHasLeaderCardChoiceReady = true;

                        break;

                    }

                    case "personalBoardBonusTileChoice":{

                        mPersonalBoardBonusTileChoice = Integer.valueOf(waitForMessage());
                        mHasPersonalBoardBonusTileChoiceReady = true;

                        break;
                    }

                    case "doPlacementAction":{

                        mActionType = "PLACEMENT";
                        mActionChoice = Integer.valueOf(waitForMessage());
                        mHasActionReady = true;

                        break;
                    }

                    case "doFamilyMemberAction": {

                        mActionType = "FAMILY_MEMBER";
                        mActionChoice = Integer.valueOf(waitForMessage());
                        mHasActionReady = true;

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

    }


}

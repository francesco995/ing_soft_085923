package it.polimi.ingsw.ps09.controller;

import it.polimi.ingsw.ps09.Constants;
import it.polimi.ingsw.ps09.controller.Game.Game;
import it.polimi.ingsw.ps09.controller.Network.Server.PlayerConnections.PlayerConnection;
import it.polimi.ingsw.ps09.controller.Network.Server.WelcomeServers.WelcomeSocketServer;
import it.polimi.ingsw.ps09.model.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by francesco995 on 16/06/2017.
 */
public class Server extends Thread{

    private static final Logger mLogger = Logger.getLogger(Player.class.getName());

    private int mGameTimeout = Constants.GAME_START_TIMEOUT;

    private Queue<PlayerConnection> mQueuedPlayers = new LinkedList<>();

    private WelcomeSocketServer mWelcomeSocketServer;

    private List<Game> mActiveGames;

    private Timer mTimer;

    public void startWelcomeServer() throws IOException {

        mWelcomeSocketServer = new WelcomeSocketServer();
        mWelcomeSocketServer.start();

        mActiveGames = new LinkedList<>();


    }

    public Server(){

        String stringTimeout;

        //Create the directory path
        File mDirectory = new File("./");
        String mFilePath = mDirectory.getAbsolutePath().replace(".",
                "src/main/res/");

        try {
            stringTimeout = loadStringFromFile(mFilePath + Constants.GAME_START_TIMEOUT_FILE);
            mGameTimeout = Integer.valueOf(stringTimeout);
        } catch (FileNotFoundException e) {
            mGameTimeout = Constants.GAME_START_TIMEOUT;
        } catch (NumberFormatException e) {
            mGameTimeout = Constants.GAME_START_TIMEOUT;
        }

        mTimer = new Timer(mGameTimeout);


    }



    /**
     * Loads a text-based file to a string
     *
     * @param fileName name of the file to load
     * @return returns the file as a string
     * @throws FileNotFoundException
     */
    private String loadStringFromFile(String fileName) throws FileNotFoundException {

        String mStringDeck;

        Scanner mScanner = new Scanner(new File(fileName));
        mStringDeck = mScanner.next();

        mScanner.close();

        return mStringDeck;
    }

    private void sleep(int mS){

        try {
            Thread.sleep(mS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void addReadyConnection() {

        if (mWelcomeSocketServer.hasReadyConnections()) {

            mQueuedPlayers.add(mWelcomeSocketServer.getReadyConnection());
        }
    }

    private void addReadyGame(){

        if(mQueuedPlayers.size() >= 2) {

            if (mTimer.isExpired()) {
                mTimer = new Timer(mGameTimeout);
                startNewGame();
            } else {
                if (!mTimer.isRunning()) {
                    mTimer.startTimer();
                }
            }
        }

        if(mQueuedPlayers.size() >= 4){

            if(mTimer.isRunning()){
                mTimer.interrupt();
                mTimer = new Timer(mGameTimeout);
            }

            startNewGame();

        }

    }

    private void startNewGame(){

        sleep(3000);

        int playersN;

        if(mQueuedPlayers.size() > 4)
            playersN = 4;
        else
            playersN = mQueuedPlayers.size();

        //Generate GameID
        int gameID = (mActiveGames.size() + 1) * 100;

        //Generate userIDs
        ArrayList<Integer> userIDs = new ArrayList<>();

        //Generate Player connections
        HashMap<Integer, PlayerConnection> connections = new HashMap<>();

        for(int i = 0; i < playersN; i++){
            userIDs.add(gameID + userIDs.size() + 1);
        }

        //Generate partial PlayerConnections List
        ArrayList<PlayerConnection> readyPlayersConnections = new ArrayList<>();

        for(int i = 0; i < playersN; i++){
            readyPlayersConnections.add(mQueuedPlayers.poll());
            connections.put(userIDs.get(i), readyPlayersConnections.get(i));
        }

        //Generate userName List
        List<String> userNames = readyPlayersConnections.stream()
                .map(p -> p.getUserName())
                .collect(Collectors.toList());

        //Generate userColor List
        ArrayList<String> userColors = new ArrayList<>();
        userColors.add("RED");
        userColors.add("GREEN");
        userColors.add("BLUE");
        userColors.add("YELLOW");

        mActiveGames.add(new Game(userIDs, userNames, userColors, gameID, connections));
        mActiveGames.get(mActiveGames.size() - 1).start();


    }


    public void run(){

        while(true){

            sleep(100);

            addReadyConnection();

            addReadyGame();

        }

    }




}

package it.polimi.ingsw.ps09.controller;

import it.polimi.ingsw.ps09.controller.Game.Game;
import it.polimi.ingsw.ps09.controller.Network.Server.PlayerConnections.PlayerConnection;
import it.polimi.ingsw.ps09.controller.Network.Server.PlayerConnections.PlayerConnectionSocket;
import it.polimi.ingsw.ps09.controller.Network.Server.WelcomeServers.WelcomeSocketServer;
import it.polimi.ingsw.ps09.model.Player;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by francesco995 on 16/06/2017.
 */
public class Server extends Thread{

    private static final Logger mLogger = Logger.getLogger(Player.class.getName());

    private Queue<PlayerConnection> mQueuedPlayers = new LinkedList<>();

    private WelcomeSocketServer mWelcomeSocketServer;

    private List<Game> mActiveGames;



    public void startWelcomeServer() throws IOException {

        mWelcomeSocketServer = new WelcomeSocketServer();
        mWelcomeSocketServer.start();

        mActiveGames = new LinkedList<>();


    }

    private void sleep(int mS){

        try {
            Thread.sleep(mS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void addReadyConnection(){

        if(mWelcomeSocketServer.hasReadyPorts()) {
            try {

                mQueuedPlayers.add(new PlayerConnectionSocket(mWelcomeSocketServer.getReadyPort()));


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void addReadyGame(){

        if(mQueuedPlayers.size() >= 4){

            sleep(6000);

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
            List<PlayerConnection> readyPlayersConnections = new LinkedList<>();

            for(int i = 0; i < playersN; i++){
                readyPlayersConnections.add(mQueuedPlayers.poll());
                connections.put(userIDs.get(i), readyPlayersConnections.get(i));
            }

            //Generate userName List
            List<String> userNames = readyPlayersConnections.stream()
                    .map(p -> p.getUserName())
                    .collect(Collectors.toList());

            //Generate userColor List
            List<String> userColors = new LinkedList<>();
            userColors.add("RED");
            userColors.add("GREEN");
            userColors.add("BLUE");
            userColors.add("YELLOW");

            mActiveGames.add(new Game(userIDs, userNames, userColors, gameID, connections));
            mActiveGames.get(mActiveGames.size() - 1).start();


        }

    }


    public void run(){

        while(true){

            sleep(500);

            addReadyConnection();

            addReadyGame();

        }

    }




}

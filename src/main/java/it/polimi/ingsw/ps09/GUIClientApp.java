package it.polimi.ingsw.ps09;

import it.polimi.ingsw.ps09.controller.Network.Client.ServerConnections.ServerConnection;
import it.polimi.ingsw.ps09.controller.Network.Client.ServerConnections.ServerConnectionSocket;
import it.polimi.ingsw.ps09.view.CLIClientGame;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



import static java.util.logging.Level.WARNING;

/**
 * Created by francGianni on 15/05/2017.
 */
public class GUIClientApp extends Application{


    @FXML private TextField nameInput;
    @FXML private TextField serverInput;


    @Override
    public void start(Stage connectionStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ConnectionStage.fxml"));

        connectionStage.setTitle("Lorenzo il Magnifico");
        connectionStage.setScene(new Scene(root, 500, 475));
        connectionStage.show();

    }

    public void quitGame(ActionEvent actionEvent){
        Platform.exit();
    }

    public void startGame(ActionEvent actionEvent) throws IOException {

        final Logger mLogger = Logger.getAnonymousLogger();
        String mUserName = nameInput.getText();
        String mServerAddress = serverInput.getText();

        CLIClientGame mClientGame;

        ServerConnection serverConnectionSocket = new ServerConnectionSocket(mServerAddress, mUserName);
        serverConnectionSocket.start();

        do{
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                mLogger.log(WARNING, "Interrupted!", e);
                // clean up state...
                Thread.currentThread().interrupt();
            }

        }while(!serverConnectionSocket.isConnected());


        mClientGame = new CLIClientGame(serverConnectionSocket, mUserName);

        mClientGame.run();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

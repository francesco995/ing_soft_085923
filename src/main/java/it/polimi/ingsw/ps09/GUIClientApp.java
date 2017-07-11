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

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import static java.util.logging.Level.WARNING;

/**
 * Created by francGianni on 15/05/2017.
 */
public class GUIClientApp extends Application{


    @FXML private TextField nameInput;
    @FXML private TextField serverInput;
    @FXML private Button firstBtn;
    @FXML private Button secondBtn;
    @FXML private Button thirdBtn;
    @FXML private Button fourthBtn;

    private Thread mThread;



    @Override
    public void start(Stage connectionStage) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ConnectionStage.fxml"));

        connectionStage.setTitle("Lorenzo il Magnifico");
        connectionStage.setScene(new Scene(root, 500, 475));
        connectionStage.show();


    }

    public void quitGame(ActionEvent actionEvent){
        Platform.exit();
    }

    @FXML
    public void startGame(ActionEvent actionEvent) throws Exception {

        final Logger mLogger = Logger.getAnonymousLogger();
        String mUserName = nameInput.getText();
        String mServerAddress = serverInput.getText();

        Stage mStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

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
        mThread = new Thread(mClientGame);
        mThread.start();


        //Switch scene handler
        Platform.runLater(new Runnable() {
            public void run() {
                Stage mainStage = new Stage();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/fxml/MainStage.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mStage.setScene(new Scene(root, 500, 475));

                mStage.show();
            }
        });

        ImageView graphic = new ImageView(new Image("file:/Users/walle/Documents/GitHub/ing_soft_085923/src/main/res/drawable/LeaderCards/leaders_f_c_01.jpg"));

        firstBtn.setStyle("-fx-background-image: url('/drawable/LeaderCards/leaders_f_c_01.jpg')");


    }


    public static void main(String[] args) {
        launch(args);
    }
}

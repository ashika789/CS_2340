package game;
import game.Location;
import game.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import game.Player;


/**
 * Created by yamininambiar on 9/24/15.
 */
public class Driver {

    private boolean landSelection = true;
    private int roundNumber = 1;
    private ArrayList<Player> players;
    private Stage stage;
    private Parent root;


    public void configure(ArrayList<Player> players, Parent root, Stage stage, Button source, boolean hasSelected) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/game/StandardMap.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        this.players = players;
        this.stage = stage;
        this.root = root;
        int playerNumber = 0;
        for (int i = 0; i < players.size() * 2; i++) {
            //popup
            if (i == players.size()) {
                playerNumber = 0;
            }
            if (hasSelected) {

                hasSelected = false;
            }

            /*Selection phase*/
            System.out.println("Player number " + playerNumber + " selects tile by clicking the map");//Player selects tile by clicking the map
            int x = 0, y = 0; //coordinates of selected property tile
            players.get(playerNumber).addProperty(new Location(x, y)); //adds selected property to this Player's list of properties
            hasSelected = true; //Player is done selecting property
            playerNumber++; //set playerNumber to the next player

        }
        startRound(root, stage);
    }

    public void selectProperty(Location loc, Button source) throws IOException {
        if (roundNumber == players.size() * 2) {
            //get out of selection phase
            landSelection = false;
            roundNumber = 1;
        }
        int playerNumber = roundNumber % players.size();
        players.get(playerNumber).addProperty(loc);
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("/game/purchasePropertyScreen.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Purchase Property for " + players.get(playerNumber).getName());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(source.getScene().getWindow());
        stage.showAndWait();
        roundNumber++;
    }

    public void startRound(Parent root, Stage stage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/game/startRound1Screen.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Round " + roundNumber);
        stage.setScene(scene);
        stage.show();
        roundNumber++;
        startTurn();
    }

    public void startTurn() {

    }
}

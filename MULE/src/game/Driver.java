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

    int roundNumber = 1;

    public void configure(ArrayList<Player> players, Parent root, Stage stage, Button source, boolean hasSelected) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/game/StandardMap.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        int playerNumber = 0;
        for (int i = 0; i < players.size() * 2; i++) {
            //popup
            if (i == players.size()) {
                playerNumber = 0;
            }
            if (hasSelected) {
                stage = new Stage();
                root = FXMLLoader.load(getClass().getResource("/game/purchasePropertyScreen.fxml"));
                stage.setScene(new Scene(root));
                stage.setTitle("Purchase Property for " + players.get(playerNumber).getName());
                stage.initModality(Modality.NONE);
                stage.initOwner(source.getScene().getWindow());
                stage.showAndWait();
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

    public void startRound(Parent root, Stage stage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/game/startRound1Screen.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Round " + roundNumber);
        stage.setScene(scene);
        stage.show();
        roundNumber++;
    }
}

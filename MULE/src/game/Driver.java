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
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.image.ImageView;

import game.Player;


/**
 * Created by yamininambiar on 9/24/15.
 */
public class Driver {

    private boolean landSelection = true;
    private int roundNumber;
    private ArrayList<Player> players;
    private Stage stage;
    private Parent root;
    private ArrayList<String> selectorImagesURLS = new ArrayList<String>() {{
        add("file:graphics/p1Selector.png");
        add("file:graphics/p2Selector.png");
        add("file:graphics/p3Selector.png");
        add("file:graphics/p4Selector.png");
    }};



    public void configure(ArrayList<Player> players, Parent root, Stage stage, Button source, boolean hasSelected) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/game/StandardMap.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        this.players = players;
        this.stage = stage;
        this.root = root;
        roundNumber = 1;
        int playerNumber = 0;

        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("/game/purchasePropertyScreen.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Purchase Property for " + players.get(playerNumber).getName());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(source.getScene().getWindow());
        stage.showAndWait();
    }

    public void selectProperty(Location loc, Button source, VBox vbox) throws IOException {
        if (landSelection) {
            int playerNumber = (roundNumber - 1) % players.size();
            players.get(playerNumber).addProperty(loc);
            displaySelector(source, vbox);
            if (roundNumber == players.size() * 2) {
                //get out of selection phase
                landSelection = false;
                roundNumber = 1;
                startRound(root, stage);
            } else {
                stage = new Stage();
                root = FXMLLoader.load(getClass().getResource("/game/purchasePropertyScreen.fxml"));
                stage.setScene(new Scene(root));
                stage.setTitle("Purchase Property for " + players.get(playerNumber).getName());
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initOwner(source.getScene().getWindow());
                stage.showAndWait();
                roundNumber++;
            }
        }
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

    public void displaySelector(Button b, VBox vbox) throws IOException {
        int curPlayer = (roundNumber - 1) % players.size();
        System.out.println(selectorImagesURLS.get(curPlayer));

        javafx.scene.image.ImageView imgv = new javafx.scene.image.ImageView(selectorImagesURLS.get(curPlayer));

        imgv.setFitHeight(64);
        imgv.setFitWidth(64);
        System.out.println("layoutX" + b.getLayoutX());
        System.out.println("layoutY" + b.getLayoutY());
        imgv.setX(b.getLayoutX());
        imgv.setY(b.getLayoutY());
        imgv.toFront();
        b.toFront();

        vbox.getChildren().add(imgv);
    }



    public void startTurn() {

    }
}

package game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by yamininambiar on 9/24/15.
 */
public class Driver {

    private boolean landSelection = true;
    private int roundNumber;
    private ArrayList<Player> players;
    private Stage stage;
    private Parent root;
    private ArrayList<String> plainURLS = new ArrayList<String>() {{
        add("file:graphics/TilePlainP1.png");
        add("file:graphics/TilePlainP2.png");
        add("file:graphics/TilePlainP3.png");
        add("file:graphics/TilePlainP4.png");
    }};
    private ArrayList<String> riverURLS = new ArrayList<String>() {{
        add("file:graphics/TileRiverP1.png");
        add("file:graphics/TileRiverP2.png");
        add("file:graphics/TileRiverP3.png");
        add("file:graphics/TileRiverP4.png");
    }};
    private ArrayList<String> m1URLS = new ArrayList<String>() {{
        add("file:graphics/TileMountain1P1.png");
        add("file:graphics/TileMountain1P2.png");
        add("file:graphics/TileMountain1P3.png");
        add("file:graphics/TileMountain1P4.png");
    }};
    private ArrayList<String> m2URLS = new ArrayList<String>() {{
        add("file:graphics/TileMountain2P1.png");
        add("file:graphics/TileMountain2P2.png");
        add("file:graphics/TileMountain2P3.png");
        add("file:graphics/TileMountain2P4.png");
    }};
    private ArrayList<String> m3URLS = new ArrayList<String>() {{
        add("file:graphics/TileMountain3P1.png");
        add("file:graphics/TileMountain3P2.png");
        add("file:graphics/TileMountain3P3.png");
        add("file:graphics/TileMountain3P4.png");
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

    public void selectProperty(Location loc, Button source, ImageView imgv) throws IOException {
        if (landSelection) {
            int playerNumber = (roundNumber - 1) % players.size();
            players.get(playerNumber).addProperty(loc);
            changeTile(imgv);
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

    public void changeTile(ImageView imgv) throws IOException {
        int curPlayer = (roundNumber) % players.size();
        System.out.println(selectorImagesURLS.get(curPlayer));
        if (imgv.getImage() == "file: graphics/TilePlain.png") {
            imgv.setImage(new Image(plainURLS.get(curPlayer)));
        } else if (imgv.getImage() == "file: graphics/TileRiver.png") {
            imgv.setImage(new Image(riverURLS.get(curPlayer)));
        } else if (imgv.getImage() == "file: graphics/TileMountain1.png") {
            imgv.setImage(new Image(m1URLS.get(curPlayer)));
        } else if (imgv.getImage() == "file: graphics/TileMountain2.png") {
            imgv.setImage(new Image(m2URLS.get(curPlayer)));
        } else if (imgv.getImage() == "file: graphics/TileMountain3.png") {
            imgv.setImage(new Image(m3URLS.get(curPlayer)));
        }
    }



    public void startTurn() {

    }
}

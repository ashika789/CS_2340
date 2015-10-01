package game;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by yamininambiar on 9/24/15.
 */
public class Driver {

    //data
    private boolean landSelection = true;
    private static int roundNumber;
    private ArrayList<Player> players;
    private Stage stage;
    private Parent root;
    private ArrayList<String> plainURLS = new ArrayList<String>() {{
        add("file:/src/game/graphics/TilePlainP1.png");
        add("file:/src/game/graphics/TilePlainP2.png");
        add("file:/src/game/graphics/TilePlainP3.png");
        add("file:/src/game/graphics/TilePlainP4.png");
    }};
    private ArrayList<String> riverURLS = new ArrayList<String>() {{
        add("file:/src/game/graphics/TileRiverP1.png");
        add("file:/src/game/graphics/TileRiverP2.png");
        add("file:/src/game/graphics/TileRiverP3.png");
        add("file:/src/game/graphics/TileRiverP4.png");
    }};
    private ArrayList<String> m1URLS = new ArrayList<String>() {{
        add("file:/src/game/graphics/TileMountain1P1.png");
        add("file:/src/game/graphics/TileMountain1P2.png");
        add("file:/src/game/graphics/TileMountain1P3.png");
        add("file:/src/game/graphics/TileMountain1P4.png");
    }};
    private ArrayList<String> m2URLS = new ArrayList<String>() {{
        add("file:/src/game/graphics/TileMountain2P1.png");
        add("file:/src/game/graphics/TileMountain2P2.png");
        add("file:/src/game/graphics/TileMountain2P3.png");
        add("file:/src/game/graphics/TileMountain2P4.png");
    }};
    private ArrayList<String> m3URLS = new ArrayList<String>() {{
        add("file:/src/game/graphics/TileMountain3P1.png");
        add("file:/src/game/graphics/TileMountain3P2.png");
        add("file:/src/game/graphics/TileMountain3P3.png");
        add("file:/src/game/graphics/TileMountain3P4.png");
    }};

    private ArrayList<Location> plainLocations = new ArrayList<Location>() {{
        add(new Location(0,0));
        add(new Location(0,1));
        add(new Location(0,3));
        add(new Location(0,5));
        add(new Location(0,7));
        add(new Location(0,8));
        add(new Location(1,0));
        add(new Location(1,2));
        add(new Location(1,3));
        add(new Location(1,5));
        add(new Location(1,6));
        add(new Location(1,7));
        add(new Location(2,1));
        add(new Location(2,2));
        add(new Location(2,3));
        add(new Location(2,5));
        add(new Location(2,6));
        add(new Location(2,7));
        add(new Location(3,0));
        add(new Location(3,2));
        add(new Location(3,3));
        add(new Location(3,5));
        add(new Location(3,7));
        add(new Location(3,8));
        add(new Location(4,0));
        add(new Location(4,1));
        add(new Location(4,3));
        add(new Location(4,5));
        add(new Location(4,6));
        add(new Location(4,7));
    }};

    private ArrayList<Location> riverLocations = new ArrayList<Location>() {{
        add(new Location(0,4));
        add(new Location(1,4));
        add(new Location(3,4));
        add(new Location(4,4));
    }};

    private ArrayList<Location> m1Locations = new ArrayList<Location>() {{
        add(new Location(0,2));
        add(new Location(1,1));
        add(new Location(2,8));
    }};

    private ArrayList<Location> m2Locations = new ArrayList<Location>() {{
        add(new Location(3,1));
        add(new Location(4,2));
        add(new Location(3,6));
        add(new Location(4,8));
    }};

    private ArrayList<Location> m3Locations = new ArrayList<Location>() {{
        add(new Location(2,0));
        add(new Location(0,6));
        add(new Location(1,8));
    }};

    //methods
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
            players.get(playerNumber).addProperty(loc); //add property to player's property
            players.get(playerNumber).addMoney(-loc.getBuyingPrice()); //subtract money from player
            changeTile(loc, imgv);
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

        //put in here timer for each round
    }


    public void changeTile(Location loc, ImageView imgv) throws IOException {
        int curPlayer = (roundNumber) % players.size();
        System.out.println(imgv.getId());
        System.out.println("x" + loc.x + "y" + loc.y);
        if (containsLocation(plainLocations, loc)) {
            System.out.println("changing plain");
            System.out.println(plainURLS.get(curPlayer));
            imgv.setImage(new Image(plainURLS.get(curPlayer)));
        } else if (containsLocation(riverLocations, loc)) {
            System.out.println("changing river");
            imgv.setImage(new Image(riverURLS.get(curPlayer)));
        } else if (containsLocation(m1Locations, loc)) {
            System.out.println("changing m1");
            imgv.setImage(new Image(m1URLS.get(curPlayer)));
        } else if (containsLocation(m2Locations, loc)) {
            System.out.println("changing m2");
            imgv.setImage(new Image(m2URLS.get(curPlayer)));
        } else if (containsLocation(m3Locations, loc)) {
            System.out.println("changing m3");
            imgv.setImage(new Image(m3URLS.get(curPlayer)));
        }
    }

    public boolean containsLocation(ArrayList<Location> locations, Location loc) {
        double x = loc.x;
        double y = loc.y;
        boolean containsLocation = false;
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).x == x && locations.get(i).y == y) {
                containsLocation = true;
            }
        }
        return containsLocation;
    }

    public static int getRoundNumber() {
        return roundNumber;
    }

    //sorts based on money, from greatest to least
    public ArrayList<Player> getTurnOrder() {
        players.sort(new Player.PlayerComparator<Player>());
        return players;
    }

    public void startTurn() {

    }
}

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


public class Driver {

    //data
    private int roundNumber; //-1 and 0 are land selection phase, 1-12 are game rounds
    private int turnNumber; // first player = 1, second player = 2, etc
    private Player currentPlayer;
    private ArrayList<Player> players;
    private Timer timer;
    private Stage stage;
    private Parent root;
    private int timeleft;
    @FXML
    private Text time;


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

    public void selectProperty(Location loc, Button source, ImageView imgv) throws IOException {
        if (isLandSelectionPhase()) {
            int playerNumber = (roundNumber - 1) % players.size();
            players.get(playerNumber).addProperty(loc); //add property to player's property
            players.get(playerNumber).addMoney(-loc.getBuyingPrice()); //subtract money from player
            changeTile(loc, imgv);
            if (roundNumber == players.size() * 2) {
                //get out of selection phase
                roundNumber = 1;
                startRound();
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

    //methods
    public void configure(ArrayList<Player> players, Parent root, Stage stage, Button source, boolean hasSelected) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/game/StandardMap.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        this.players = players;
        this.stage = stage;
        this.root = root;
        roundNumber = -1;
        turnNumber = 0;
        currentPlayer = players.get(0); //TODO have a minigame to determine this
        startTurn();
    }

    public void startRound() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/game/startRound1Screen.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Round " + roundNumber);
        stage.setScene(scene);
        stage.showAndWait();
        if (!isLandSelectionPhase()) {
            calculatePlayerOrder();
        }
        startTurn();
    }

    public void initializeTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new RoundTimerTask(), 500, 1000);

    }

private int countDown = 60;

    public class RoundTimerTask extends TimerTask {
        public void run() {
//            if (timeleft != 0) {
//                timeleft--;
//            }
            time.setText("Time Left:" + countDown);
            countDown--;
            if (countDown <= 0) {
                timer.cancel();
                time.setText("YOUR TURN IS OVER!");
                countDown = 60;
                try {
                    endTurn();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public void startTurn() throws IOException {
        currentPlayer = players.get(turnNumber - 1);
        if (isLandSelectionPhase()) {
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("/game/purchasePropertyScreen.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Purchase Property for " + currentPlayer.getName());
            stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initOwner(source.getScene().getWindow());
            stage.showAndWait();
        }
    }

    public void endTurn() throws IOException {
        if (turnNumber == players.size()) {
            if (roundNumber == 12) {
                //TODO Game over screen
            }
            else {
                turnNumber = 1;
                roundNumber++;
                startRound();
            }
        } else {
            turnNumber++;
            startTurn();
        }
    }

    public boolean purchaseProperty(Location loc) {

        /*
        if (loc has not been purchased) {
            if (isLandSelectionPhase()) {
                purchase property
                return true
            if (player can afford it) {
                purchase the property
                change player money
                return true
            } else {
                return false
            }
        } else {
            return false
         */
        return false;
    }

    //getters
    public Player getPlayer() {
        return currentPlayer;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getTurnNumber() {
        return turnNumber;
    }
    //sorts based on score, from greatest to least
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void calculatePlayerOrder() {
        players.sort(new Player.PlayerComparator<Player>());
    }

    public boolean isLandSelectionPhase() {
        return (turnNumber == -1 || turnNumber == 0);
    }



}
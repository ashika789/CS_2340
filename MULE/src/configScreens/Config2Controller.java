package configScreens;

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
import game.Driver;

import javax.xml.bind.SchemaOutputResolver;

public class Config2Controller extends ControllerSuper {

    @FXML
    private ComboBox<String> combo1race, combo2race, combo3race, combo4race;
    @FXML
    private Button config2StartBtn, config2BackBtn;
    @FXML
    private ComboBox<String> combo1human, combo2human, combo3human, combo4human;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField p1Name, p2Name, p3Name, p4Name;

    public static ArrayList<Player> players = new ArrayList<Player>();
    public static Map gameMap = null;
    public static boolean hasSelected = true;

    ObservableList<String> humanBox = FXCollections.observableArrayList("Human", "AI", "Not playing");
    ObservableList<String> raceBox = FXCollections.observableArrayList("Human", "Flapper", "Bonzoid", "Ugaite", "Buzzite");

    @FXML
    private void config2ButtonAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = null;
        Button source = (Button) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        if (source == config2StartBtn) {
            if (verifyComboBoxes()) {
                driver.configure(players, root, stage, source, hasSelected);
            } else {
                errorLabel.setVisible(true);
            }
        } else {
            root = FXMLLoader.load(getClass().getResource("configScreen1.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

    private boolean verifyComboBoxes() {
        boolean[] players = {false, false, false, false};
        if (combo1human.getValue() == "Not playing") {
            players[0] = true;
        } else if (combo1human.getValue() != null && combo1race.getValue() != null) {
            players[0] = true;
            this.players.add(new Player(p1Name.getText(), combo1human.getValue(), combo1race.getValue(), 1));
            //after names are added, add name parameter to game.Player ctor
        }
        if (combo2human.getValue() == "Not playing") {
            players[1] = true;
        } else if (combo2human.getValue() != null && combo2race.getValue() != null) {
            players[1] = true;
            this.players.add(new Player(p2Name.getText(), combo1human.getValue(), combo1race.getValue(), 1));
        }
        if (combo3human.getValue() == "Not playing") {
            players[2] = true;
        } else if (combo3human.getValue() != null && combo3race.getValue() != null) {
            players[2] = true;
            this.players.add(new Player(p3Name.getText(), combo1human.getValue(), combo1race.getValue(), 1));
        }
        if (combo4human.getValue() == "Not playing") {
            players[3] = true;
        } else if (combo4human.getValue() != null && combo4race.getValue() != null) {
            players[3] = true;
            this.players.add(new Player(p4Name.getText(), combo1human.getValue(), combo1race.getValue(), 1));
        }
        if (players[0] && players[1] && players[2] && players[3]) {
            gameMap = new Map(new Location[5][9], this.players);
            return true;
        } else {
            return false;
        }
    }

    public void initialize() throws IOException {
        combo1human.setItems(humanBox);
        combo2human.setItems(humanBox);
        combo3human.setItems(humanBox);
        combo4human.setItems(humanBox);
        combo1race.setItems(raceBox);
        combo2race.setItems(raceBox);
        combo3race.setItems(raceBox);
        combo4race.setItems(raceBox);

    }
}

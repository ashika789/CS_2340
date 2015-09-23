package configScreens;

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

public class Config2Controller {

    @FXML
    private ComboBox<String> combo1race, combo2race, combo3race, combo4race;
    @FXML
    private Button config2StartBtn, config2BackBtn;
    @FXML
    private ComboBox<String> combo1human, combo2human, combo3human, combo4human;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField p1Name, p2Name, p3Name, p4Names;

    public ArrayList<Player> players = new ArrayList<Player>();

    ObservableList<String> humanBox = FXCollections.observableArrayList("Human", "AI", "Not playing");
    ObservableList<String> raceBox = FXCollections.observableArrayList("Human", "Flapper", "Bonzoid", "Ugaite", "Buzzite");

    @FXML
    private void config2ButtonAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        Button source = (Button) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        if (source == config2StartBtn) {
            if (verifyComboBoxes()) {
                root = FXMLLoader.load(getClass().getResource("/game/StandardMap.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                //popup window asking player
                System.out.println(players);
                for (int i = 0; i < players.size(); i++) {
                    stage = new Stage();
                    root = FXMLLoader.load(getClass().getResource("/game/purchasePropertyScreen.fxml"));
                    stage.setScene(new Scene(root));
                    stage.setTitle("Purchase Property for Player " + (i + 1));
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.initOwner(source.getScene().getWindow());
                    stage.showAndWait();
                }

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
        //need to add names,
        boolean[] players = {false, false, false, false};
        if (combo1human.getValue() == "Not playing") {
            players[0] = true;
        } else if (combo1human.getValue() != null && combo1race.getValue() != null) {
                players[0] = true;
                this.players.add(new Player("Player 1", combo1human.getValue(), combo1race.getValue(), 1));
            //after names are added, add name parameter to game.Player ctor
        }
        if (combo2human.getValue() == "Not playing") {
            players[1] = true;
        } else if (combo2human.getValue() != null && combo2race.getValue() != null) {
            players[1] = true;
            this.players.add(new Player("Player 2", combo1human.getValue(), combo1race.getValue(), 1));
        }
        if (combo3human.getValue() == "Not playing") {
            players[2] = true;
        } else if (combo3human.getValue() != null && combo3race.getValue() != null) {
            players[2] = true;
            this.players.add(new Player("Player 3", combo1human.getValue(), combo1race.getValue(), 1));
        }
        if (combo4human.getValue() == "Not playing") {
            players[3] = true;
        } else if (combo4human.getValue() != null && combo4race.getValue() != null) {
            players[3] = true;
            this.players.add(new Player("Player 4", combo1human.getValue(), combo1race.getValue(), 1));
        }
        if (players[0] && players[1] && players[0] && players[0] ) {
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

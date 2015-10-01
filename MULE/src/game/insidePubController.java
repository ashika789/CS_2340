package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class insidePubController extends configScreens.ControllerSuper{

    @FXML
    private Button yesGambleBtn;
    @FXML
    private Button noGambleBtn;

    @FXML
    private Button doneGamblingBtn;

    @FXML
    private Label resultsLabel;

    @FXML
    private void buttonHandler(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = null;
        Button source = (Button) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        if (source == yesGambleBtn) {
            int time = driver.getTimeLeft();
            if (time >= 37) {
                time = 200;
            } else if (37 > time >= 25) {
                time = 150;
            } else if (25 > time >= 12) {
                time = 100;
            } else {
                time = 50;
            }

            int round = driver.getRoundNumber();
            int[] roundBonuses = {50, 50, 50, 100, 100, 100, 100, 150, 150, 150, 150, 200};
            int bonus = new Random().nextInt(time) + roundBonuses[round - 1];
            driver.getPlayer().addMoney(bonus);
            //Display money earned screen TODO
            driver.startTurn();
            resultsLabel.setText(Integer.toString(bonus));
        } else if (source == noGambleBtn) {
            root = FXMLLoader.load(getClass().getResource("insideTown.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (source == doneGamblingBtn) {
            Driver.endTurn();
        }
    }
}

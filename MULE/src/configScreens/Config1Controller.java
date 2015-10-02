package configScreens;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Config1Controller extends ControllerSuper {

    @FXML
    private Button config1NextBtn, config1BackBtn;
    private ToggleGroup difficultyToggle, mapToggle;
    @FXML
    private RadioButton easyRadio, mediumRadio, hardRadio, standardMapRadio, randomMapRadio;
    @FXML
    private Label errorLabel;

    @FXML
    private void config1ButtonAction(ActionEvent event) throws IOException {


        Stage stage;
        Parent root;
        Button source = (Button) event.getSource();
        stage = (Stage) source.getScene().getWindow();

//        String toPlay = "music.mp3";
//        Media hit = new Media(toPlay);
//        MediaPlayer mediaPlayer = new MediaPlayer(hit);
//        mediaPlayer.play();

        if (source == config1NextBtn) {
            boolean toggles[] = {false, false};
            for (Toggle t : difficultyToggle.getToggles()) {
                if (t.isSelected()) {
                    toggles[0] = true;
                }
            }
            for (Toggle t : mapToggle.getToggles()) {
                if (t.isSelected()) {
                    toggles[1] = true;
                }
            }
            if (toggles[0] && toggles[1]) {
                root = FXMLLoader.load(getClass().getResource("configScreen2.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else {
                errorLabel.setVisible(true);
            }
        } else {
            root = FXMLLoader.load(getClass().getResource("home.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void initialize() throws IOException {
        mapToggle = new ToggleGroup();
        difficultyToggle = new ToggleGroup();
        easyRadio.setToggleGroup(difficultyToggle);
        mediumRadio.setToggleGroup(difficultyToggle);
        hardRadio.setToggleGroup(difficultyToggle);
        standardMapRadio.setToggleGroup(mapToggle);
        randomMapRadio.setToggleGroup(mapToggle);
    }
}

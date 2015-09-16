package configScreensM3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class Config1Controller {

    @FXML
    private Button config1NextBtn, config1BackBtn;
    @FXML
    private ToggleGroup difficultyToggle;
    @FXML
    private ToggleGroup mapToggle;
    @FXML
    private RadioButton easyRadio, mediumRadio, hardRadio, standardMapRadio, randomMapRadio;

    @FXML
    private void config1ButtonAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        Button source = (Button) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        if (source == config1NextBtn) {
            root = FXMLLoader.load(getClass().getResource("configScreen2.fxml"));
        } else {
            root = FXMLLoader.load(getClass().getResource("home.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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

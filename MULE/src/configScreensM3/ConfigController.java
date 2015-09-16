package configScreensM3;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConfigController {

    @FXML
    private Button playBtn;
    @FXML
    private Button playScrnNext;
    @FXML
    private Button playScrnBack;
    @FXML
    private Button gameStart;
    @FXML
    private Button playerConfigBack;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == playBtn) {
            stage = (Stage) playBtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("playScreen.fxml"));
        } else if (event.getSource() == playerConfigBack) {
            stage = (Stage) playerConfigBack.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("playScreen.fxml"));
        } else if (event.getSource() == playScrnNext) {
            stage = (Stage) playScrnNext.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("playerConfigScreen.fxml"));
        } else if (event.getSource() == playScrnBack) {
            stage = (Stage) playScrnBack.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("home.fxml"));
        } else {
            stage = (Stage) playerConfigBack.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("gamePlaceHolderScreen.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(URL url, ResourceBundle rb) {

    }
}

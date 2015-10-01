package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by tuckerlocicero on 9/24/15.
 */
public class insideTownController extends configScreens.ControllerSuper {

    @FXML
    private Button leaveTownBtn;
    @FXML
    private Button pubBtn;

    @FXML
    private void buttonHandler(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = null;
        Button source = (Button) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        if (source == leaveTownBtn) {
            root = FXMLLoader.load(getClass().getResource("StandardMap.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (source == pubBtn) {
            root = FXMLLoader.load(getClass().getResource("insidePub.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }



}

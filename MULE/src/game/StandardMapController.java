package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Popup;
import javafx.stage.Stage;
import configScreens.Config2Controller;

import java.io.IOException;

/**
 * Created by tuckerlocicero on 9/23/15.
 */
public class StandardMapController {

    @FXML
    private Button button00, button01, button02, button03, button04, button05, button06, button07, button08, button09;

    @FXML
    private void okayButtonAction(ActionEvent event) throws IOException {
        Stage stage;
        Button source = (Button) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        if (source == okayButton) {
            stage.close();
        }
    }


    public void initialize() throws IOException {
    }

}

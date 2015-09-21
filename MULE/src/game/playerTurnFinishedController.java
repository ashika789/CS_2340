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

import java.io.IOException;

/**
 * Created by ashika ganesh.
 */
public class playerTurnFinishedController {

        @FXML
        private Button popUp1;

        @FXML
        private Label errorLabel;

        @FXML
        private void handleButtonAction(ActionEvent event)
                throws IOException {

            Stage stage;
            Parent root;

            if(event.getSource()==popUp1) {
                stage = new Stage();
                root = FXMLLoader.load(getClass().getResource("FXML2.fxml"));
                stage.setScene(new Scene(root));
                stage.setTitle("My modal window");
                stage.initOwner(popUp1.getScene().getWindow());
                stage.showAndWait();
            }

        }

}

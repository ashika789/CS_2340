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

/**
 * Created by yamininambiar on 9/17/15.
 */
public class PurchasePropertyController {

        @FXML
        private Button okayButton;

        @FXML
        private Label errorLabel;

        @FXML
        private void okayButtonAction(ActionEvent event) throws IOException {
            Stage stage;
            Parent root;
            Button source = (Button) event.getSource();
            stage = (Stage) source.getScene().getWindow();
            if (source == okayButton) {
                root = FXMLLoader.load(getClass().getResource("StandardMap.fxml"));
            } else {
                root = null;
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }


        public void initialize() throws IOException {
        }
    }

}

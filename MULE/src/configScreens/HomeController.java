package configScreens;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.xml.bind.SchemaOutputResolver;
import java.io.IOException;

public class HomeController extends ControllerSuper {

    @FXML
    private Button ruleBtn;
    @FXML
    private Button playBtn;

    @FXML
    private void homeButtonAction(ActionEvent event) {
        try {
            Stage stage;
            Parent root;
            Button source = (Button) event.getSource();
            stage = (Stage) source.getScene().getWindow();
            if (source == playBtn) {
                root = FXMLLoader.load(getClass().getResource("configScreen1.fxml"));
            } else if (source == ruleBtn) {
                root = FXMLLoader.load(getClass().getResource("rulesScreen.fxml"));
            } else {
                root = null;
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("> IOException in HomeController's homeButtonAction()");
        }
    }

    public void initialize() throws IOException {

    }
}

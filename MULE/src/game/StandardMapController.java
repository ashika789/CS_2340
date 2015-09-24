package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import configScreens.Config2Controller;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by tuckerlocicero on 9/23/15.
 */
public class StandardMapController {

    @FXML
    private Button btn00, btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08;
    @FXML
    private Button btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18;
    @FXML
    private Button btn20, btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28;
    @FXML
    private Button btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38;

    int[][] mapOfbtns = new int[5][9]; //initialized to 5x9 grid of 0s, 1 means btn is pressed

    @FXML
    private void buttonHandler(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        Button source = (Button) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        for (int i = 0; i < Config2Controller.gameMap.players.size() * 2; i++) {
            if (source == btn00) {
                //add tile color graphic
                Config2Controller.currentPlayer.addProperty(new Location(0, 0));
                if (i % 2 == 0)//every player picks twice
                Config2Controller.currentPlayer = Config2Controller.gameMap.players.get(Config2Controller.currentPlayer.getPlayerNumber());
                System.out.print(Config2Controller.currentPlayer.name);
            }
        }
    }




    public void initialize() throws IOException {

    }

}

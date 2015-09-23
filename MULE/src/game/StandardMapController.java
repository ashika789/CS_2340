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
import java.util.ArrayList;

/**
 * Created by tuckerlocicero on 9/23/15.
 */
public class StandardMapController {

    @FXML
    private Button button00, button01, button02, button03, button04, button05, button06, button07, button08;
    private Button button10, button11, button12, button13, button14, button15, button16, button17, button18;
    //and so on...

    int[][] mapOfButtons = new int[5][9]; //initialized to 5x9 grid of 0s, 1 means button is pressed

    @FXML
    private void Button00Action(ActionEvent event) throws IOException {

    }




    public void initialize() throws IOException {

    }

}

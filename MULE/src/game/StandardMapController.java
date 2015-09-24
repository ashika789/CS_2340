package game;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import configScreens.Config2Controller;

import javax.swing.text.html.ImageView;
import java.awt.*;
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
    @FXML
    private ImageView button00;

    int[][] mapOfbtns = new int[5][9]; //initialized to 5x9 grid of 0s, 1 means btn is pressed


    @FXML
    private void buttonHandler(ActionEvent event) throws IOException {
        ImageView source = (ImageView) event.getSource();
        if (source.equals(btn00)) {
            System.out.println("this works0");
            Config2Controller.hasSelected = false;
        } 
    }

    @FXML
    private void fileCloseAction(ActionEvent event) throws IOException {
        Platform.exit();
    }

    public void initialize() throws IOException {

    }

}
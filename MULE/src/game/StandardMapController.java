package game;

import javafx.application.Platform;
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
<<<<<<< HEAD
    private void buttonHandler(ActionEvent event) throws IOException {
=======
    private void Button00Action(ActionEvent event) throws IOException {
>>>>>>> origin/master
        Stage stage;
        Parent root;
        Button source = (Button) event.getSource();
        stage = (Stage) source.getScene().getWindow();
<<<<<<< HEAD
        for (int i = 0; i < Config2Controller.gameMap.players.size() * 2; i++) {
            if (source == btn00) {
                //add tile color graphic
                Config2Controller.currentPlayer.addProperty(new Location(0, 0));
                if (i % 2 == 0)//every player picks twice
                Config2Controller.currentPlayer = Config2Controller.gameMap.players.get(Config2Controller.currentPlayer.getPlayerNumber());
                System.out.print(Config2Controller.currentPlayer.name);
            }
        }
=======
        if (source == button00) {
            System.out.println("this works0");
        } else if (source == button01) {
            System.out.println("this works1");
        } else if (source == button02) {
            System.out.println("this works2");
        } else if (source == button03) {
            System.out.println("this works3");
        } else if (source == button04) {
            System.out.println("this works4");
        } else if (source == button05) {
            System.out.println("this works5");
        } else if (source == button06) {
            System.out.println("this works6");
        } else if (source == button07) {
            System.out.println("this works7");
        } else if (source == button08) {
            System.out.println("this works8");
        } else if (source == button10) {
            System.out.println("this works9");
        } else if (source == button11) {
            System.out.println("this works10");
        } else if (source == button12) {
            System.out.println("this works11");
        } else if (source == button13) {
            System.out.println("this works12");
        } else if (source == button14) {
            System.out.println("this works13");
        } else if (source == button15) {
            System.out.println("this works14");
        } else if (source == button16) {
            System.out.println("this works15");
        } else if (source == button17) {
            System.out.println("this works16");
        } else if (source == button18) {
            System.out.println("this works17");
        }

>>>>>>> origin/master
    }

    @FXML
    private void fileCloseAction(ActionEvent event) throws IOException {
        Platform.exit();
    }






    public void initialize() throws IOException {

    }

}

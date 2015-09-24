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
    private Button button00, button01, button02, button03, button04, button05, button06, button07, button08;
    @FXML
    private Button button10, button11, button12, button13, button14, button15, button16, button17, button18;
    @FXML
    private Button button20, button21, button22, button23, button24, button25, button26, button27, button28;
    @FXML
    private Button button30, button31, button32, button33, button34, button35, button36, button37, button38;

    int[][] mapOfbuttons = new int[5][9]; //initialized to 5x9 grid of 0s, 1 means button is pressed



/* This is the logic to loop through the Players to purchase property at the beginning*/
// for (int i = 0; i < Config2Controller.gameMap.players.size() * 2; i++) {
//        if (source == button00) {
//            //add tile color graphic
//            Config2Controller.currentPlayer.addProperty(new Location(0, 0));
//            if (i % 2 == 0) {//every player picks twice
//                Config2Controller.currentPlayer = Config2Controller.gameMap.players.get(Config2Controller.currentPlayer.getPlayerNumber());
//            }
//            System.out.print(Config2Controller.currentPlayer.name);
//        }
//    }

    private void buttonHandler(ActionEvent event) throws IOException {
//        Stage stage;
//        Parent root;
        Button source = (Button) event.getSource();
//        stage = (Stage) source.getScene().getWindow();

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
    }

    @FXML
    private void fileCloseAction(ActionEvent event) throws IOException {
        Platform.exit();
    }






    public void initialize() throws IOException {

    }

}

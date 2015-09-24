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
        Stage stage;
        Parent root;
        Button source = (Button) event.getSource();
        stage = (Stage) source.getScene().getWindow();
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




    public void initialize() throws IOException {

    }

}

package game;

import configScreens.ControllerSuper;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import configScreens.Config2Controller;


import javafx.scene.image.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by tuckerlocicero on 9/23/15.
 */
public class StandardMapController extends ControllerSuper{

    @FXML
    private VBox vbox;
    @FXML
    private Button btn00, btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08;
    @FXML
    private Button btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18;
    @FXML
    private Button btn20, btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28;
    @FXML
    private Button btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38;
    @FXML
    private Button btn40, btn41, btn42, btn43, btn44, btn45, btn46, btn47, btn48;

    @FXML
    private ImageView imageView00;
    @FXML
    private ImageView imageView01;
    @FXML
    private ImageView imageView02;
    @FXML
    private ImageView imageView03;
    @FXML
    private ImageView imageView04;
    @FXML
    private ImageView imageView05;
    @FXML
    private ImageView imageView06;
    @FXML
    private ImageView imageView07;
    @FXML
    private ImageView imageView08;

    @FXML
    private ImageView imageView10;
    @FXML
    private ImageView imageView11;
    @FXML
    private ImageView imageView12;
    @FXML
    private ImageView imageView13;
    @FXML
    private ImageView imageView14;
    @FXML
    private ImageView imageView15;
    @FXML
    private ImageView imageView16;
    @FXML
    private ImageView imageView17;
    @FXML
    private ImageView imageView18;

    @FXML
    private ImageView imageView20;
    @FXML
    private ImageView imageView21;
    @FXML
    private ImageView imageView22;
    @FXML
    private ImageView imageView23;
    @FXML
    private ImageView imageView24;
    @FXML
    private ImageView imageView25;
    @FXML
    private ImageView imageView26;
    @FXML
    private ImageView imageView27;
    @FXML
    private ImageView imageView28;

    @FXML
    private ImageView imageView30;
    @FXML
    private ImageView imageView31;
    @FXML
    private ImageView imageView32;
    @FXML
    private ImageView imageView33;
    @FXML
    private ImageView imageView34;
    @FXML
    private ImageView imageView35;
    @FXML
    private ImageView imageView36;
    @FXML
    private ImageView imageView37;
    @FXML
    private ImageView imageView38;

    @FXML
    private ImageView imageView40;
    @FXML
    private ImageView imageView41;
    @FXML
    private ImageView imageView42;
    @FXML
    private ImageView imageView43;
    @FXML
    private ImageView imageView44;
    @FXML
    private ImageView imageView45;
    @FXML
    private ImageView imageView46;
    @FXML
    private ImageView imageView47;
    @FXML
    private ImageView imageView48;


    @FXML
    private ImageView imageView50;
    @FXML
    private ImageView imageView51;
    @FXML
    private ImageView imageView52;
    @FXML
    private ImageView imageView53;
    @FXML
    private ImageView imageView54;
    @FXML
    private ImageView imageView55;
    @FXML
    private ImageView imageView56;
    @FXML
    private ImageView imageView57;
    @FXML
    private ImageView imageView58;







    @FXML
    private ImageView button00;

    int[][] mapOfbtns = new int[5][9]; //initialized to 5x9 grid of 0s, 1 means btn is pressed
    int c = 0;


    @FXML
    private void buttonHandler(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = null;
        Button source = (Button) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        if (source.equals(btn00) && mapOfbtns[0][0] == 0) {
            driver.selectProperty(new Location(0,0), btn00, imageView00);
        } else if (source.equals(btn01) && mapOfbtns[1][0] == 0) {
            driver.selectProperty(new Location(0,1), btn01, imageView01);
        } else if (source.equals(btn02) && mapOfbtns[2][0] == 0) {
            driver.selectProperty(new Location(0,2), btn02, imageView02);
        } else if (source.equals(btn03) && mapOfbtns[3][0] == 0) {
            driver.selectProperty(new Location(0,3), btn03, imageView03);
        } else if (source.equals(btn04) && mapOfbtns[4][0] == 0) {
            driver.selectProperty(new Location(0,4), btn04, imageView04);
        } else if (source.equals(btn05) && mapOfbtns[5][0] == 0) {
            driver.selectProperty(new Location(0,5), btn05, imageView05);
        } else if (source.equals(btn06) && mapOfbtns[6][0] == 0) {
            driver.selectProperty(new Location(0,6), btn06, imageView06);
        } else if (source.equals(btn07) && mapOfbtns[7][0] == 0) {
            driver.selectProperty(new Location(0,7), btn07, imageView07);
        } else if (source.equals(btn08) && mapOfbtns[8][0] == 0) {
            driver.selectProperty(new Location(0,8), btn08, imageView08);
        } else if (source.equals(btn10) && mapOfbtns[0][1] == 0) {
            driver.selectProperty(new Location(1,0), btn10, imageView10);
        } else if (source.equals(btn11) && mapOfbtns[1][1] == 0) {
            driver.selectProperty(new Location(1,1), btn11, imageView11);
        } else if (source.equals(btn12) && mapOfbtns[2][1] == 0) {
            driver.selectProperty(new Location(1,2), btn12, imageView12);
        } else if (source.equals(btn13) && mapOfbtns[3][1] == 0) {
            driver.selectProperty(new Location(1,3), btn13, imageView13);
        } else if (source.equals(btn14) && mapOfbtns[4][1] == 0) {
            driver.selectProperty(new Location(1,4), btn14, imageView14);
        } else if (source.equals(btn15) && mapOfbtns[5][1] == 0) {
            driver.selectProperty(new Location(1,5), btn15, imageView15);
        } else if (source.equals(btn16) && mapOfbtns[6][1] == 0) {
            driver.selectProperty(new Location(1,6), btn16, imageView16);
        } else if (source.equals(btn17) && mapOfbtns[7][1] == 0) {
            driver.selectProperty(new Location(1,7), btn17, imageView17);
        } else if (source.equals(btn18) && mapOfbtns[8][1] == 0) {
            driver.selectProperty(new Location(1,8), btn18, imageView18);
        } else if (source.equals(btn20) && mapOfbtns[0][2] == 0) {
            driver.selectProperty(new Location(2,0), btn20, imageView20);
        } else if (source.equals(btn21) && mapOfbtns[1][2] == 0) {
            driver.selectProperty(new Location(2,1), btn21, imageView21);
        } else if (source.equals(btn22) && mapOfbtns[2][2] == 0) {
            driver.selectProperty(new Location(2,2), btn22, imageView22);
        } else if (source.equals(btn23) && mapOfbtns[3][2] == 0) {
            driver.selectProperty(new Location(2,3), btn23, imageView23);
        } else if (source.equals(btn24) && mapOfbtns[4][2] == 0) {
            root = FXMLLoader.load(getClass().getResource("insideTown.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (source.equals(btn25) && mapOfbtns[5][2] == 0) {
            driver.selectProperty(new Location(2,5), btn25, imageView25);
        } else if (source.equals(btn26) && mapOfbtns[6][2] == 0) {
            driver.selectProperty(new Location(2,6), btn26, imageView26);
        } else if (source.equals(btn27) && mapOfbtns[7][2] == 0) {
            driver.selectProperty(new Location(2,7), btn27, imageView27);
        } else if (source.equals(btn28) && mapOfbtns[8][2] == 0) {
            driver.selectProperty(new Location(2,8), btn28, imageView28);
        } else if (source.equals(btn30) && mapOfbtns[0][3] == 0) {
            driver.selectProperty(new Location(3,0), btn30, imageView30);
        } else if (source.equals(btn31) && mapOfbtns[1][3] == 0) {
            driver.selectProperty(new Location(3,1), btn31, imageView31);
        } else if (source.equals(btn32) && mapOfbtns[2][3] == 0) {
            driver.selectProperty(new Location(3,2), btn32, imageView32);
        } else if (source.equals(btn33) && mapOfbtns[3][3] == 0) {
            driver.selectProperty(new Location(3,3), btn33, imageView33);
        } else if (source.equals(btn34) && mapOfbtns[4][3] == 0) {
            driver.selectProperty(new Location(3,4), btn34, imageView34);
        } else if (source.equals(btn35) && mapOfbtns[5][3] == 0) {
            driver.selectProperty(new Location(3,5), btn35, imageView35);
        } else if (source.equals(btn36) && mapOfbtns[6][3] == 0) {
            driver.selectProperty(new Location(3,6), btn36, imageView36);
        } else if (source.equals(btn37) && mapOfbtns[7][3] == 0) {
            driver.selectProperty(new Location(3,7), btn37, imageView37);
        } else if (source.equals(btn38) && mapOfbtns[8][3] == 0) {
            driver.selectProperty(new Location(3,8), btn38, imageView38);
        } else if (source.equals(btn40) && mapOfbtns[0][4] == 0) {
            driver.selectProperty(new Location(4,0), btn40, imageView40);
        } else if (source.equals(btn41) && mapOfbtns[1][4] == 0) {
            driver.selectProperty(new Location(4,1), btn41, imageView41);
        } else if (source.equals(btn42) && mapOfbtns[2][4] == 0) {
            driver.selectProperty(new Location(2,4), btn24, imageView42);
        } else if (source.equals(btn43) && mapOfbtns[3][4] == 0) {
            driver.selectProperty(new Location(4,3), btn43, imageView43);
        } else if (source.equals(btn44) && mapOfbtns[4][4] == 0) {
            driver.selectProperty(new Location(4,4), btn44, imageView44);
        } else if (source.equals(btn45) && mapOfbtns[5][4] == 0) {
            driver.selectProperty(new Location(4,5), btn45, imageView45);
        } else if (source.equals(btn46) && mapOfbtns[6][4] == 0) {
            driver.selectProperty(new Location(4,6), btn46, imageView46);
        } else if (source.equals(btn47) && mapOfbtns[7][4] == 0) {
            driver.selectProperty(new Location(4,7), btn47, imageView47);
        } else if (source.equals(btn48) && mapOfbtns[8][4] == 0) {
            driver.selectProperty(new Location(4,8), btn48, imageView48);
        }
    }

    @FXML
    private void fileCloseAction(ActionEvent event) throws IOException {
        Platform.exit();
    }

    public void initialize() throws IOException {

    }

}
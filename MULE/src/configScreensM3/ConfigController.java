package configScreensM3;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class ConfigController {

    @FXML
    private Button playBtn, playScrnNext, playScrnBack, gameStart, playerConfigBack;

    @FXML
    private RadioButton easyRadio, MediumRadio, hardRadio;
    @FXML
    private RadioButton standardMapRadio, randomMapRadio;

    @FXML
    private ComboBox<String> combo1human, combo1race, combo2human, combo2race, combo3human, combo3race, combo4human, combo4race;

    ObservableList<String> humanBox = FXCollections.observableArrayList("Human", "AI", "Not playing");
    ObservableList<String> raceBox = FXCollections.observableArrayList("Human", "Flapper", "Bonzoid", "Ugaite", "Buzzite");

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        Button source = (Button) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        if (source == playBtn || source == playerConfigBack) {
            root = FXMLLoader.load(getClass().getResource("playScreen.fxml"));
        } else if (source == playScrnNext) {
            root = FXMLLoader.load(getClass().getResource("playerConfigScreen.fxml"));
        } else if (source == playScrnBack) {
            root = FXMLLoader.load(getClass().getResource("home.fxml"));
        } else {
            root = FXMLLoader.load(getClass().getResource("gamePlaceHolderScreen.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//    @FXML
//    private void handleComboBoxes(ActionEvent event) throws IOException {
//        System.out.println("handling combo box");
//        ComboBox<String> source = (ComboBox) event.getSource();
//        if (source == combo1human) {
//            combo1human.setItems(humanBox);
//        }
//    }

//    @FXML  //Trying to deal with the radio buttons on playerConfigScreen. Not working
//    private void handleDifficultyRadio(ActionEvent event) throws IOException {
//        RadioButton source = (RadioButton) event.getSource();
//        RadioButton[] radios = {easyRadio, mediumRadio, hardRadio};
//        for (RadioButton x : radios) {
//            if (x != source) {
//                x.fire();
//            }
//        }
//    }

//    @FXML needs to deal with the map radios
//    private void handleMapRadio(ActionEvent event) throws IOException {
//
//    }

    public void initialize() throws IOException {
        //combo1human.setItems(humanBox);  //trying to set up the combobox on the playerConfigScreen, not working.
        //combo1race.setItems(raceBox);
    }
}

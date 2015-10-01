package game;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.util.TimerTask;

/**
 * Created by AshikaGanesh on 10/1/15.
 */
public class Timer {


    @FXML
    private int countDown = 50;
    @FXML
    private Text time;
    @FXML
    java.util.Timer timer = new java.util.Timer();
    @FXML
    public void startCountDown(ActionEvent event) {

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        time.setText("Time left:" + countDown);
                        countDown--;
                        if (countDown <= 0) {
                            timer.cancel();
                            time.setText("YOUR TURN IS OVER!");
                        }

                    }
                });
            }
        }, 1000, 5000);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author birke
 */
public class TimeExpired extends TimerTask {
    @Override
    public void run() {
        Platform.runLater(() -> {
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            VBox dialogVbox = new VBox(20);
            Button okButton = new Button("Close");
            okButton.setOnAction((value) -> System.exit(0));
            Text loserText = new Text("You lost the game, you'll forever be lost in the SDU Maze and you'll never get to met the hot nurse");
            Text score = new Text("Thank you for playing SCORE: " + (System.currentTimeMillis() - TimerScore.getTime()) / 1000L);
            dialogVbox.getChildren().addAll(loserText, score);
            Scene dialogSence = new Scene(dialogVbox);
            dialog.setScene(dialogSence);
            dialog.setAlwaysOnTop(true);
            dialog.setResizable(false);
            dialog.show();
            dialog.setOnCloseRequest((value) -> System.exit(0));
            dialog.setOnHiding((value) -> System.exit(0));
        });
    }
}

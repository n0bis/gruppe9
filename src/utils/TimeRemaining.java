/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import controllers.SceneManager;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author birke
 */
public class TimeRemaining extends TimerTask  {

    @Override
    public void run() {
        Platform.runLater(() -> {
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            VBox dialogVbox = new VBox(20);
            Button okButton = new Button("Close");
            okButton.setOnAction((value) -> dialog.close());
            ImageView smsImage = new ImageView(new Image(getClass().getResourceAsStream("/images/sms.png")));
            dialogVbox.getChildren().addAll(smsImage);
            Scene dialogSence = new Scene(dialogVbox);
            dialog.setScene(dialogSence);
            dialog.setAlwaysOnTop(true);
            dialog.setResizable(false);
            dialog.show();
        });
    }
}

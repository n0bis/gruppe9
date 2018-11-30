/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import controllers.SceneManager;
import java.io.IOException;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static world.Game.player;

/**
 *
 * @author birke
 */
public class TimeExpired extends TimerTask {
    @Override
    public void run() {
        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/views/YouLost.fxml")
                );
                Parent root = loader.load();
                Button closeButton = (Button)loader.getNamespace().get("exitId");
                closeButton.setOnMouseClicked((mouseEvent) -> System.exit(0));
                Label scoreText = (Label)loader.getNamespace().get("scoreId");
                double score = (System.currentTimeMillis() - TimerScore.getTime()) / 1000L;
                String text = scoreText.getText().replaceFirst("0", "" + score);
                scoreText.setText(text);
                SceneManager.getMain().setCenter(root);
                SceneManager.getMain().setBottom(null);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}

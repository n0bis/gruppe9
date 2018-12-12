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
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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

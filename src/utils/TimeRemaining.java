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
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import static world.Game.player;
import worldofzuul.StartGame;

/**
 *
 * @author birke
 */
public class TimeRemaining extends TimerTask  {

    @Override
    public void run() {
        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/views/TimeRemaining.fxml")
                );
                Parent root = loader.load();
                Button closeButton = (Button)loader.getNamespace().get("closeButton");
                closeButton.setOnMouseClicked((mouseEvent) -> SceneManager.getMain().getChildren().remove(root));
                FlowPane flowPane = (FlowPane)loader.getNamespace().get("flowPane");
                flowPane.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("/images/smartphone.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
                TextArea smsTextbox = (TextArea)loader.getNamespace().get("smsTextbox");
                String text = smsTextbox.getText().replaceFirst("Player", StartGame.playerName);
                smsTextbox.setText(text);
                root.setLayoutX(300);
                root.setLayoutY(60);
                SceneManager.getMain().getChildren().add(root);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}

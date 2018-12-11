/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author madsfalken
 */
public class SpookyController extends TimerTask implements Initializable {
    
    private MediaPlayer mediaPlayer;

    @FXML
    private FlowPane flowPane;
    @FXML
    private Label labelTitle;
    @FXML
    private TextArea smsTextbox;
    @FXML
    private Button closeButton;
    @FXML
    private AnchorPane rootId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        flowPane.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("/images/menu/smartphone.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        mediaPlayer = new MediaPlayer(new Media(getClass().getResource("/sounds/creepywoman.mp3").toExternalForm()));
        mediaPlayer.setVolume(1);
        mediaPlayer.play();
        mediaPlayer.setOnEndOfMedia(() -> closeButton.setOpacity(1));
    }    

    @FXML
    private void closeButtonClicked(MouseEvent event) {
        if(closeButton.getOpacity() == 0.0) {
            return;
        }     
        SceneManager.getMain().getChildren().removeAll(rootId, flowPane, labelTitle, smsTextbox, closeButton);
    }
    
     @Override
    public void run() {
        Platform.runLater(() -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Spooky.fxml"));
            try {
                Node main = SceneManager.getMain();
                Node node = loader.load();
                node.setLayoutX(300);
                node.setLayoutY(150);
                SceneManager.getMain().getChildren().add(node);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}

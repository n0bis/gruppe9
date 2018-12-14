/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import worldofzuul.StartGame;

/**
 * FXML Controller class
 *
 * @author madsfalken
 */
public class IntroController implements Initializable {
    
    StartGame startGame = new StartGame();
    private MediaPlayer mediaPlayer;
    
    @FXML
    private MediaView mediaView;
    @FXML
    private AnchorPane anchorId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mediaView.fitHeightProperty().bind(anchorId.heightProperty());
        mediaView.fitWidthProperty().bind(anchorId.widthProperty());
        mediaPlayer = new MediaPlayer(new Media(getClass().getResource("/videos/intro.mp4").toExternalForm()));
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setVolume(1);
        mediaPlayer.play();
        mediaPlayer.setOnEndOfMedia(() -> startGame.third());
    }    
    
}

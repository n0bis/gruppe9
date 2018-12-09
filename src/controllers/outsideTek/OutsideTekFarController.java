/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.outsideTek;


import controllers.IPlaySound;
import controllers.MenuControllerInjection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import utils.FadeAnimation;
import worldofzuul.StartGame;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class OutsideTekFarController extends MenuControllerInjection implements Initializable, IPlaySound {
    
    StartGame startGame = new StartGame();
    
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView arrowUpId;
    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView themeIconView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backgroundId.fitHeightProperty().bind(anchorId.heightProperty());
        backgroundId.fitWidthProperty().bind(anchorId.widthProperty());
        themeIconView.setImage(new Image(getClass().getResourceAsStream("/images/" + startGame.getImageSelector() + "/themeIcon.png")));
        // TODO
    }    

    @FXML
    private void arrowUpClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "outsideTekClose");
    }
    
}

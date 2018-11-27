/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import utils.FadeAnimation;
import command.Command;
import command.CommandWords;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
// import static worldofzuul.StartGame.game;

/**
 * FXML Controller class
 *
 * @author madsfalken
 */
public class HallController extends MenuControllerInjection implements Initializable {

    @FXML
    private ImageView hallId;
    @FXML
    private ImageView arrowRightId;
    @FXML
    private AnchorPane rootId;
    @FXML
    private ImageView arrowLeftId;
    @FXML
    private ImageView skeletonId;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hallId.setImage(new Image(getClass().getResourceAsStream("/images/hall.jpg")));
        hallId.fitHeightProperty().bind(rootId.heightProperty());
        hallId.fitWidthProperty().bind(rootId.widthProperty());
        arrowRightId.setImage(new Image(getClass().getResourceAsStream("/images/arrow-right.png")));
        arrowLeftId.setImage(new Image(getClass().getResourceAsStream("/images/arrow-left.png")));
    }    

    @FXML
    private void arrowRightClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(rootId, "WorldOfZuulGUI");
    }

    @FXML
    private void arrowLeftClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(rootId, "ChildRoom");
    }

    @FXML
    private void helloBlicked(MouseEvent event) {
        menuController.SpeechText("Hello again!");
    }
    
}

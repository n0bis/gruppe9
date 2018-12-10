/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.GydehuttenSouth;


import controllers.MenuControllerInjection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import utils.FadeAnimation;
import static world.Game.player;
import static world.Game.pokefluteItem;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class Mainhall2Controller extends MenuControllerInjection implements Initializable {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView arrowDownId;
    @FXML
    private ImageView arrowForwardId;
    @FXML
    private ImageView arrowRightId;
    @FXML
    private ImageView snorlax;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backgroundId.fitHeightProperty().bind(anchorId.heightProperty());
        backgroundId.fitWidthProperty().bind(anchorId.widthProperty());
        // TODO
    }    

    @FXML
    private void arrowDownClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "mainhall1");
    }

    @FXML
    private void arrowForwardClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "mainhall");
    }

    @FXML
    private void arrowRightClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "U55");
    }

    @FXML
    private void snorlaxClicked(MouseEvent event) {
        if(!player.hasItem(pokefluteItem)) {
        menuController.SpeechText("You need an item to pass here");
    } else {
        anchorId.getChildren().remove(snorlax);
        }
    }
}

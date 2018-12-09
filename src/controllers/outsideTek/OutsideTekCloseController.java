/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.outsideTek;


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
import static world.Game.studyCard;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class OutsideTekCloseController extends MenuControllerInjection implements Initializable {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView arrowUp;
    @FXML
    private ImageView arrowUp1;

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
    private void ArrowUpClicked(MouseEvent event) {
            if (player.hasItem(studyCard))
                FadeAnimation.fadeOutTransition(anchorId, "tekHall");
            else {
                    menuController.SpeechText("You need to pick up the studycard from earlier to enter the University Of Southern");
                        }
            }
    @FXML
    private void arrowBackClicked(MouseEvent event) {
                FadeAnimation.fadeOutTransition(anchorId, "outsideTekFar");
    }
}


    

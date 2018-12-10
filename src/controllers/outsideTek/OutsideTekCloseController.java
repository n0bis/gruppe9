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
import static world.Game.scissor;
import static world.Game.studentID;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class OutsideTekCloseController extends MenuControllerInjection implements Initializable {
    
    private Boolean isDoorLocked = true;
    
    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView arrowUp;
    @FXML
    private ImageView arrowUp1;
    @FXML
    private ImageView studentIdScanner;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backgroundId.fitHeightProperty().bind(anchorId.heightProperty());
        backgroundId.fitWidthProperty().bind(anchorId.widthProperty());
        arrowUp.setOpacity(0.5);
        // TODO
    }    

    @FXML
    private void ArrowUpClicked(MouseEvent event) {
         if(isDoorLocked) {
            menuController.SpeechText("The door to the University Of Southern is locked. Have you scanned your student ID?");
        } else {
            FadeAnimation.fadeOutTransition(anchorId, "tekHall");
        }
    }

    @FXML
    private void arrowBackClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "outsideTekFar");
    }

    @FXML
    private void studentIdScannerClicked(MouseEvent event) {
         if(!player.hasItem(studentID)) {
            menuController.SpeechText("You need a student ID to get in to the University Of Southern");
        } else {
            isDoorLocked = false; 
            arrowUp.setOpacity(1);
            menuController.SpeechText("The door is unlocked, you may can now enter the University Of Southern.");
        }
    }
    
}

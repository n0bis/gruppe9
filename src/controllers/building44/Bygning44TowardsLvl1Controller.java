/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.building44;


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
import static world.Game.scissorItem;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class Bygning44TowardsLvl1Controller extends MenuControllerInjection implements Initializable {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView arrowLeftId;
    @FXML
    private ImageView arrowUpId;
    @FXML
    private ImageView arrowBackId;
    @FXML
    private ImageView lockedTape;
    
    public boolean isLocked = true;

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
    private void arrowLeftClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "bygning44Lvl1");
    }

    @FXML
    private void arrowUpClicked(MouseEvent event) {
        if(!isLocked) {
        FadeAnimation.fadeOutTransition(anchorId, "towardsMainhall2");
        }
    }

    @FXML
    private void arrowBackClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "bygning44");
    }

    @FXML
    private void lockedTapeClicked(MouseEvent event) {
        if(player.hasItem(scissorItem)) {
            anchorId.getChildren().remove(lockedTape);
            isLocked = false;
        }
    }
    
}

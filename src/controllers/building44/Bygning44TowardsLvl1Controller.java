/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.building44;


import controllers.INavigate;
import controllers.IPlaySound;
import controllers.MenuControllerInjection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import utils.FadeAnimation;
import utils.SoundMapper;
import static world.Game.player;
import static world.Game.scissorItem;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class Bygning44TowardsLvl1Controller extends MenuControllerInjection implements Initializable, IPlaySound, INavigate {

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
    public void arrowLeftClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "bygning44Lvl1");
    }

    @FXML
    public void arrowUpClicked(MouseEvent event) {
        if(!isLocked) {
            FadeAnimation.fadeOutTransition(anchorId, "towardsMainhall2");
        }
    }

    @FXML
    public void arrowBackClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "bygning44");
    }

    @Override
    public SoundMapper mapSound() {
        return new SoundMapper(0.6, "/sounds/spooky.mp3");
    }

    @Override
    public void arrowRightClicked(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @FXML
    private void lockedTapeClicked(MouseEvent event) {
        if(player.hasItem(scissorItem)) {
            anchorId.getChildren().remove(lockedTape);
            isLocked = false;
        }
    }
    
}

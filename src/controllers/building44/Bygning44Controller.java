/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.building44;


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

/**
 * FXML Controller class
 *
 * @author morte
 */
public class Bygning44Controller extends MenuControllerInjection implements Initializable, IPlaySound {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView arrowUpId;
    @FXML
    private ImageView arrowUpId1;
    @FXML
    private ImageView arrowBackId;

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
    private void arrowUpClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "bygning44Lvl3");
    }

    @FXML
    private void arrowUpClicked2(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "bygning44TowardsLvl1");
    }

    @FXML
    private void arrowBackClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "towardsByg442");
    }

    @Override
    public SoundMapper mapSound() {
        return new SoundMapper(0.2, "/sounds/hallnoise.mp3");
    }
    
}

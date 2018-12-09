/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.building44;


import controllers.IPlaySound;
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
public class Bygning44Lvl1Controller implements Initializable, IPlaySound {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView arrowBackId;
    @FXML
    private ImageView backgroundId;

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
    private void arrowBackClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "bygning44TowardsLvl1");
    }

    @Override
    public SoundMapper mapSound() {
        return new SoundMapper(0.2, "/sounds/hallnoise.mp3");
    }
    
}

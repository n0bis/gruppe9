/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Vangene;


import controllers.INavigate;
import controllers.IPlaySound;
import controllers.MagicInjection;
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
public class OutsideU133Controller extends MagicInjection implements Initializable, IPlaySound, INavigate {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView arrowLeftId;
    @FXML
    private ImageView arrowForwardId;
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
    public void arrowLeftClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "towardsMainhall1");
    }

    @FXML
    public void arrowUpClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "U133");
    }

    @Override
    public SoundMapper mapSound() {
        return new SoundMapper("/sounds/spooky.mp3");
    }

    @Override
    public void arrowBackClicked(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void arrowRightClicked(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

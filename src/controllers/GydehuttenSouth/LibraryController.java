/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.GydehuttenSouth;

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

/**
 * FXML Controller class
 *
 * @author madsfalken
 */
public class LibraryController extends MenuControllerInjection implements Initializable, IPlaySound, INavigate {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView arrowBackId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backgroundId.fitHeightProperty().bind(anchorId.heightProperty());
        backgroundId.fitWidthProperty().bind(anchorId.widthProperty());
    }    

    @FXML
    public void arrowBackClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "LibraryEntrance");
    }

    @Override
    public SoundMapper mapSound() {
        return new SoundMapper("/sounds/spooky.mp3");
    }

    @Override
    public void arrowUpClicked(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void arrowRightClicked(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void arrowLeftClicked(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

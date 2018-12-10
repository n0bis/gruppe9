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
 * @author morte
 */
public class MainhallRightOrLeftController extends MenuControllerInjection implements Initializable, IPlaySound, INavigate {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView leftArrowId;
    @FXML
    private ImageView arrowRightId;
    @FXML
    private ImageView arrowDownId;

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
        FadeAnimation.fadeOutTransition(anchorId, "towardsU45");
    }

    @FXML
    public void arrowRightClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "mainhall1");
    }

    @FXML
    public void arrowBackClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "towardsMainhall3");
    }

    @Override
    public SoundMapper mapSound() {
        return new SoundMapper("/sounds/hallnoise.mp3");
    }

    @Override
    public void arrowUpClicked(MouseEvent event) {
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Stenten;


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
import world.Game;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class NotMainhallController extends MenuControllerInjection implements Initializable, IPlaySound, INavigate {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView arrowRightId;
    @FXML
    private ImageView arrowLeftId;
    @FXML
    private ImageView arrowBackId;
    @FXML
    private ImageView backgroundId;
    
    Game game = new Game();

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
    public void arrowRightClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "entranceU1");
    }

    @FXML
    public void arrowLeftClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "notMainhall2");
    }

    @FXML
    public void arrowBackClicked(MouseEvent event) {
        if(!game.isStentenLocked) {
        FadeAnimation.fadeOutTransition(anchorId, "towardsU1");
        } else {
            menuController.SpeechText("You need to complete the doctors quest before he'll let you back");
        }
    }

    @Override
    public SoundMapper mapSound() {
        return new SoundMapper("/sounds/spooky.mp3");
    }

    @Override
    public void arrowUpClicked(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

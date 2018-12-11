/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.mainEntrance;


import controllers.INavigate;
import controllers.IPlaySound;
import controllers.MenuControllerInjection;
import static controllers.QuizController.hasAnswered;
import static controllers.QuizController.isQuizTime;
import controllers.SceneManager;
import controllers.outsideTek.OutsideTekFarController;
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
public class TorvetController extends MenuControllerInjection implements Initializable, IPlaySound, INavigate {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView arrowForwardId;
    @FXML
    private ImageView arrowGetCoffee;
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
    private void arrowForwardClicked(MouseEvent event) {
        if (hasAnswered == true ) {
          FadeAnimation.fadeOutTransition(anchorId, "torvet2");
        }
    }

    @FXML
    private void arrowGetCoffeeClicked(MouseEvent event) {
        if (hasAnswered == true) {
            FadeAnimation.fadeOutTransition(anchorId, "Coffee");
        }
    }
    public void arrowUpClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "torvet2");
    }

    @FXML
    public void arrowRightClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "Coffee");
    }

    @Override
    public void arrowBackClicked(MouseEvent event) {
        if (hasAnswered == true) {
            FadeAnimation.fadeOutTransition(anchorId, "entranceToTorvet");
        }
    }

    @Override
    public SoundMapper mapSound() {
        return new SoundMapper("/sounds/spooky.mp3");
    }

    @Override
    public void arrowLeftClicked(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

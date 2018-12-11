/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Krogene;


import controllers.INavigate;
import controllers.IPlaySound;
import controllers.MenuControllerInjection;
import static controllers.QuizController.isQuizTime;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static missions.QuestList.Twin1Quest;
import utils.FadeAnimation;
import utils.SoundMapper;
import static world.Game.creepyBear;
import static world.Game.player;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class CommunityAreaU140Controller extends MenuControllerInjection implements Initializable, IPlaySound, INavigate {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView arrowForwardId;
    @FXML
    private ImageView arrowBackId;
    @FXML
    private ImageView creepyBearId;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backgroundId.fitHeightProperty().bind(anchorId.heightProperty());
        backgroundId.fitWidthProperty().bind(anchorId.widthProperty());
        creepyBearId.setImage(new Image(getClass().getResourceAsStream("/images/items/Bamse.png")));
        // TODO
    }    

    @FXML
    public void arrowUpClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "entranceU140");
    }

    @FXML
    public void arrowBackClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "modU140");
    }
    
    @FXML
    private void creepyBearClicked(MouseEvent event) {
        creepyBearId.setImage(null);
        player.addItem(creepyBear);
        if (player.hasQuest(Twin1Quest)) {
            menuController.SpeechText("You found the first born twin's creepy bear! Now you can safely deliver it to her.");
        } else {menuController.SpeechText("Congrats you found a creepy bear");
        }
}

    @Override
    public SoundMapper mapSound() {
        return new SoundMapper("/sounds/spooky.mp3");
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



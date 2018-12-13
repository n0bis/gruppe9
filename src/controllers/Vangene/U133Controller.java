/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Vangene;


import controllers.INavigate;
import controllers.IPlaySound;
import controllers.MenuControllerInjection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static missions.QuestList.Twin2Quest;
import utils.FadeAnimation;
import utils.SoundMapper;
import static world.Game.creepyDoll;
import static world.Game.player;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class U133Controller extends MenuControllerInjection implements Initializable, IPlaySound, INavigate {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView arrowBackId;
    @FXML
    private ImageView creepyDollId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backgroundId.fitHeightProperty().bind(anchorId.heightProperty());
        backgroundId.fitWidthProperty().bind(anchorId.widthProperty());
        creepyDollId.setImage(new Image(getClass().getResourceAsStream("/images/items/creepyDoll.png")));
        // TODO
    }    

    @FXML
    public void arrowBackClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "outsideU133");
    }
    
    @FXML
    private void creepyDollClicked(MouseEvent event) {
        creepyDollId.setImage(null);
        player.addItem(creepyDoll);
        if (player.hasQuest(Twin2Quest)) {
            menuController.SpeechText("You found the last born twin's creepy doll! Now you can safely deliver it to her.");
        } else {menuController.SpeechText("Congrats you found a creepy doll");
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

    @Override
    public void arrowRightClicked(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void arrowLeftClicked(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

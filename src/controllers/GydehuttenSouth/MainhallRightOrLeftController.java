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
import static missions.QuestList.Twin1Quest;
import static missions.QuestList.Twin2Quest;
import utils.FadeAnimation;
import utils.SoundMapper;
import static world.Game.creepyBear;
import static world.Game.player;

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
    @FXML
    private ImageView arrowUp;
    @FXML
    private ImageView Twin1;

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
        return new SoundMapper("/sounds/spooky.mp3");
    }

    @FXML
    public void arrowUpClicked(MouseEvent event) {
        if (Twin1Quest.isQuestDone() && Twin2Quest.isQuestDone()) {
            FadeAnimation.fadeOutTransition(anchorId, "backToMainhall");
        } else if (!Twin2Quest.isQuestDone() && Twin1Quest.isQuestDone()) {
            menuController.SpeechText("Help my twin sister find her doll!");
        } else if (Twin2Quest.isQuestDone() && !Twin1Quest.isQuestDone()) {
            menuController.SpeechText("If you find my bear I'll let you pass. I'll give you a hint, walk past krogene");
        } else {
            menuController.SpeechText("You shall not pass!");
        }
    }    
    
    @FXML
    private void Twin1Clicked(MouseEvent event) {
        if(Twin1Quest.isQuestDone()) {
            menuController.SpeechText(Twin1Quest.getQuestDone());
        } else if (player.hasQuest(Twin1Quest) && !player.hasItem(creepyBear)) {
            menuController.SpeechText(Twin1Quest.getQuestInProgress());
        } else if (player.hasQuest(Twin1Quest) && player.hasItem(creepyBear)) {
            menuController.SpeechText(Twin1Quest.getQuestDone());
            Twin1Quest.setIsQuestDone(true);
        } else if (!player.hasQuest(Twin1Quest) && !Twin1Quest.isQuestDone()) {
            menuController.SpeechText(Twin1Quest.getQuestDescription());
            player.addQuest(Twin1Quest);
        }
    }
    
}

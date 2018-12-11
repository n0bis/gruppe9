/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.GydehuttenSouth;


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
import static world.Game.CreepyDoll;
import static world.Game.TeddyBear;
import static world.Game.player;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class MainhallController extends MenuControllerInjection implements Initializable {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView arrowLeftId;
    @FXML
    private ImageView arrowRightId;
    @FXML
    private ImageView arrowForwardId;
    @FXML
    private ImageView arrowBackId;
    @FXML
    private ImageView Twin2;

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
    private void arrowRightClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "modU140");
    }

    @FXML
    private void arrowForwardClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "mainhall3");
    }

    @FXML
    private void arrowBackClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "mainhall2");
    }
    
    @FXML
    private void arrowLeftClicked(MouseEvent event) {
        if (Twin1Quest.isQuestDone() && Twin2Quest.isQuestDone()) {
            FadeAnimation.fadeOutTransition(anchorId, "towardsU1");
        } else if (!Twin2Quest.isQuestDone() && Twin1Quest.isQuestDone()) {
            menuController.SpeechText("Find my doll!!");
        } else if (Twin2Quest.isQuestDone() && !Twin1Quest.isQuestDone()) {
            menuController.SpeechText("Help my twin sister find her teddy bear!");
        } else {
            menuController.SpeechText("You shall not pass!");
        }
    }    
    
    @FXML
    private void Twin2Clicked(MouseEvent event) {
        if(Twin2Quest.isQuestDone()) {
            menuController.SpeechText(Twin2Quest.getQuestDone());
        } else if (player.hasQuest(Twin2Quest) && !player.hasItem(CreepyDoll)) {
            menuController.SpeechText(Twin2Quest.getQuestInProgress());
        } else if (player.hasQuest(Twin2Quest) && player.hasItem(CreepyDoll)) {
            menuController.SpeechText(Twin2Quest.getQuestDone());
            Twin2Quest.setIsQuestDone(true);
        } else if (!player.hasQuest(Twin2Quest) && !Twin2Quest.isQuestDone()) {
            menuController.SpeechText(Twin2Quest.getQuestDescription());
            player.addQuest(Twin2Quest);
        }
    }
    
}

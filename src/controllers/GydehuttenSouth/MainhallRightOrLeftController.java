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
import utils.FadeAnimation;
import static world.Game.TeddyBear;
import static world.Game.player;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class MainhallRightOrLeftController extends MenuControllerInjection implements Initializable {

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
    private void arrowLeftClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "towardsU45");
    }

    @FXML
    private void arrowRightClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "mainhall1");
    }

    @FXML
    private void arrowDownClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "towardsMainhall3");
    }

    @FXML
    private void arrowUpClicked(MouseEvent event) {
        if (Twin1Quest.isQuestDone() == true) {
            FadeAnimation.fadeOutTransition(anchorId, "backToMainhall");
        } else {
            menuController.SpeechText(Twin1Quest.getQuestInProgress());
        }
    }    
    
    @FXML
    private void Twin1Clicked(MouseEvent event) {
        if(Twin1Quest.isQuestDone()) {
            menuController.SpeechText(Twin1Quest.getQuestDone());
        } else if (player.hasQuest(Twin1Quest) && !player.hasItem(TeddyBear)) {
            menuController.SpeechText(Twin1Quest.getQuestInProgress());
        } else if (player.hasQuest(Twin1Quest) && player.hasItem(TeddyBear)) {
            menuController.SpeechText(Twin1Quest.getQuestDone());
            Twin1Quest.setIsQuestDone(true);
        } else if (!player.hasQuest(Twin1Quest) && !Twin1Quest.isQuestDone()) {
            menuController.SpeechText(Twin1Quest.getQuestDescription());
            player.addQuest(Twin1Quest);
        }
    }
    
}

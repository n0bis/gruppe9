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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static missions.QuestList.mummyQuest;
import utils.FadeAnimation;
import world.Game;
import static world.Game.player; 
import static world.Game.toiletpaper;
/**
 * FXML Controller class
 *
 * @author morte
 */
public class Mainhall2Controller extends MenuControllerInjection implements Initializable {
    
    private final Image youngMummy = new Image (getClass().getResourceAsStream("/images/NPC/Mummy.png"));
    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView arrowDownId;
    @FXML
    private ImageView arrowForwardId;
    @FXML
    private ImageView arrowRightId;
    @FXML
    private ImageView skeletonId;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backgroundId.fitHeightProperty().bind(anchorId.heightProperty());
        backgroundId.fitWidthProperty().bind(anchorId.widthProperty());
        skeletonId.setImage(new Image (getClass().getResourceAsStream("/images/NPC/Skelet.png")));
        // TODO
    }    

    @FXML
    private void arrowDownClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "mainhall7");
    }

    @FXML
    private void arrowForwardClicked(MouseEvent event) {
        if (mummyQuest.isQuestDone()) {
        FadeAnimation.fadeOutTransition(anchorId, "mainhall6");
    }
    }
    @FXML
    private void arrowRightClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "U55");
    }
    @FXML
    private void skeletonClicked(MouseEvent event) {
        if(!player.hasQuest(mummyQuest) && !mummyQuest.isQuestDone()) {
            System.out.println(mummyQuest.getQuestDescription());
            menuController.SpeechText(mummyQuest.getQuestDescription());
            player.addQuest(mummyQuest);
        } else if (mummyQuest.isQuestDone()) {
            menuController.SpeechText(mummyQuest.getQuestDone());
        } else if (player.hasQuest(mummyQuest) && player.hasItem(toiletpaper)) {
            menuController.SpeechText(mummyQuest.getQuestDone());
            mummyQuest.setIsQuestDone(true);
            skeletonId.setImage(youngMummy);
            
    }
    }
}

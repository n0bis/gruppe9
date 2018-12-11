/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Stenten;


import controllers.MenuControllerInjection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static missions.QuestList.doctorQuest;
import utils.FadeAnimation;
import world.Game;
import static world.Game.boneone;
import static world.Game.bonethree;
import static world.Game.bonetwo;
import static world.Game.player;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class EntranceU1Controller extends MenuControllerInjection implements Initializable {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView arrowBackId;
    @FXML
    private ImageView arrowBackId2;
    @FXML
    private ImageView arrowForwardId;
    @FXML
    private ImageView bone1;
    @FXML
    private ImageView doctor;
    
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
    private void arrowBackClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "notMainhall2");
    }

    @FXML
    private void arrowBack2Clicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "notMainhall");
    }

    @FXML
    public void arrowUpClicked(MouseEvent event) {
        menuController.SpeechText("Hahaa cannot entere here, you fool");
    }

    @FXML
    private void boneClicked(MouseEvent event) {
       player.addItem(boneone);
       anchorId.getChildren().remove(bone1);
    }

    @FXML
    private void doctorClicked(MouseEvent event) {
        if(!player.hasQuest(doctorQuest) && !doctorQuest.isQuestDone()) {
            menuController.SpeechText(doctorQuest.getQuestDescription());
            player.addQuest(doctorQuest);
        } else if(doctorQuest.isQuestDone()) {
            menuController.SpeechText(doctorQuest.getQuestDone());
        } else if(player.hasQuest(doctorQuest) && player.hasItem(boneone) && player.hasItem(bonetwo) && player.hasItem(bonethree)) {
            menuController.SpeechText(doctorQuest.getQuestDone());
            doctorQuest.setIsQuestDone(true);
            game.isStentenLocked = false;
        } else {
            menuController.SpeechText(doctorQuest.getQuestInProgress());
        } 
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.QuizController.isQuizTime;
import utils.FadeAnimation;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static missions.QuestList.sackQuest;
import static world.Game.Bookie;
import static world.Game.fangs;
import static world.Game.fireball;
import static world.Game.player;
import static world.Game.spellBook;
import static world.Game.teeth;
import static world.Game.toiletpaper;

/**
 *
 * @author ubuntu
 */
public class WorldOfZuulGUIController extends MenuControllerInjection {
    
    
    
    @FXML
    private ImageView room1;
    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView book;
    @FXML
    private ImageView arrow;
    @FXML
    private ImageView monsterId;   
    @FXML
    private ImageView fangsId;
    @FXML
    private ImageView toiletpaperId;
    
    public void initialize() {
        room1.setImage(new Image(getClass().getResourceAsStream("/images/rooms/imgscare.jpg")));
        room1.fitHeightProperty().bind(anchorId.heightProperty());
        room1.fitWidthProperty().bind(anchorId.widthProperty());
        book.setImage(new Image(getClass().getResourceAsStream("/images/items/book.png")));
        arrow.setImage(new Image(getClass().getResourceAsStream("/images/rooms/arrow-left.png")));
        fangsId.setImage(new Image(getClass().getResourceAsStream("/images/items/teeth.png")));
        toiletpaperId.setImage(new Image(getClass().getResourceAsStream("/images/items/toiletpaper.png")));
        isQuizTime();
    }

    @FXML
    private void bookMouseClicked(MouseEvent event) {
        book.setImage(null);
        //Add item to inventory
        player.addItem(Bookie);
        player.addItem(fireball);
    }
    @FXML
    private void fangsMouseClicked(MouseEvent event) {
        fangsId.setImage(null);
        player.addItem(fangs);
     
    }
    @FXML
    private void toiletpaperMouseClicked(MouseEvent event) {
        toiletpaperId.setImage(null);
        player.addItem(toiletpaper);
    }
    
    @FXML
    private void arrowMouseClicked(MouseEvent event) {
        if (player.hasItem(teeth)) {
            FadeAnimation.fadeOutTransition(anchorId, "Hall");
        } else {
            menuController.SpeechText("Ohh need to find an item to continue");
        }
    }
    

    @FXML
    private void talkMonster(MouseEvent event) {
        menuController.SpeechText("granted you " + spellBook);
        player.addItem(spellBook);
        menuController.unlockSpellBook();
        if(sackQuest.isQuestDone()) {
            menuController.SpeechText(sackQuest.getQuestDone());
        } else if (player.hasQuest(sackQuest) && !player.hasItem(Bookie)) {
            menuController.SpeechText(sackQuest.getQuestInProgress());
        } else if (player.hasQuest(sackQuest) && player.hasItem(Bookie)) {
            menuController.SpeechText(sackQuest.getQuestDone());
            sackQuest.setIsQuestDone(true);
            player.addItem(teeth);
        } else if (!player.hasQuest(sackQuest) && !sackQuest.isQuestDone()) {
            menuController.SpeechText(sackQuest.getQuestDescription());
            player.addQuest(sackQuest);
        }
    }
}

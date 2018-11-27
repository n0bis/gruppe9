/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import utils.FadeAnimation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import static world.Game.Bookie;
import static world.Game.fangs;
import static world.Game.fireball;
import static world.Game.player;
import static world.Game.spellBook;
import static world.Game.sackQuest;
import static world.Game.teeth;
import static world.Game.toiletpaper;
import world.Room;



/**
 *
 * @author ubuntu
 */
public class WorldOfZuulGUIController extends MenuControllerInjection {
    
    Room firstRoom = new Room("First room"); 
    
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
    private FlowPane flowPane;
    @FXML
    private TextArea smsTextbox;
    @FXML
    private Button leftAnswer;
    @FXML
    private Button rightAnswer;
    @FXML
    private Button closeButton;
    @FXML
    private ImageView fangsId;
    @FXML
    private ImageView toiletpaperId;
    @FXML
    private Label labelTitle;
    
    public void initialize() {
        if(!firstRoom.returnChecked()) {
          flowPane.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("/images/smartphone.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        }   
        
        room1.setImage(new Image(getClass().getResourceAsStream("/images/imgscare.jpg")));
        room1.fitHeightProperty().bind(anchorId.heightProperty());
        room1.fitWidthProperty().bind(anchorId.widthProperty());
        book.setImage(new Image(getClass().getResourceAsStream("/images/bookimg.png")));
        arrow.setImage(new Image(getClass().getResourceAsStream("/images/arrow-left.png")));
        fangsId.setImage(new Image(getClass().getResourceAsStream("/images/teeth.png")));
        toiletpaperId.setImage(new Image(getClass().getResourceAsStream("/images/toiletpaper.png")));
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
            player.removeQuest(sackQuest);
            player.addItem(teeth);
        } else if (!player.hasQuest(sackQuest) && !sackQuest.isQuestDone()) {
            menuController.SpeechText(sackQuest.getQuestDescription());
            player.addQuest(sackQuest);
        }
    }

    @FXML
    private void leftAnswerClicked(MouseEvent event) {
        smsTextbox.setText("Hej Player! Kan du huske hvilket lokale vi har COS undervisning i?" + "\n\n" + "Dig: Jeg tror det er U55." + "\n\n" +
                "Nå, det var forkert venni. Thanks for nothing.");
        rightAnswer.setOpacity(0);
        leftAnswer.setOpacity(0);
        closeButton.setOpacity(1);
        firstRoom.setIsChecked(true);  
    }

    @FXML
    private void rightAnswerClicked(MouseEvent event) {
        smsTextbox.setText("Hej Player! Kan du huske hvilket lokale vi har COS undervisning i?" + "\n\n" + "Dig: Jeg tror det er U55." + "\n\n" +
                "Det var rigtigt!");
        rightAnswer.setOpacity(0);
        leftAnswer.setOpacity(0);
        closeButton.setOpacity(1);
        firstRoom.setIsChecked(true);
    }

    @FXML
    private void closeButtonClicked(MouseEvent event) {
        if(closeButton.getOpacity() == 0.0) {
            return;
        }        
        anchorId.getChildren().remove(flowPane);
    }

    
}

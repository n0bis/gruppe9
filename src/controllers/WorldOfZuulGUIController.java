/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import static world.Game.Bookie;
import static world.Game.player;
import static world.Game.sackQuest;
import static world.Game.sackmonster;
import static world.Game.teeth;
import world.Room;

/**
 *
 * @author ubuntu
 */
public class WorldOfZuulGUIController extends UpperClass {
    
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
    private Label nodeLPane;
    @FXML
    private Button paneButton;
    
    Room firstRoom = new Room("First room");
    
    public void initialize() {
        if(!firstRoom.returnChecked()) {
            nodeLPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        }   
        
        System.out.println("hej");
        anchorId.setOpacity(1);
        room1.setImage(new Image(getClass().getResourceAsStream("/images/imgscare.jpg")));
        room1.fitHeightProperty().bind(anchorId.heightProperty());
        room1.fitWidthProperty().bind(anchorId.widthProperty());
        book.setImage(new Image(getClass().getResourceAsStream("/images/bookimg.png")));
        arrow.setImage(new Image(getClass().getResourceAsStream("/images/arrow-left.png")));
    }

    @FXML
    private void bookMouseClicked(MouseEvent event) {
        book.setImage(null);
        //Add item to inventory
        player.addItem(Bookie);
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
    private void paneButtonClicked(MouseEvent event) {
        nodeLPane.setOpacity(0);
        paneButton.setOpacity(0);
        firstRoom.setIsChecked(true);
        System.out.println(firstRoom.returnChecked());
    }
    
}

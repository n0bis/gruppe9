/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import static world.Game.boss;
import static world.Game.player;
import static world.Game.stage1RequiredItem;
import static world.Game.stage2RequiredItem;

/**
 * FXML Controller class
 *
 * @author madsfalken
 */
public class ChildRoomController extends UpperClass implements Initializable {

    private final Image stage2Boss = new Image(getClass().getResourceAsStream("/images/sackmonster2.png"));
    private final Image stage3Boss = new Image(getClass().getResourceAsStream("/images/sackmonster3.jpg"));
    private final Image dead = new Image(getClass().getResourceAsStream("/images/dead.png"));
    
    @FXML
    private ImageView book;
    @FXML
    private ImageView arrow;
    @FXML
    private GridPane rootPane;
    @FXML
    private ImageView bossId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        book.setImage(new Image(getClass().getResourceAsStream("/images/bookimg.png")));
        player.addItem(stage1RequiredItem);
        player.addItem(stage2RequiredItem);
    }    

    @FXML
    private void bossEncounter(MouseEvent event) {
        switch(boss.getStage()) {
            case 1:
                menuController.SpeechText(boss.getDialogue());
                if (boss.wonStage1(player)) {
                    boss.incrementStage();
                    bossEncounter(event);
                } else {
                    menuController.SpeechText("Hahaha you don't have what it takes to fight me");
                    throwOut();
                }
                break;
            case 2:
                menuController.SpeechText("Welcome to stage 2 of my face");
                bossId.setImage(stage2Boss);
                if (boss.wonStage2(player)) {
                    boss.incrementStage();
                    bossEncounter(event);
                } else {
                    throwOut();
                }

                break;
            case 3:
                bossId.setImage(stage3Boss);

                if(boss.wonStage3("fireball", player)) {
                    boss.incrementStage();
                    bossEncounter(event);
                    bossId.setImage(dead);
                } else {
                    throwOut();
                }
            }
    }
    
    private void throwOut() {
        menuController.SpeechAppend("\nCerberus threw you out");
        FadeAnimation.fadeOutTransition(rootPane, "Hall");
    }
    
}

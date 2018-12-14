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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import utils.FadeAnimation;
import utils.SoundMapper;
import static world.Game.boss;
import static world.Game.fireball;
import static world.Game.player;
import static world.Game.spellBook;

/**
 * FXML Controller class
 *
 * @author madsfalken
 */
public class BossFightController extends MenuControllerInjection implements Initializable, IPlaySound, INavigate {

    private final Image stage2Boss = new Image(getClass().getResourceAsStream("/images/NPC/Cerberus1.png"));
    private final Image stage3Boss = new Image(getClass().getResourceAsStream("/images/NPC/Cerberus2.png"));
    private final Image dead = new Image(getClass().getResourceAsStream("/images/dead.png"));
    
    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView arrowForwardId;
    @FXML
    private ImageView arrowBackId;
    @FXML
    private ImageView bossId;
    @FXML
    public Line bossHitbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backgroundId.fitHeightProperty().bind(anchorId.heightProperty());
        backgroundId.fitWidthProperty().bind(anchorId.widthProperty());
    }    
    
    public void bossEncounter() {
        switch(boss.getStage()) {
        case 1:
            menuController.SpeechText(boss.getDialogue());
            if (boss.wonStage1(player)) {
                boss.incrementStage();
                bossEncounter();
            } else {
                menuController.SpeechText("Hahaha, you don't have what it takes to fight me!");
                throwOut();
            }
            break;
        case 2:
            menuController.SpeechText("Oh, you might have killed my first head. But I still have 2 left!");
            bossId.setImage(stage2Boss);
            if (boss.wonStage2(player)) {
                boss.incrementStage();
                bossEncounter();
            } else {
                throwOut();
            }

            break;
        case 3:
            if (!player.hasItem(fireball)) {
                menuController.SpeechText("You need a spell to kill me, and you don't have it!");
                throwOut();
            } 

            menuController.SpeechText("My last head can only be killed by a spell!");
            bossId.setImage(stage3Boss);
            if(boss.wonStage3(fireball, player)) {
                boss.incrementStage();
                bossEncounter();
                menuController.SpeechText("Aarggghh, you've killed my last head!");
                bossId.setImage(dead);
                arrowBackId.setOpacity(1);
                arrowForwardId.setOpacity(1);
            }
        }
    }
        
    private void throwOut() {
        menuController.SpeechText("\nCerberus threw you out!");
        FadeAnimation.fadeOutTransition(anchorId, "bossEntrance");
    }    

    @FXML
    public void arrowUpClicked(MouseEvent event) {
        if(arrowForwardId.getOpacity() == 0.0) {
            return;
        }    
        FadeAnimation.fadeOutTransition(anchorId, "nedenUnder");
    }

    @FXML
    public void arrowBackClicked(MouseEvent event) {
        if(arrowBackId.getOpacity() == 0.0) {
            return;
        }    
        FadeAnimation.fadeOutTransition(anchorId, "bossEntrance");
    }

    @Override
    public SoundMapper mapSound() {
        return new SoundMapper("/sounds/spooky.mp3");
    }

    @Override
    public void arrowRightClicked(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void arrowLeftClicked(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @FXML
    private void bossClicked(MouseEvent event) {
        bossEncounter();
    }    
}

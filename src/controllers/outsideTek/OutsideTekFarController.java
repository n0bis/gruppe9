/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.outsideTek;


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
import javafx.scene.shape.Rectangle;
import utils.FadeAnimation;
import static world.Game.Bookie;
import static world.Game.boss;
import static world.Game.fireball;
import static world.Game.player;
import static world.Game.spellBook;
import static world.Game.stage1RequiredItem;
import static world.Game.stage2RequiredItem;
import static world.Game.studyCard;
import worldofzuul.StartGame;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class OutsideTekFarController extends MenuControllerInjection implements Initializable {

    private final Image stage2Boss = new Image(getClass().getResourceAsStream("/images/sackmonster2.png"));
    private final Image stage3Boss = new Image(getClass().getResourceAsStream("/images/sackmonster3.jpg"));
    private final Image dead = new Image(getClass().getResourceAsStream("/images/dead.png"));

    StartGame startGame = new StartGame();
    
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView arrowUpId;
    @FXML
    private AnchorPane anchorId;
    @FXML
    public ImageView bossId;
    @FXML
    private ImageView book;
    
    @FXML
    private ImageView themeIconView;
    @FXML
    public Line bossHitbox;
    @FXML
    public ImageView studyCardId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backgroundId.fitHeightProperty().bind(anchorId.heightProperty());
        backgroundId.fitWidthProperty().bind(anchorId.widthProperty());
        themeIconView.setImage(new Image(getClass().getResourceAsStream("/images/" + startGame.getImageSelector() + "/themeIcon.png")));
        studyCardId.setImage(new Image(getClass().getResourceAsStream("/images/items/studentid.png")));
        // TODO
        
        player.addItem(stage1RequiredItem);
        player.addItem(stage2RequiredItem);
        player.addItem(spellBook);
        spellBook.addSpell(fireball);
    }    
    
    public void bossEncounter() {
        switch(boss.getStage()) {
        case 1:
            menuController.SpeechText(boss.getDialogue());
            if (boss.wonStage1(player)) {
                boss.incrementStage();
                bossEncounter();
            } else {
                menuController.SpeechText("Hahaha you don't have what it takes to fight me");
                throwOut();
            }
            break;
        case 2:
            menuController.SpeechText("Ohh, you might have killed my first head, but I still have my Metalhead. FeelsGoodMan");
            bossId.setImage(stage2Boss);
            if (boss.wonStage2(player)) {
                boss.incrementStage();
                bossEncounter();
            } else {
                throwOut();
            }

            break;
        case 3:
            if (!spellBook.hasSpell(fireball)) {
                menuController.SpeechText("You dont have the spell to defeat me!");
                throwOut();
            } 

            menuController.SpeechText("Only a spell can kill my last head!");
            bossId.setImage(stage3Boss);
            if(boss.wonStage3(fireball ,player)) {
                boss.incrementStage();
                bossEncounter();
                menuController.SpeechText("You've killed my last head! *super dead*");
                bossId.setImage(dead);
            }
        }
    }
    
    private void throwOut() {
        menuController.SpeechText("\nCerberus threw you out");
        FadeAnimation.fadeOutTransition(anchorId, "outsideTekClose");
    }    
    
    @FXML
    private void pickupBook(MouseEvent event) {
        book.setImage(null);
        //Add item to inventory
        player.addItem(Bookie);
        player.addItem(fireball);
        player.addItem(spellBook);
        menuController.unlockSpellBook();
    }

    @FXML
    private void arrowUpClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "outsideTekClose");
    }

    @FXML
    private void bossClicked(MouseEvent event) {
        bossEncounter();
    }
    @FXML
    private void studyCardClicked(MouseEvent event) {
        studyCardId.setImage(null);
        player.addItem(studyCard);
    }
}

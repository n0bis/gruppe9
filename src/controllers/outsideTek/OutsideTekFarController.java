/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.outsideTek;


import controllers.INavigate;
import controllers.IPlaySound;
import controllers.MagicInjection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import utils.SoundMapper;
import javafx.scene.shape.Line;
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
public class OutsideTekFarController extends MagicInjection implements Initializable, IPlaySound, INavigate {
    
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
    private ImageView studyCardId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backgroundId.fitHeightProperty().bind(anchorId.heightProperty());
        backgroundId.fitWidthProperty().bind(anchorId.widthProperty());
        themeIconView.setImage(new Image(getClass().getResourceAsStream("/images/" + startGame.getImageSelector() + "/themeIcon.png")));
        studyCardId.setImage(new Image(getClass().getResourceAsStream("/images/items/studentid.png")));
        
        player.addItem(stage1RequiredItem);
        player.addItem(stage2RequiredItem);
        player.addItem(spellBook);
        spellBook.addSpell(fireball);
    }   
    
    @FXML
    private void pickupBook(MouseEvent event) {
        menuController.playSound("/sounds/cloth-inventory.wav");
        book.setImage(null);
        //Add item to inventory
        player.addItem(Bookie);
        player.addItem(spellBook);
        menuController.unlockSpellBook();
    }

    @FXML
    public void arrowUpClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "outsideTekClose");        
    }

    @Override
    public SoundMapper mapSound() {
        return new SoundMapper("/sounds/wind.mp3");
    }

    @Override
    public void arrowBackClicked(MouseEvent event) {
    }

    @Override
    public void arrowRightClicked(MouseEvent event) {
    }

    @Override
    public void arrowLeftClicked(MouseEvent event) {
    }
    
    @FXML
    private void studyCardClicked(MouseEvent event) {
        player.addItem(studyCard);
        studyCardId.setImage(null);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javafx.animation.Animation;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import static world.Game.Bookie;
import static world.Game.fireball;
import static world.Game.player;
import static world.Game.spellBook;

/**
 *
 * @author ubuntu
 */
public class WorldOfZuulGUIController extends UpperClass {
    
    private final Image IMAGE = new Image(getClass().getResourceAsStream("/images/The_Horse_in_Motion.jpg"));

    private static final int COLUMNS  =   4;
    private static final int COUNT    =  10;
    private static final int OFFSET_X =  18;
    private static final int OFFSET_Y =  25;
    private static final int WIDTH    = 374;
    private static final int HEIGHT   = 243;
    
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
    
    public void initialize() {
        final ImageView imageView = new ImageView(IMAGE);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
        imageView.toFront();
        final Animation animation = new SpriteAnimation(
                imageView,
                Duration.millis(1000),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        anchorId.getChildren().add(imageView);
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
        player.addItem(fireball);
    }

    @FXML
    private void arrowMouseClicked(MouseEvent event) {
        if (player.hasItem(Bookie)) {
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
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static world.Game.Bookie;
import static world.Game.player;

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
    
    public void initialize() {
        anchorId.setOpacity(1);
        //book.setOnMouseEntered((value) -> book.setEffect(new DropShadow(20, Color.FIREBRICK)));
        //book.setOnMouseExited((value) -> book.setEffect(null));
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
        FadeAnimation.fadeOutTransition(anchorId, "Hall");
    }

    @FXML
    private void talkMonster(MouseEvent event) {
        menuController.SpeechText("I'll grant you 3 wishes");
    }
    
}

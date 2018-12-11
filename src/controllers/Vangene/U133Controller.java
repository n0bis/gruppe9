/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Vangene;


import controllers.MenuControllerInjection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import utils.FadeAnimation;
import static world.Game.creepyDoll;
import static world.Game.player;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class U133Controller extends MenuControllerInjection implements Initializable {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView arrowBackId;
    @FXML
    private ImageView creepyDollId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backgroundId.fitHeightProperty().bind(anchorId.heightProperty());
        backgroundId.fitHeightProperty().bind(anchorId.widthProperty());
        creepyDollId.setImage(new Image(getClass().getResourceAsStream("/images/items/creepyDoll.png")));
        // TODO
    }    

    @FXML
    private void arrowBackClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "outsideU133");
    }
    @FXML
    private void creepyDollClicked(MouseEvent event) {
        creepyDollId.setImage(null);
        player.addItem(creepyDoll);
        if (player.hasItem(creepyDoll)) {
            menuController.SpeechText("You found the last born twin's creepy doll! Now you can safely deliver it to her.");
        }
    }
}

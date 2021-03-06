/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.GydehuttenNorth;

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
import utils.FadeAnimation;
import utils.SoundMapper;
import static world.Game.coin;
import static world.Game.player;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class EntranceToTorvetController extends MagicInjection implements Initializable, IPlaySound, INavigate {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView arrowForwardId;
    @FXML
    private ImageView arrowBackId;
    @FXML
    private ImageView coinId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backgroundId.fitHeightProperty().bind(anchorId.heightProperty());
        backgroundId.fitWidthProperty().bind(anchorId.widthProperty());
        coinId.setImage(new Image(getClass().getResourceAsStream("/images/items/Coin.png")));
        // TODO
    }    

    @FXML
    public void arrowUpClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "torvet");
    }

    @FXML
    public void arrowBackClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "mainhall5");
    }
    @FXML
    private void coinClicked(MouseEvent event) {
        coinId.setImage(null);
        player.addItem(coin); 
        if (player.hasItem(coin)) {
            menuController.SpeechText("You can now buy yourself a coffee from the vending machine down the corridor");    
        }
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
    }


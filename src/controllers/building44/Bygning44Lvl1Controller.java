/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.building44;


import controllers.INavigate;
import controllers.IPlaySound;
import controllers.MagicInjection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import utils.FadeAnimation;
import utils.SoundMapper;
import static world.Game.player;
import static world.Game.scissorItem;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class Bygning44Lvl1Controller extends MagicInjection implements Initializable, IPlaySound, INavigate {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView arrowBackId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView scissor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backgroundId.fitHeightProperty().bind(anchorId.heightProperty());
        backgroundId.fitWidthProperty().bind(anchorId.widthProperty());
        // TODO
    }    

    @FXML
    public void arrowBackClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "bygning44TowardsLvl1");
    }

    @Override
    public SoundMapper mapSound() {
        return new SoundMapper(0.6, "/sounds/spooky.mp3");
    }

    @Override
    public void arrowUpClicked(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    private void scissorClicked(MouseEvent event) {
        player.addItem(scissorItem);
        anchorId.getChildren().remove(scissor);
    }
}

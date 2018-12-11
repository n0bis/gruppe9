/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.building44;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import utils.FadeAnimation;
import static world.Game.player;
import static world.Game.scissorItem;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class Bygning44Lvl1Controller implements Initializable {

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
    private void arrowBackClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "bygning44TowardsLvl1");
    }

    @FXML
    private void scissorClicked(MouseEvent event) {
        player.addItem(scissorItem);
        anchorId.getChildren().remove(scissor);
    
    }
}

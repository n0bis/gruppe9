/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.GydehuttenSouth;


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
import static world.Game.player;
import static world.Game.toiletpaper;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class ToiletsController extends MenuControllerInjection implements Initializable {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView arrowBackId;
    @FXML
    private ImageView toiletpaperId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backgroundId.fitHeightProperty().bind(anchorId.heightProperty());
        backgroundId.fitWidthProperty().bind(anchorId.widthProperty());
        toiletpaperId.setImage(new Image(getClass().getResourceAsStream("/images/items/toiletpaper.png")));
        // TODO
    }    

    @FXML
    private void arrowBackClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "towardsToilets");
    }
    @FXML
    private void toiletpaperClicked(MouseEvent event) {
        toiletpaperId.setImage(null);
        player.addItem(toiletpaper);
        
    }
    
}

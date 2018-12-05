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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import utils.FadeAnimation;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class MainhallRightOrLeftController extends MenuControllerInjection implements Initializable {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView leftArrowId;
    @FXML
    private ImageView arrowRightId;
    @FXML
    private ImageView arrowDownId;

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
    private void arrowLeftClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "towardsU45");
    }

    @FXML
    private void arrowRightClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "mainhall1");
    }

    @FXML
    private void arrowDownClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "towardsMainhall3");
    }
    
}

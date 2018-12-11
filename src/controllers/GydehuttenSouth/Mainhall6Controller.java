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
 * @author madsfalken
 */
public class Mainhall6Controller extends MenuControllerInjection implements Initializable {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView arrowForwardId;
    @FXML
    private ImageView arrowBackId;
    @FXML
    private ImageView arrowLibraryId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backgroundId.fitHeightProperty().bind(anchorId.heightProperty());
        backgroundId.fitWidthProperty().bind(anchorId.widthProperty());
    }    

    @FXML
    private void arrowForwardClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "mainhall");
    }

    @FXML
    private void arrowBackClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "mainhall2");
    }

    @FXML
    private void arrowLibraryClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "LibraryEntrance");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class TekHallController implements Initializable {

    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView rightArrowId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void arrowRightClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(backgroundId, "tekHallStairs");
    }
    
}

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
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ubuntu
 */
public class StartController implements Initializable {

     @FXML
    private ImageView hallId;
    private ImageView arrowRightId;
    @FXML
    private AnchorPane rootId;
    private ImageView arrowLeftId;
    @FXML
    private Button startGame;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hallId.setImage(new Image(getClass().getResourceAsStream("/images/press.gif")));
        hallId.fitHeightProperty().bind(rootId.heightProperty());
        hallId.fitWidthProperty().bind(rootId.widthProperty());
    }    

    @FXML
    private void startGameClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(hallId, "WorldOfZuulGUI");
    }
    
}


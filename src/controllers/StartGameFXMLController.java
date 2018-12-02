/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application.Parameters;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import worldofzuul.StartGame;

/**
 * FXML Controller class
 *
 * @author ubuntu
 */
public class StartGameFXMLController implements Initializable {

    @FXML
    private AnchorPane startAnchorPane;
    @FXML
    private Button startGameButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void startGameClicked(MouseEvent event) throws IOException {
        StartGame game = new StartGame();
        game.buttonStart();
        
        
        
    }
    
}

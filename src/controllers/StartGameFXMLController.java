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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import worldofzuul.StartGame;

/**
 * FXML Controller class
 *
 * @author ubuntu
 */
public class StartGameFXMLController implements Initializable {
    
    StartGame startGame = new StartGame();
    
    @FXML
    private AnchorPane startAnchorPane;
    @FXML
    private Button startGameButton;
    @FXML
    private RadioButton harryRadioButton;
    @FXML
    private RadioButton ringenesRadioButton;
    @FXML
    private ToggleGroup startToggleGroup;
    @FXML
    private RadioButton thronesRadioButton;
    @FXML
    private Label labelMessage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void startGameClicked(MouseEvent event) throws IOException {
        if(startGame.getImageSelector() != null) {
            startGame.primaryStage.close();
            startGame.second();
        } else {
            labelMessage.setOpacity(1);
        }  
    }

    @FXML
    private void harryAction(ActionEvent event) {
        startGame.setImageSelector("harry");
    }

    @FXML
    private void ringenesAction(ActionEvent event) {
        startGame.setImageSelector("ringenes");
    }

    @FXML
    private void thronesAction(ActionEvent event) {
        startGame.setImageSelector("thrones");
    }
    
}

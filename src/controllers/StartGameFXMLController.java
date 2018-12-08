/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Application.Parameters;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    List<String> imageSelectorList = new ArrayList<>();
    public int listCounter = 1;
    
    @FXML
    private AnchorPane startAnchorPane;
    @FXML
    private Button startGameButton;
    @FXML
    private Label labelMessage;
    @FXML
    private TextField enterNameTextField;
    @FXML
    private ImageView hatImage;
    @FXML
    private ImageView arrowLeft;
    @FXML
    private ImageView arrowRight;
    @FXML
    private Label labelTheme;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imageSelectorList.add("Harry Potter");
        imageSelectorList.add("Lord of the Rings");
        imageSelectorList.add("Game of Thrones");
        hatImage.setImage(new Image((getClass().getResourceAsStream("/images/startscreen/" + imageSelectorList.get(listCounter).replaceAll("\\s+", "").toLowerCase() + ".png"))));
        labelTheme.setText(imageSelectorList.get(listCounter));
        startGame.setImageSelector(imageSelectorList.get(listCounter).replaceAll("\\s+", "").toLowerCase());
    }    
    
    
    @FXML
    private void startGameClicked(MouseEvent event) throws IOException {
        if(startGame.getImageSelector() != null && !enterNameTextField.getText().equals("")) {
            startGame.setPlayerName(enterNameTextField.getText());
            startGame.primaryStage.close();
            startGame.second();
        } else {
            labelMessage.setOpacity(1);
        }  
    }

    private void harryAction(ActionEvent event) {
        startGame.setImageSelector("harry");
    }

    private void ringenesAction(ActionEvent event) {
        startGame.setImageSelector("ringenes");
    }

    private void thronesAction(ActionEvent event) {
        startGame.setImageSelector("thrones");
    }

    @FXML
    private void leftArrowClicked(MouseEvent event) {
        if(listCounter > 0) {
            listCounter--;
            startGame.setImageSelector(imageSelectorList.get(listCounter).replaceAll("\\s+", "").toLowerCase());
            hatImage.setImage(new Image((getClass().getResourceAsStream("/images/startscreen/" + imageSelectorList.get(listCounter).replaceAll("\\s+", "").toLowerCase() + ".png"))));
            labelTheme.setText(imageSelectorList.get(listCounter));
        }
    }

    @FXML
    private void rightArrowClicked(MouseEvent event) {
        if(listCounter < 2) {
            listCounter++;
            startGame.setImageSelector(imageSelectorList.get(listCounter).replaceAll("\\s+", "").toLowerCase());
            hatImage.setImage(new Image((getClass().getResourceAsStream("/images/startscreen/" + imageSelectorList.get(listCounter).replaceAll("\\s+", "").toLowerCase() + ".png"))));
            labelTheme.setText(imageSelectorList.get(listCounter));
            
            
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import static utils.ShowMap.showMap;
import static world.Game.player;

/**
 * FXML Controller class
 *
 * @author madsfalken
 */
public class MenuController implements Initializable {

    @FXML
    private ImageView phoneId;
    @FXML
    private ImageView bagId;
    @FXML
    private ImageView mapId;
    @FXML
    private TextArea SpeechId;
    @FXML
    private Label labelId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelId.setText("Åh abe");
    }    

    @FXML
    private void mapClicked(MouseEvent event) {
        showMap();
    }
    
    public void SpeechText(String speech) {
        System.out.println("Hit");
        SpeechId.setText(speech);
    }

    @FXML
    private void bagClicked(MouseEvent event) {
        player.getInventory();
    }
    
}

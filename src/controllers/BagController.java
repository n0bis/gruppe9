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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NidaBasaran
 */
public class BagController implements Initializable {
    @FXML
    private ImageView bagId;
    @FXML
    private AnchorPane rootId;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bagId.setImage(new Image(getClass().getResourceAsStream("/images/burlap.jpg")));
        bagId.fitHeightProperty().bind(rootId.heightProperty());
        
    }
 
   }


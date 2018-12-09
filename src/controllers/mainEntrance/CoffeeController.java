/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.mainEntrance;


import controllers.MenuControllerInjection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import utils.FadeAnimation;
import static world.Game.coffeeDrink;
import static world.Game.player;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class CoffeeController extends MenuControllerInjection implements Initializable {

    @FXML
    private AnchorPane anchorId;
    @FXML
    private ImageView backgroundId;
    @FXML
    private ImageView arrowLeftId;
    @FXML
    private ImageView arrowRightId;
    @FXML
    private ImageView coffeeDrinkId;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backgroundId.fitHeightProperty().bind(anchorId.heightProperty());
        backgroundId.fitWidthProperty().bind(anchorId.widthProperty());
        coffeeDrinkId.setImage(new Image(getClass().getResourceAsStream("/images/items/CoffeeDrink.png")));
        // TODO
    }    

    @FXML
    private void arrowLeftClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "torvet2");
    }

    @FXML
    private void arrowRightClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "torvet");
    }
    int i = 20;
    @FXML
    private void coffeeDrinkClicked(MouseEvent event) {  
        coffeeDrinkId.setImage(null);
        player.addItem(coffeeDrink);
    }
        
    @FXML
    private void MouseClicked(MouseEvent event) {  
        if (player.hasItem(coffeeDrink)) { 
            menuController.SpeechText("You've had too much to drink, so now it's time to find a toilet");
            if (i>= 20) {
                 menuController.SpeechText("you lost");
            }
            else {
                menuController.SpeechText("Congrats you found the toilet in under 20 mouse clicks so now you can pee in peace");
        }
        i = i -1;
        menuController.SpeechText(" You now have " + i + " clicks to find the toilet. " + " If you can't find the toilet before all \n of your clicks are done you'll lose ");
    }
            }
    }  
    
      


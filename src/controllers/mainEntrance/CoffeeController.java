/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.mainEntrance;


import controllers.INavigate;
import controllers.IPlaySound;
import controllers.MagicInjection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import utils.FadeAnimation;
import utils.SoundMapper;
import static world.Game.coffeeDrink;
import static world.Game.coin;
import static world.Game.player;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class CoffeeController extends MagicInjection implements Initializable, IPlaySound, INavigate {

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
    public void arrowLeftClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "torvet2");
    }

    @FXML
    public void arrowRightClicked(MouseEvent event) {
        FadeAnimation.fadeOutTransition(anchorId, "torvet");
    }
    
    @FXML
    private void coffeeDrinkClicked(MouseEvent event) {  
      if (player.hasItem(coin)) {
            coffeeDrinkId.setImage(null);
            player.addItem(coffeeDrink);
            menuController.SpeechText("You've had to much coffee therefore you need to find the toilet which is downstairs");
        } else {
            menuController.SpeechText("You need a coin to buy coffee");
        }
        if (player.getInventory().contains(coffeeDrink)) {
            player.getInventory().remove(coin); 
        }
    }

    @Override
    public SoundMapper mapSound() {
        return new SoundMapper("/sounds/spooky.mp3");
    }

    @Override
    public void arrowUpClicked(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void arrowBackClicked(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

        
      


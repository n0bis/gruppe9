/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import items.Item;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import static world.Game.fireball;
import static world.Game.player;
import static world.Game.spellBook;

/**
 * FXML Controller class
 *
 * @author madsfalken
 */
public class MenuController implements Initializable {
    
    private final Image fireballIcon = new Image(getClass().getResourceAsStream("/images/fireball.jpg"));
    private final Image fireballImage = new Image(getClass().getResourceAsStream("/images/fireballz.png"));
    private final Image explosionImage = new Image(getClass().getResourceAsStream("/images/explosion.png"));
    private final Image spellBookImage = new Image(getClass().getResourceAsStream("/images/spellbook.png"));

    @FXML
    private ImageView bagId;
    @FXML
    private ImageView mapId;
    @FXML
    private TextArea SpeechId;
    @FXML
    private ImageView spellBookId;
    @FXML
    private AnchorPane rootId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpeechId.setEditable(false);
        SpeechId.setWrapText(true);
    }    

    @FXML
    private void mapClicked(MouseEvent event) throws IOException {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/views/Map.fxml")
        );
        Parent root = loader.load();
        Scene dialogScene = new Scene(root);
        dialog.setScene(dialogScene);
        dialog.setAlwaysOnTop(true);
        dialog.setResizable(false);
        dialog.show();
    }
    
    public void SpeechText(String speech) {
        SpeechId.setText(speech);
    }

    @FXML
    private void bagClicked(MouseEvent event) {
        player.getInventory();
       
    }

    @FXML
    private void spellBookClicked(MouseEvent event) throws IOException {
        if (!player.hasItem(spellBook)) {
            return;
        }
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("/views/Spellbook.fxml")
        );
        Parent root = loader.load();
        if (player.hasItem(fireball)) {
            ImageView fireBallIcon = (ImageView)loader.getNamespace().get("fireBallId");
            fireBallIcon.setImage(fireballIcon);
            fireBallIcon.setOnMouseClicked((value) -> {
                dialog.close();
                
                BorderPane main = SceneManager.getMain();
                
                ImageView imageViewFire = new ImageView(fireballImage);
                imageViewFire.setLayoutX(main.getBoundsInLocal().getMaxX() / 2);
                imageViewFire.setLayoutY(800);
                Animation fireballAnimation = new SpriteAnimation(
                    imageViewFire,
                    Duration.millis(1000), 
                    14, 14,
                    1, 1,
                    97, 85
                );
                imageViewFire.setScaleX(2.0);
                imageViewFire.setScaleY(4.0);
                fireballAnimation.setCycleCount(Animation.INDEFINITE);
                fireballAnimation.play();
                
                TranslateTransition transition = new TranslateTransition();
                transition.setDuration(Duration.seconds(1.2));
                transition.setToY(-(main.getBoundsInLocal().getMaxY() / 2));
                transition.setNode(imageViewFire);
                transition.play();
                transition.setOnFinished((val) -> {
                    ImageView imageViewExplosion = new ImageView(explosionImage);
                    imageViewExplosion.setScaleX(2.0);
                    imageViewExplosion.setScaleY(2.0);
                    imageViewExplosion.setViewport(new Rectangle2D(2, 1, 97, 150));
                    imageViewExplosion.setLayoutX((main.getBoundsInLocal().getMaxX() / 2) - (imageViewExplosion.getBoundsInLocal().getMaxX() / 2));
                    imageViewExplosion.setLayoutY((main.getBoundsInLocal().getMaxY() / 2) - (imageViewExplosion.getBoundsInLocal().getMaxY() / 2));
                    main.getChildren().remove(imageViewFire);
                    Animation explosionAnimation = new SpriteAnimation(
                        imageViewExplosion,
                        Duration.millis(1000),
                        15, 15,
                        2, 1,
                        97, 150
                    );
                    explosionAnimation.setCycleCount(1);
                    explosionAnimation.play();
                    explosionAnimation.setOnFinished((h) ->
                        main.getChildren().remove(imageViewExplosion));
                    main.getChildren().add(imageViewExplosion);
                });
                main.getChildren().add(imageViewFire);
            });
        }
        dialogVbox.getChildren().add(root);
        Scene dialogSence = new Scene(dialogVbox);
        dialog.setScene(dialogSence);
        dialog.setAlwaysOnTop(true);
        dialog.setResizable(false);
        dialog.show();
    }
    
    public void unlockSpellBook() {
        spellBookId.setImage(spellBookImage);
    }
    
}

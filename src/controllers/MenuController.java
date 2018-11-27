/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

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

import javafx.scene.shape.Rectangle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import static utils.ShowMap.showMap;

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

    private void mapClicked(MouseEvent event) throws IOException, InterruptedException {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("/views/Map.fxml")
        );
        Parent root = loader.load();
        WebView browser = (WebView)loader.getNamespace().get("webViewId");
        final WebEngine webEngine = browser.getEngine();
        webEngine.load("https://clients.mapsindoors.com/sdu/573f26e4bc1f571b08094312");
        webEngine.setJavaScriptEnabled(true);
        
        AnchorPane notRespondingNode = (AnchorPane)loader.getNamespace().get("notRespondingNode");
        Button okButton = (Button)loader.getNamespace().get("okButtonId");
        okButton.setOnAction((ActionEvent) -> dialog.close());
        Button waitButton = (Button)loader.getNamespace().get("waitButtonId");
        waitButton.setOnAction((ActionEvent) -> dialog.close());
        
        Timeline beat = new Timeline(
            new KeyFrame(Duration.seconds(ThreadLocalRandom.current().nextDouble(5.0, 10.0)), keyEvent -> notRespondingNode.setOpacity(1.0))
        );
        beat.setCycleCount(1);
        beat.play();
        
        
        Scene dialogSence = new Scene(root);
        dialog.setScene(dialogSence);

  
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

    private void bagClicked(MouseEvent event) throws IOException {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        
        FXMLLoader loader = new FXMLLoader(
           getClass().getResource("/views/Bag.FXML")
        );
        Parent root = loader.load();
        
        Scene dialogScene = new Scene(root);
        dialog.setScene(dialogScene);
        dialog.setAlwaysOnTop(true);
        dialog.setResizable(false);
        dialog.show();

   {
        player.getInventory();
       
   }

   
     {
        if (!player.hasItem(spellBook)) {
            return;
        }
        
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);
    
        if (player.hasItem(fireball)) {
            ImageView fireBallIcon = (ImageView)loader.getNamespace().get("fireBallId");
            fireBallIcon.setImage(fireballIcon);
            fireBallIcon.setOnMouseClicked((value) -> {
                System.out.println("imma firin mah lazer");
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
    
   {
        spellBookId.setImage(spellBookImage);

    }
}

    void unlockSpellBook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


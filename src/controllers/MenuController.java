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
import javafx.scene.control.TextArea;
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
    }
}

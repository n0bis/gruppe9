/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static utils.ShowMap.showMap;
import static world.Game.fireball;
import static world.Game.player;
import static world.Game.spellBook;

/**
 * FXML Controller class
 *
 * @author madsfalken
 */
public class MenuController implements Initializable {

    @FXML
    private ImageView bagId;
    @FXML
    private ImageView mapId;
    @FXML
    private TextArea SpeechId;
    @FXML
    private ImageView spellBookId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpeechId.setEditable(false);
        SpeechId.setWrapText(true);
    }    

    @FXML
    private void mapClicked(MouseEvent event) {
        showMap();
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
            fireBallIcon.setImage(new Image(getClass().getResourceAsStream("/images/fireball.jpg")));
            fireBallIcon.setOnMouseClicked((value) -> {
                System.out.println("imma firin mah lazer");
                dialog.close();
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
        spellBookId.setImage(new Image(getClass().getResourceAsStream("/images/spellbook.png")));
    }
    
}

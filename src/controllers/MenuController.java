/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import items.SpellBook;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import static world.Game.player;
import worldofzuul.StartGame;

/**
 * FXML Controller class
 *
 * @author madsfalken
 */
public class MenuController implements Initializable {
    
    StartGame startGame = new StartGame();
    private final Image spellBookImage = new Image(SpellBook.class.getResourceAsStream("/images/menu/spellbook.png"));

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
        SpeechId.setText("Welcome to SDU Maze, " + startGame.getPlayerName() + "!");
    }    

    @FXML
    private void mapClicked(MouseEvent event) throws IOException, InterruptedException {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("/views/Map.fxml")
        );
        Parent root = loader.load();

        Group closeButton = (Group)loader.getNamespace().get("crossId");
        closeButton.setOnMouseClicked((mouseEvent) -> SceneManager.getMain().getChildren().remove(root));
        root.setLayoutX(300);
        root.setLayoutY(60);
        root.getChildrenUnmodifiable().forEach(node -> {
            if (node instanceof Rectangle) {
                node.setOpacity(0);
            }
        });
        String packageName = SceneManager.getController().getClass().getPackage().getName();
        String[] splitPackageNames = packageName.split(Pattern.quote("."));
        if (splitPackageNames.length > 1) {
            String toShow = splitPackageNames[1];
            Rectangle rect = (Rectangle)loader.getNamespace().get(toShow);
            if (rect != null ) rect.setOpacity(1);
        }
        SceneManager.getMain().getChildren().add(root);
    }
    
    public void SpeechText(String speech) {
        SpeechId.setText(speech);
    }

    @FXML
    private void bagClicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(
           getClass().getResource("/views/Bag.FXML")
        );
        Parent root = loader.load();
        
        player.getInventory().forEach((item) -> {
            ImageView itemImg = (ImageView)loader.getNamespace().get(item.getName().toLowerCase() + "Id");
            if (itemImg == null) return;
            itemImg.setEffect(null);
        });
        Group closeButton = (Group)loader.getNamespace().get("crossId");
        closeButton.setOnMouseClicked((mouseEvent) -> SceneManager.getMain().getChildren().remove(root));
        root.setLayoutX(200);
        root.setLayoutY(60);
        SceneManager.getMain().getChildren().add(root);
    } 
    
    @FXML
    private void spellBookClicked(MouseEvent event) throws IOException {
        SpellBook.openSpellBook();
        SpellBook.castFireball();
    }

    public void unlockSpellBook() {
        spellBookId.setImage(spellBookImage);
    }
}


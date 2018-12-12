/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import static world.Game.player;
import world.Room;
import worldofzuul.StartGame;

/**
 * FXML Controller class
 *
 * @author madsfalken
 */
public class QuizController extends TimerTask implements Initializable {
    
    StartGame startGame = new StartGame();
    private Room firstRoom = new Room("First room"); 
    public static boolean hasAnswered = false;
    public static boolean isActive = false;
    
    @FXML
    private FlowPane flowPane;
    @FXML
    private Label labelTitle;
    @FXML
    private TextArea smsTextbox;
    private Button leftAnswer;
    private Button rightAnswer;
    @FXML
    private Button closeButton;
    @FXML
    private AnchorPane rootId;
    @FXML
    private TextField writtenText;
    @FXML
    private Button sendButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        flowPane.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("/images/menu/smartphone.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        String text = smsTextbox.getText().replaceFirst("Player", startGame.getPlayerName());
        smsTextbox.setText(text);
    }    

    @FXML
    private void closeButtonClicked(MouseEvent event) {
        if(closeButton.getOpacity() == 0.0) {
            return;
        }     
        SceneManager.getMain().getChildren().removeAll(rootId, flowPane, labelTitle, smsTextbox, leftAnswer, rightAnswer, closeButton);
    }
    
    @FXML
    private void sendMessage(MouseEvent event) {
        String answer = writtenText.getText();
        if (answer.equals("u45") || answer.equals("U45")) {
            smsTextbox.appendText("\n\n" + "You: I think it's U45." + "\n\n" + "That's right!");
            sendButton.setOpacity(0);
            closeButton.setOpacity(1);
            firstRoom.setIsChecked(true);
        } else {
            smsTextbox.appendText("\n\n" + "You: I think it's U55." + "\n\n" + "Sadly that's wrong my friend.");
            sendButton.setOpacity(0);
            closeButton.setOpacity(1);
            firstRoom.setIsChecked(true);  
        }
        hasAnswered = true;
        isActive = false;
    }
    
    @Override
    public void run() {
        Platform.runLater(() -> {
            isActive = true;
            FXMLLoader loader = new FXMLLoader(getClass().getResource( "/views/Quiz.fxml" ));
            try {
                Node main = SceneManager.getMain();
                Node node = loader.load();
                node.setLayoutX(300);
                node.setLayoutY(150);
                SceneManager.getMain().getChildren().add(node);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
    
    public static void isQuizTime() {
        Platform.runLater(() -> {
            isActive = true;
            FXMLLoader loader = new FXMLLoader(QuizController.class.getResource( "/views/Quiz.fxml" ));
            try {
                Node main = SceneManager.getMain();
                Node node = loader.load();
                node.setLayoutX(300);
                node.setLayoutY(150);
                SceneManager.getMain().getChildren().add(node);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}

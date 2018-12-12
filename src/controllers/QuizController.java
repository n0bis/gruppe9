/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import missions.Quiz;
import worldofzuul.StartGame;

/**
 * FXML Controller class
 *
 * @author madsfalken
 */
public class QuizController implements Initializable {
    
    StartGame startGame = new StartGame();
    private Quiz quiz;
    public static boolean hasAnswered = false;
    public static boolean isActive = false;
    public static boolean isCorrect;
    private static Stage dialog;
    
    @FXML
    private FlowPane flowPane;
    @FXML
    private Label labelTitle;
    @FXML
    private TextArea smsTextbox;
    @FXML
    private Button closeButton;
    @FXML
    private AnchorPane rootId;
    @FXML
    private Button option1;
    @FXML
    private Button option2;
    @FXML
    private Button option3;
    @FXML
    private Group optionsGroup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        flowPane.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("/images/menu/smartphone.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }

    @FXML
    private void closeButtonClicked(MouseEvent event) {
        if(closeButton.getOpacity() == 0.0) {
            return;
        }     
        if (dialog == null) {
            SceneManager.getMain().getChildren().removeAll(rootId, flowPane, labelTitle, smsTextbox, option1, option2, option3, closeButton);
        } else {
            dialog.close();
        }
    }
    
    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
        Collections.shuffle(quiz.getOptions(), new Random());
        smsTextbox.setText(quiz.getDescription());
        option1.setText(quiz.getOptions().get(0));
        option2.setText(quiz.getOptions().get(1));
        option3.setText(quiz.getOptions().get(2));
    }
    
    @FXML
    private void option1Clicked(MouseEvent event) {
        answerQuiz(quiz.getOptions().get(0));
    }

    @FXML
    private void option2Clicked(MouseEvent event) {
        answerQuiz(quiz.getOptions().get(1));
    }

    @FXML
    private void option3Clicked(MouseEvent event) {
        answerQuiz(quiz.getOptions().get(2));
    }
    
    private void answerQuiz(String quess) {
        if (quess.equals(quiz.getAnswer())) {
            smsTextbox.appendText("\n\n" + "You: I think it's " + quess +  "\n\n" + "That's right!");
            isCorrect = true;
        } else {
            smsTextbox.appendText("\n\n" + "You: I think it's " + quess + "\n\n" + "Sadly that's wrong my friend.");
            isCorrect = false;
        }
        optionsGroup.setOpacity(0);
        closeButton.setOpacity(1);
        hasAnswered = true;
        isActive = false;
    }
    
    public static void isQuizTime(Quiz quiz) {
        isActive = true;
        Platform.runLater(() -> {
            FXMLLoader loader = new FXMLLoader(QuizController.class.getResource( "/views/Quiz.fxml" ));
            try {
                Node node = loader.load();
                QuizController controller = loader.getController();
                controller.setQuiz(quiz);
                node.setLayoutX(300);
                node.setLayoutY(150);
                SceneManager.getMain().getChildren().add(node);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
    
    public static Stage isQuizTimeDialog(Quiz quiz) throws IOException {
        dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader(QuizController.class.getResource( "/views/Quiz.fxml" ));
        Parent root = loader.load();
        QuizController controller = loader.getController();
        controller.setQuiz(quiz);
        Scene scene = new Scene(root);
        dialog.setScene(scene);
        dialog.setAlwaysOnTop(true);
        dialog.setResizable(false);
        return dialog;
    }
}

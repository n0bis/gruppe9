/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import controllers.INavigate;
import controllers.MenuController;
import controllers.SceneManager;
import controllers.SpookyController;
import java.io.IOException;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import utils.TimeExpired;
import utils.TimeRemaining;
import utils.TimerScore;
import world.Game;

/**
 *
 * @author madsfalken
 */
public class StartGame extends Application {
    
    public static Game game = new Game();
    public static Stage primaryStage = new Stage();
    public static String imageSelector;
    public static String playerName;
    
    @Override
    public void start(Stage startStage) throws IOException {
        this.primaryStage = startStage;
        Parent root = FXMLLoader.load(getClass().getResource("/views/StartGameFXML.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/base.css");
        primaryStage.setTitle("SDU Maze");
        primaryStage.setScene(scene);
        primaryStage.show();
    }      

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        StartGame.playerName = playerName;
    }
    
    public String getImageSelector() {
        return imageSelector;
    }

    public void setImageSelector(String imageSelector) {
        this.imageSelector = imageSelector;
    }
    
    
    public void second() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/views/Intro.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/base.css");
        primaryStage.setTitle("SDU Maze");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void third() {
        primaryStage.close();
        BorderPane borderPane = new BorderPane();
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("/views/Menu.fxml")
        );
        try {
            borderPane.setBottom(loader.load());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        MenuController menuController = loader.<MenuController>getController();
        
        Scene scene = new Scene(borderPane, 890, 700);
    
        scene.getStylesheets().add("/styles/base.css");
        
        SceneManager sceneManager = new SceneManager(borderPane);
        sceneManager.addScene("outsideTekFar", menuController);
        sceneManager.addScene("outsideTekClose", menuController);
        sceneManager.addScene("tekHall", menuController);
        sceneManager.addScene("tekHallStairs", menuController);
        sceneManager.addScene("entranceToStudyRooms", menuController);
        sceneManager.addScene("studRooms", menuController);
        sceneManager.addScene("towardsByg441", menuController);
        sceneManager.addScene("towardsByg442", menuController);
        sceneManager.addScene("bygning44", menuController);
        sceneManager.addScene("bygning44Lvl3", menuController);
        sceneManager.addScene("towardsU183", menuController);
        sceneManager.addScene("U183", menuController);
        sceneManager.addScene("bygning44TowardsLvl1", menuController);
        sceneManager.addScene("bygning44Lvl1", menuController);
        sceneManager.addScene("towardsMainhall1", menuController);
        sceneManager.addScene("towardsMainhall2", menuController);
        sceneManager.addScene("towardsMainhall3", menuController);
        sceneManager.addScene("mainhallRightOrLeft", menuController);
        sceneManager.addScene("towardsU45", menuController);
        sceneManager.addScene("mainhall1", menuController);
        sceneManager.addScene("mainhall2", menuController);
        sceneManager.addScene("mainhall", menuController);
        sceneManager.addScene("mainhall3", menuController);
        sceneManager.addScene("mainhall4", menuController);
        sceneManager.addScene("mainhall5", menuController);
        sceneManager.addScene("mainhall6", menuController);
        sceneManager.addScene("mainhall7", menuController);
        sceneManager.addScene("Library", menuController);
        sceneManager.addScene("LibraryEntrance", menuController);
        sceneManager.addScene("fitnessstairs", menuController);
        sceneManager.addScene("bossEntrance", menuController);
        sceneManager.addScene("bossFight", menuController);
        sceneManager.addScene("U45", menuController);
        sceneManager.addScene("towardsToilets", menuController);
        sceneManager.addScene("toilets", menuController);
        sceneManager.addScene("entranceToTorvet", menuController);
        sceneManager.addScene("torvet", menuController);
        sceneManager.addScene("torvet2", menuController);
        sceneManager.addScene("Coffee", menuController);
        sceneManager.addScene("modU140", menuController);
        sceneManager.addScene("communityAreaU140", menuController);
        sceneManager.addScene("entranceU140", menuController);
        sceneManager.addScene("towardsU1", menuController);
        sceneManager.addScene("notMainhall", menuController);
        sceneManager.addScene("notMainhall2", menuController);
        sceneManager.addScene("notMainhall3", menuController);
        sceneManager.addScene("entranceU27a", menuController);
        sceneManager.addScene("entranceU1", menuController);
        sceneManager.addScene("stairsTowardsNedenUnder", menuController);
        sceneManager.addScene("nedenUnder", menuController);
        sceneManager.addScene("nedenUnderToilets", menuController);
        sceneManager.addScene("outsideU133", menuController);
        sceneManager.addScene("U133", menuController);
        sceneManager.addScene("U55", menuController);
        sceneManager.addScene("backToMainhall", menuController);
        //sceneManager.addScene("WorldOfZuulGUI", menuController);
                
        Timer timer = new Timer();
        timer.schedule(new TimeRemaining(), TimeUnit.MINUTES.toMillis(5));
        timer.schedule(new TimeExpired(), TimeUnit.MINUTES.toMillis(20));
        //timer.schedule(new QuizController(), TimeUnit.SECONDS.toMillis(2));
        TimerScore.startTimer();
        
        SceneManager.activate("outsideTekFar");
        //SceneManager.activate("WorldOfZuulGUI");
        
        borderPane.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            if (INavigate.class.isAssignableFrom(SceneManager.getController().getClass())) {
                INavigate navigation = (INavigate)SceneManager.getController();
                try {
                    switch (keyEvent.getCode()) {
                        case UP:
                        case W:
                            navigation.arrowUpClicked(null);
                            break;
                        case DOWN:
                        case S:
                            navigation.arrowBackClicked(null);
                            break;
                        case RIGHT:
                        case D:
                            navigation.arrowRightClicked(null);
                            break;
                        case LEFT:
                        case A:
                            navigation.arrowLeftClicked(null);
                            break;
                    }
                } catch (UnsupportedOperationException ex) {
                    // We don't care
                }
            }
        });
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setOnCloseRequest((value) -> timer.cancel());
    }
     
    public static void main(String[] args) throws IOException {
        launch(args);
    }
}

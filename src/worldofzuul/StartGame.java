/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import controllers.MenuController;
import controllers.SceneManager;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import world.Game;

/**
 *
 * @author madsfalken
 */
public class StartGame extends Application {
    
    public static Game game = new Game();
    
    @Override
    public void start(Stage primaryStage) {
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
        
        Scene scene = new Scene(borderPane);
        
        scene.getStylesheets().add("/styles/base.css");
        
        SceneManager sceneManager = new SceneManager(borderPane);
        sceneManager.addScene("WorldOfZuulGUI", menuController);
        sceneManager.addScene("ChildRoom");
        sceneManager.addScene("Hall", menuController);
        
        SceneManager.activate("WorldOfZuulGUI");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setOnCloseRequest((value -> System.exit(0)));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

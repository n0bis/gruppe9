/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author madsfalken
 */
public final class SceneManager {
    private static HashMap<String, SceneMapper> sceneMap = new HashMap<>();
    private static BorderPane main;
    private static String currentScene;
    
    public SceneManager(BorderPane main) {
        this.main = main;
    }
    
    public void addScene(String name, MenuController menuController) {
        try {
            FXMLLoader loader = new FXMLLoader((getClass().getResource( "/views/" + name + ".fxml" )));
            Pane pane = loader.load();
            if (loader.getController() instanceof UpperClass) {
                UpperClass controller = loader.<UpperClass>getController();
                controller.init(menuController);
            }
            sceneMap.put(name, new SceneMapper(loader.getController(), pane));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void addScene(String name) {
        try {
            FXMLLoader loader = new FXMLLoader((getClass().getResource( "/views/" + name + ".fxml" )));
            Pane pane = loader.load();
            sceneMap.put(name, new SceneMapper(loader.getController(), pane));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void removeScene(String name) {
        sceneMap.remove(name);
    }
    
    public static void activate(String name) {
        currentScene = name;
        Pane node = sceneMap.get(name).getPane();
        // Epic hack for resetting transition animation
        node.setOpacity(1);
        main.setCenter(node);
    }
    
    public static BorderPane getMain() {
        return main;
    }
    
    public static <T> T getController() {
        return (T) sceneMap.get(currentScene).getController();
    }

}

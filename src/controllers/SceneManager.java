/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.QuizController.hasAnswered;
import static controllers.QuizController.isQuizTime;
import controllers.Stenten.NedenUnderController;
import controllers.mainEntrance.TorvetController;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import missions.Quiz;
import utils.SoundMapper;
import static world.Game.coffeeDrink;
import static world.Game.player;
import worldofzuul.StartGame;


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
            if (loader.getController() instanceof MenuControllerInjection) {
                MenuControllerInjection controller = loader.<MenuControllerInjection>getController();
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
        if (IPlaySound.class.isAssignableFrom(getController().getClass())) {
            SoundMapper source = ((IPlaySound)getController()).mapSound();
            ((MenuControllerInjection)getController()).playSound(source);
        } else {
            ((MenuControllerInjection)getController()).destroyPlayer();
        }
        if (getController() instanceof NedenUnderController) {
            NedenUnderController controller = getController();
            controller.setHighScore();
        }
        main.setCenter(node);
        if (player.hasItem(coffeeDrink) && !MenuControllerInjection.challengeWon) {
            MenuControllerInjection controller = getController();
            controller.injectCoffee();
        }
        if (SceneManager.getController() instanceof TorvetController) {
            if (!hasAnswered) {
                isQuizTime(new Quiz("Hey " + StartGame.playerName + " which room is COS", Arrays.asList("u45", "u55", "u57"), "u45"));
            }
        }
    }
    public static BorderPane getMain() {
        return main;
    }
    
    public static <T> T getController() {
        return (T) sceneMap.get(currentScene).getController();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import utils.SoundMapper;
import controllers.GydehuttenSouth.ToiletsController;
import controllers.Stenten.NedenUnderToiletsController;
import utils.TimeExpired;

/**
 *
 * @author madsfalken
 */
public class MenuControllerInjection {
    public MenuController menuController;
    private static MediaPlayer mediaPlayer;
    
    public void init(MenuController menuController) {
        this.menuController = menuController;
    }      
    
    public void playSound(SoundMapper mapper) {
        if (mediaPlayer != null) mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(new Media(getClass().getResource(mapper.getSource()).toExternalForm()));
        mediaPlayer.setVolume(mapper.getVolume());
        mediaPlayer.play();
    }
    
    public void destroyPlayer() {
        mediaPlayer.stop();
    }
    public static boolean challengeWon = false;
    private static int counterSteps = 0;
    public void injectCoffee() {
        counterSteps++;
        if (counterSteps == 20) {
            TimeExpired youLost = new TimeExpired();
            youLost.run();
        } else if (SceneManager.getController() instanceof ToiletsController || SceneManager.getController() instanceof NedenUnderToiletsController) {
            challengeWon = true;
            menuController.SpeechText("Congrats you found the toilet in under 20 moves so now you can pee in peace");
        } else {
            menuController.SpeechText("You have used " + counterSteps + " move out of 20 moves ");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import utils.SoundMapper;

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
        mediaPlayer = new MediaPlayer(new Media(getClass().getResource(mapper.getSource()).toExternalForm()));
        mediaPlayer.setVolume(mapper.getVolume());
        mediaPlayer.play();
    }
    
    public void destroyPlayer() {
        mediaPlayer.stop();
    }
}

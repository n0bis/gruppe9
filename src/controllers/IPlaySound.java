/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author madsfalken
 */
public interface IPlaySound {
    public MediaPlayer mediaPlayer = new MediaPlayer(null);
    
    default void playSound() {
        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();
    }
    
    static MediaPlayer setMedia() {
        return new MediaPlayer(new Media(IPlaySound.class.getResource(IPlaySound.getSoundPath()).toExternalForm()));
    }
    
    static String getSoundPath() {
        return "";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.GydehuttenSouth.ToiletsController;
import controllers.Stenten.NedenUnderToiletsController;
import utils.TimeExpired;

/**
 *
 * @author madsfalken
 */
public class MenuControllerInjection {
    public MenuController menuController;
    
    public void init(MenuController menuController) {
        this.menuController = menuController;
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

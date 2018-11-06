/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import WoZTimer.*;
import java.util.TimerTask;

/**
 *
 * @author birke
 */
public class TimeExpired extends TimerTask {
    @Override
    public void run() {
        System.out.println("Time expired - You lost");
        System.exit(0);
    }
}

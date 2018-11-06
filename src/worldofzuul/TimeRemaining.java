/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import java.util.TimerTask;

/**
 *
 * @author birke
 */
public class TimeRemaining extends TimerTask  {
    @Override
    public void run() {
        System.out.println("SMS from hot student nurse!");
        System.out.println("Hey will you be here in 10 minutes ;)?");
    }
}

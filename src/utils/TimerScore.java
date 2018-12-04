/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 */
package utils;
/**
 *
 * @author morte
 */
public class TimerScore {
    
    private static long time;
    
    public static void startTimer() {
        time = System.currentTimeMillis();
    }

    public static long getTime() {
        return time;
    }
    
    
}

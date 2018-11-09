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
    
    private long time;
    
    public TimerScore() {
    }
    
    public void startTimer() {
        this.time = System.currentTimeMillis();
    }
    
    public boolean checkTimer() {
        return (time <= System.currentTimeMillis());
    }

    public long getTime() {
        return time;
    }
    
    
}

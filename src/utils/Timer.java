/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 */
package utils;
/**
 *
 * @author morte
 */
public class Timer {
    
    private long time;
    
    public Timer(){
    }
    
    public void startTimer(int timeToDo){
        this.time = System.currentTimeMillis() + timeToDo;
    }
    
    public boolean checkTimer() {
        return (time <= System.currentTimeMillis());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 */
package worldofzuul;
/**
 *
 * @author morte
 */
public class Timer {
    private long time;
    public Timer(){
        
    }
    public void startTimer(int timeToDo){
        time = System.currentTimeMillis() + timeToDo;
        
    }
    public boolean checkTimer() {
        if (time <= System.currentTimeMillis())
            return false;
        else
            return true;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author madsfalken
 */
public class SoundMapper {

    private double volume;
    private String source;

    public SoundMapper(double volume, String source) {
        this.volume = volume;
        this.source = source;
    }

    public SoundMapper(String source) {
        this.volume = 0.5;
        this.source = source;
    }

    public double getVolume() {
        return volume;
    }

    public String getSource() {
        return source;
    }
    
    
}

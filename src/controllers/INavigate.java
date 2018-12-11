/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javafx.scene.input.MouseEvent;

/**
 *
 * @author madsfalken
 */
public interface INavigate {
    
    public void arrowUpClicked(MouseEvent event);
    
    public void arrowBackClicked(MouseEvent event);
    
    public void arrowRightClicked(MouseEvent event);
    
    public void arrowLeftClicked(MouseEvent event);
    
}

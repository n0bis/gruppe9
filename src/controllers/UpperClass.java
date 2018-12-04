/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author madsfalken
 */
public class UpperClass {
    public MenuController menuController;
    
    public void init(MenuController menuController) {
        this.menuController = menuController;
    }      
}

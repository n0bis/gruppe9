/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javafx.scene.layout.Pane;

/**
 *
 * @author madsfalken
 */
public class SceneMapper<T> {
    
    private final T controller;
    private final Pane pane;
    
    public SceneMapper(T controller, Pane pane) {
        this.controller = controller;
        this.pane = pane;
    }

    public T getController() {
        return controller;
    }

    public Pane getPane() {
        return pane;
    }
    
    
}

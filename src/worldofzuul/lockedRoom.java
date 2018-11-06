/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NidaBasaran
 */


public class lockedRoom extends Room {
    private List<Item> requiredItems = new ArrayList<>();

    public lockedRoom(String description, List<Item> requiredItems) {
        super(description);
        this.requiredItems = requiredItems;
    }
    
    public boolean canEnter(List<Item> item) {
        return item.containsAll(this.requiredItems);
    }
}
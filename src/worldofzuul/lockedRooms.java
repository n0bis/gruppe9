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


public class lockedRooms extends Room {

    public lockedRooms(String description) {
        super(description);
    }
    private final List<Item> requiredItems = new ArrayList<>(); 

    public boolean canEnter(List<Item> Items) {
        boolean blocked = true;
        if (Items.isEmpty()) return blocked;
        if (this.requiredItems==null) return blocked;
        return true;
    }
}
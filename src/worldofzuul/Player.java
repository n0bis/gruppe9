package worldofzuul;

import java.util.ArrayList;

public class Player {
    public ArrayList<Item> inventory = new ArrayList<Item>();
    Item item;
    
    public Player() {
        
    }
    
    public void addItem(Item item) {
        inventory.add(item);
    }
    
    
    
}

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
    
    public void getInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Too bad. You got no items hombré!");
        } else {
            System.out.println("### You inventory is: ###");
            for(Item item : inventory) {
                System.out.println("- " + item.name + " ");
            }
        }
    }
}

package worldofzuul;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private NPC npc;
    public ArrayList<Item> inventory = new ArrayList<Item>();
    public List<Quest> questLog = new ArrayList<>();
    
    public Player() {
        
    }
    
    public boolean hasItem(Item item) {
        return this.inventory.contains(item);
    }
    
    public boolean hasQuest(Quest quest) {
       return this.questLog.contains(quest);
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

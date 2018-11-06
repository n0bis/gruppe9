package worldofzuul;

import java.util.ArrayList;


public class Player {
    public ArrayList<Item> inventory = new ArrayList<Item>();  
    private String name;
    private String major;
   
    public Player() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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

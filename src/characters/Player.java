package characters;

import items.Item;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.ImageView;
import missions.Quest;


public class Player {
    private NPC npc;
    public List<Item> inventory = new ArrayList<>();
    public List<Quest> questLog = new ArrayList<>();
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
    
    public boolean hasItem(Item item) {
        return this.inventory.contains(item);
    }
    
    public boolean hasQuest(Quest quest) {
       return this.questLog.contains(quest);
    }
    public void removeQuest(Quest quest) {
        questLog.remove(quest);
    }
    public void addQuest(Quest quest) {
        questLog.add(quest);
    }
    
    public void addItem(Item item) {
        inventory.add(item);
    }
    public List<Item> getInventory() {
        return this.inventory;
    }
    
    public List<Quest> getQuestLog() {
        return this.questLog;
    }

    public void addItem(ImageView bone1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

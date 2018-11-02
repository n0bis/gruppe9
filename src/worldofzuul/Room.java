package worldofzuul;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    public Item item;
    public NPC npc;

    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    private String getExitString()
    {
        return exits.keySet().stream().map((exit) -> " " + exit).reduce("Exits:", String::concat);
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    public void setItem (Item item) {
        this.item = item;
    }

    public Item getItem() {
        return this.item;
    }
    
    public void setNPC (NPC npc) {
        this.npc = npc;
    }

    public NPC getNPC() {
        return npc;
    }
    
    public boolean hasNPC() {
        return (this.npc != null);
    }
    
    
    
    
}


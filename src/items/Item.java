package items;

public class Item {
    
    String name;
    int id;
    
    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public static Item bok = new Item("Bog navn", 1);
    
}

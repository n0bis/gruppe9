package items;

public class Spell {
    String name;
    int id;
    
    public Spell(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
}

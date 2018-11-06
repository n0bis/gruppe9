package worldofzuul;

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
    
    @Override
    public String toString() {
        return this.name;
    }
    
}

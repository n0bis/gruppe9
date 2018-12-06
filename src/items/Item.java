package items;

import javafx.scene.image.Image;

public class Item {
    
    private String name;
    private int id;
    private Image image;
    
    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Item(String coin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Image getImage() {
        try {
            return new Image(getClass().getResourceAsStream("/images/items/" + this.name.toLowerCase() + ".png"));
        } catch (NullPointerException ex) {
            return null;
        }
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
}

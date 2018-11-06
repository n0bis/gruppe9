package worldofzuul;


public class Boss {
    /* Boss concept:
    - Boss has 3 quests that needs to be completed in order to kill him
    - If you do not complete the 3 things, you will be thrown back
    - One command will be a spell
    
    Problem: go commands will still show?
    */
    String name;
    String dialogue;
    Item questItem1;
    Item questItem2;
    String questSpell;
    int stage;
    
    Player player;
    Game game;
    
    
    
    public Boss(String name, String dialogue, Item questItem1, Item questItem2,
            String questSpell) {
        this.name = name;
        this.dialogue = dialogue;
        this.questItem1 = questItem1;
        this.questItem2 = questItem2;
        this.questSpell = questSpell;
        this.stage = 1;
        
    }
    
    public boolean quest1() {
        if(player.inventory.size() > 0) {
            for(Item item : player.inventory) {
                if(item == questItem1) {
                    game.textDelay("You have killed my Frosthead with fire, but I still have my Ironhead! Muhahahaha");
                    return true;
                }
            }
        }
        return false;
    }
    
}

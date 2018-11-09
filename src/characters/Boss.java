package characters;

import items.Item;
import world.Game;


public class Boss {
    /* Boss concept:
    - Boss has 3 quests that needs to be completed in order to kill him
    - If you do not complete the 3 things, you will be thrown back
    - One command will be a spell
    
    Problem: go commands will still show?
    */
    private String name;
    private String dialogue;
    private Item questItem1;
    private Item questItem2;
    private String questSpell;
    private int stage;
    
    private Player player;
    private Game game;
    
    
    
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDialogue() {
        return dialogue;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }

    public Item getQuestItem1() {
        return questItem1;
    }

    public void setQuestItem1(Item questItem1) {
        this.questItem1 = questItem1;
    }

    public Item getQuestItem2() {
        return questItem2;
    }

    public void setQuestItem2(Item questItem2) {
        this.questItem2 = questItem2;
    }

    public String getQuestSpell() {
        return questSpell;
    }

    public void setQuestSpell(String questSpell) {
        this.questSpell = questSpell;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }
    
    public void incrementStage() {
        this.stage += 1;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    
    
    
}

package characters;

import items.Item;
import java.util.Scanner;
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
    
    public Boss(String name, String dialogue, Item questItem1, Item questItem2,
            String questSpell) {
        this.name = name;
        this.dialogue = dialogue;
        this.questItem1 = questItem1;
        this.questItem2 = questItem2;
        this.questSpell = questSpell;
        this.stage = 1;
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
}

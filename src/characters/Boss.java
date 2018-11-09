package characters;

import items.Item;


public class Boss {
    /* Boss concept:
    - Boss has 3 quests that needs to be completed in order to kill him
    - If you do not complete the 3 things, you will be thrown back
    - One command will be a spell
    
    Problem: go commands will still show?
    */
    private String name;
    private String dialogue;
    private Item stage1RequiredItem;
    private Item stage2RequiredItem;
    private String questSpell;
    private int stage;
    
    public Boss(String name, String dialogue, Item stage1RequiredItem, Item stage2RequiredItem,
            String questSpell) {
        this.name = name;
        this.dialogue = dialogue;
        this.stage1RequiredItem = stage1RequiredItem;
        this.stage2RequiredItem = stage2RequiredItem;
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

    public Item getStage1RequiredItem() {
        return stage1RequiredItem;
    }

    public void setStage1RequiredItem(Item stage1RequiredItem) {
        this.stage1RequiredItem = stage1RequiredItem;
    }

    public Item getStage2RequiredItem() {
        return stage2RequiredItem;
    }

    public void setStage2RequiredItem(Item stage2RequiredItem) {
        this.stage2RequiredItem = stage2RequiredItem;
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

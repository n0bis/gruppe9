
package worldofzuul;

public class NPC {
    String name;
    String dialogue;
    String quest;
    String questDone;
    Item needItem;
    Item questItem;
    Item item;
    Item giveItem;

    
    
    public NPC(String name, String dialogue, String quest, String questDone, Item needItem, Item giveItem) {
        this.name = name;
        this.dialogue = dialogue;
        this.quest = quest;
        this.questDone = questDone;
        this.needItem = needItem;
        this.giveItem = giveItem;
    }
    
    @Override
    public String toString() {
        return this.name;
    }

    public String getDialogue() {
        return dialogue;
    }
    
    public void setQuestItem(Item questItem) {
        this.questItem = questItem;
    }
    
    
}

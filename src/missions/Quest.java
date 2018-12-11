package missions;

import items.Item;

public class Quest {
    private String name;
    private String questDescription;
    private String questInProgress;
    private String questDone;
    private boolean isQuestDone;
    private Item rewardItem;
    private Item requiredItem;
    private Item requiredItem2;
    private Item requiredItem3;

    public Quest(String name, String questDescription, String questInProgress, String questDone, Item rewardItem, Item requiredItem) {
        this.name = name;
        this.questDescription = questDescription;
        this.questInProgress = questInProgress;
        this.questDone = questDone;
        this.isQuestDone = false;
        this.rewardItem = rewardItem;
        this.requiredItem = requiredItem;
    }
    
    public Quest(String name, String questDescription, String questInProgress, String questDone, Item requiredItem1, Item requiredItem2, Item requiredItem3) {
        this.name = name;
        this.questDescription = questDescription;
        this.questInProgress = questInProgress;
        this.questDone = questDone;
        this.isQuestDone = false;
        this.requiredItem = requiredItem1;
        this.requiredItem2 = requiredItem2;
        this.requiredItem3 = requiredItem3;
    }

    public boolean isQuestDone() {
        return isQuestDone;
    }       
    
    // Getters

    public String getQuestDescription() {
        return questDescription;
    }

    public String getQuestInProgress() {
        return questInProgress;
    }

    public String getQuestDone() {
        return questDone;
    }

    public Item getRewardItem() {
        return rewardItem;
    }

    public Item getRequiredItem() {
        return requiredItem;
    }

    public void setIsQuestDone(boolean isQuestDone) {
        this.isQuestDone = isQuestDone;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String toString() {
        return this.name;
    }
    
    
}   

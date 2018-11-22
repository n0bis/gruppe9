package missions;

import items.Item;

public class Quest {
    private String questDescription;
    private String questInProgress;
    private String questDone;
    private boolean isQuestDone;
    private Item rewardItem;
    private Item requiredItem;

        public Quest(String questDescription, String questInProgress, String questDone, Item rewardItem, Item requiredItem) {
        this.questDescription = questDescription;
        this.questInProgress = questInProgress;
        this.questDone = questDone;
        this.isQuestDone = false;
        this.rewardItem = rewardItem;
        this.requiredItem = requiredItem;
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
    
    
    
    
}   

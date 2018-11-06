/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

/**
 *
 * @author NidaBasaran
 */
public class Quest {
    private String description;
    private String doneSpeech;
    private boolean done;
    private Item rewardItem;
    private Item requiredItem;

    public Quest(String description, String doneSpeech, boolean done, Item rewardItem, Item requiredItem) {
        this.description = description;
        this.doneSpeech = doneSpeech;
        this.done = done;
        this.rewardItem = rewardItem;
        this.requiredItem = requiredItem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDoneSpeech() {
        return doneSpeech;
    }

    public void setDoneSpeech(String doneSpeech) {
        this.doneSpeech = doneSpeech;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Item getRewardItem() {
        return rewardItem;
    }

    public void setRewardItem(Item rewardItem) {
        this.rewardItem = rewardItem;
    }

    public Item getRequiredItem() {
        return requiredItem;
    }

    public void setRequiredItem(Item requiredItem) {
        this.requiredItem = requiredItem;
    }
   
}

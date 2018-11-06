
package worldofzuul;

import java.util.ArrayList;
import java.util.List;

public class NPC {
    String name;
    String dialogue;
    String inprogressSpeech;
    List<Quest> quests = new ArrayList<>();

    public NPC(String name, String dialogue, String inprogressSpeech, List<Quest> quests) {
        this.name = name;
        this.dialogue = dialogue;
        this.inprogressSpeech = inprogressSpeech;
        this.quests = quests;
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

    public String getInprogressSpeech() {
        return inprogressSpeech;
    }

    public void setInprogressSpeech(String inprogressSpeech) {
        this.inprogressSpeech = inprogressSpeech;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }
    
    public void addQuest(Quest quest) {
        this.quests.add(quest);
    } 
    
    public boolean hasQuest() {
        for(Quest quest : this.quests) {
            if(!quest.isDone()) {
                return true;
            }
        }
        
        return false;
    }
}

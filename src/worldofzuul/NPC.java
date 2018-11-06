
package worldofzuul;

import java.util.ArrayList;
import java.util.List;

public class NPC {
    String name;
    String dialogue;
    String questsDone;
    List<Quest> quests = new ArrayList<>();

    // Quest is added to QuestList via method

    public NPC(String name, String dialogue, String questsDone) {
        this.name = name;
        this.dialogue = dialogue;
        this.questsDone = questsDone;
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
            if(!quest.isQuestDone()) {
                return true;
            }
        }
        
        return false;
    }
}

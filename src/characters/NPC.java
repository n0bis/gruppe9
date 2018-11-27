
package characters;

import java.util.ArrayList;
import java.util.List;
import missions.Quest;


public class NPC {
    private String name;
    private String dialogue;
    private String questsDone;
    public static List<Quest> quests = new ArrayList<>(); 
    
    
    public NPC() {
        
    }
    
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

    public String getQuestsDone() {
        return questsDone;
    }

    public void setQuestsDone(String questsDone) {
        this.questsDone = questsDone;
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

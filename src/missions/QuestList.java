/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missions;

import static world.Game.Bookie;
import static world.Game.boneone;
import static world.Game.bonethree;
import static world.Game.bonetwo;
import static world.Game.teeth;

/**
 *
 * @author birke
 */
public class QuestList {
    public static Quest sackQuest = new Quest("Find my book", "This is the quest description: Find my book", "Quest is in progress: You still need to find my book", "The quest is "
            + "done", teeth, Bookie);
    public static Quest doctorQuest = new Quest("Find my bones", "I need you to find 3 bones", "You still need to find all 3 bones", "Uhh, thanks for the help boy. I've unlocked the hallways again", boneone, bonetwo, bonethree);
}

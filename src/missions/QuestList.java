/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missions;

import static world.Game.Bookie;
import static world.Game.CreepyDoll;
import static world.Game.teeth;
import static world.Game.TeddyBear;

/**
 *
 * @author birke
 */
public class QuestList {
    public static Quest sackQuest = new Quest("Find my book", "This is the quest description: Find my book", "Quest is in progress: You still need to find my book", "The quest is "
            + "done", teeth, Bookie);    
    
    public static Quest Twin1Quest = new Quest("Find my teddy bear!", "Find teddy bear", "You still need to find my teddy bear!", "The quest is "
            + "done", null, TeddyBear);
    public static Quest Twin2Quest = new Quest("Find my teddy bear!", "Find teddy bear", "You still need to find my teddy bear!", "The quest is "
            + "done", null, CreepyDoll);
}

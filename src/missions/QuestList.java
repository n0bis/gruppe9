/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missions;

import static world.Game.Bookie;
import static world.Game.teeth;

/**
 *
 * @author birke
 */
public class QuestList {
    public static Quest sackQuest = new Quest("Find my book", "This is the quest description: Find my book", "Quest is in progress: You still need to find my book", "The quest is "
            + "done", teeth, Bookie);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missions;

import static world.Game.Bookie;
import static world.Game.creepyDoll;
import static world.Game.boneone;
import static world.Game.bonethree;
import static world.Game.bonetwo;
import static world.Game.teeth;
import static world.Game.creepyBear;
import static world.Game.toiletpaper;

public class QuestList {
    public static Quest sackQuest = new Quest("Find my book", "This is the quest description: Find my book", "Quest is in progress: You still need to find my book", "The quest is "
            + "done", teeth, Bookie);    
    public static Quest Twin1Quest = new Quest("Find my bear!", "I've lost my bear... If you find my bear I'll let you pass. I'll give you a hint, walk past krogene", "You still need to find my bear!", "Yaaay, thanks you Mister"
           , null, creepyBear);
    public static Quest Twin2Quest = new Quest("Find my doll", "I've lost my doll... If you find my doll I'll let you pass. I'll give you a hint, you have to go through vangene", "You still need to find my doll!", "Thanks for helping me, Mister."
           , null, creepyDoll);
public static Quest doctorQuest = new Quest("Find my bones", "I need you to find 3 bones", "You still need to find all 3 bones", "Uhh, thanks for the help boy. I've unlocked the hallways again", boneone, bonetwo, bonethree);
    public static Quest mummyQuest = new Quest("Find me some toiletpaper", "I need you to find me some toiletpaper because this is getting too old", "You still need to get me toiletpaper", "Thank you! Now I feel so young. I've unlocked the hallways again", toiletpaper);

}

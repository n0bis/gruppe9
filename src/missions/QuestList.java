/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missions;

import static world.Game.creepyDoll;
import static world.Game.boneone;
import static world.Game.bonethree;
import static world.Game.bonetwo;
import static world.Game.creepyBear;
import static world.Game.pieceOfLeg;
import static world.Game.toiletpaper;

public class QuestList {
    
    public static Quest Twin1Quest = new Quest("Find my bear!", "I've lost my bear... If you find my bear I'll let you pass. I'll give you a hint, walk past krogene", "You still need to find my bear!", "The quest is "
            + "done", null, creepyBear);
    
    public static Quest Twin2Quest = new Quest("Find my doll", "I've lost my doll... If you find my doll I'll let you pass. I'll give you a hint, you have to go through vangene", "You still need to find my doll!", "The quest is "
            + "done", null, creepyDoll);
    
    public static Quest doctorQuest = new Quest("Find my bones", "I need you to find 3 bones", "You still need to find all 3 bones", "Uhh, thanks for the help boy. I've unlocked the hallways again and granted you some leg", boneone, bonetwo, bonethree, pieceOfLeg);
    
    public static Quest mummyQuest = new Quest("Find me some toiletpaper", "You can't go straight because it's locked, if you find me some toiletpaper I'll unlock it.", "You still need to get me toiletpaper", "Thank you! Now I feel so young. I've unlocked the hallways again", toiletpaper);


}

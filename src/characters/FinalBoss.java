/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

import items.Item;
import java.util.Scanner;

/**
 *
 * @author madsfalken
 */
public class FinalBoss extends Boss {
    
    public FinalBoss(Item stage1RequiredItem, Item stage2RequiredItem) {
        super("Cerberus", "Wufhahaha, I am Cerberus. The 3 headed dawg. 1 head of Fire, 1 of Metal and 1 of Stone", stage1RequiredItem, stage2RequiredItem,
            "Wingardium Leviosa");
    }
    
    public boolean wonStage1(Scanner scanner, Player player) {
        System.out.println(this.getDialogue());
        System.out.println("Do you want to fight me pleb? (Yes or no)");
        String fightAnswer = scanner.nextLine();

        if(fightAnswer.equalsIgnoreCase("Yes")) {
            return player.inventory.contains(this.getStage1RequiredItem());
        }
        return false;
    }
    
    public boolean wonStage2(Player player) {
        System.out.println("Ohh, you might have killed my first head, but I still have my Metalhead. FeelsGoodMan");
        
        return player.inventory.contains(this.getStage2RequiredItem());
    }
    
    public boolean wonStage3(Scanner scanner, Player player) {
        String spell = "Fireball";
        String spellCast;
        
        System.out.println("You have killed 2 of my heads, but this last one, only a spell can kill.");
        System.out.println("Enter your spell:");
        spellCast = scanner.nextLine();

        if(spellCast.equalsIgnoreCase(spell)) {
            System.out.println("You got me. #RIP.");
            System.out.println("Now go across to party!");
            return true;
        } else {
            System.out.println("Ha-ha, wrong spell");
        }
        return false;
    }
}

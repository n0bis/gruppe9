/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

import items.Item;
import items.Spell;
import items.SpellBook;
import java.util.Scanner;

/**
 *
 * @author madsfalken
 */
public class FinalBoss extends Boss {
    
    private Item stage1RequiredItem;
    private Item stage2RequiredItem;
    private Item stage3RequiredItem;
    private Spell questSpell;
    private int stage;
    
    public FinalBoss(Item stage1RequiredItem, Item stage2RequiredItem, Item stage3RequiredItem, Spell questSpell) {
        super("Cerberus", "Wufhahaha, I am Cerberus. The 3 headed dawg. 1 head of Fire, 1 of Metal and 1 of Stone");
        this.stage1RequiredItem = stage1RequiredItem;
        this.stage2RequiredItem = stage2RequiredItem;
        this.stage3RequiredItem = stage3RequiredItem;
        this.questSpell = questSpell;
        this.stage = 1; 
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
        if (!player.inventory.contains(this.stage3RequiredItem) || !((SpellBook)this.stage3RequiredItem).hasSpell(questSpell)) {
            return false;
        }
       
        System.out.println("You have killed 2 of my heads, but this last one, only a spell can kill.");
        System.out.println("Enter your spell:");
        String spellCast = scanner.nextLine();

        if(spellCast.equalsIgnoreCase(this.questSpell.toString())) {
            System.out.println("You got me. #RIP.");
            System.out.println("Now go across to party!");
            return true;
        } else {
            System.out.println("Ha-ha, wrong spell");
        }
        return false;
    }
    
    public Item getStage1RequiredItem() {
        return stage1RequiredItem;
    }

    public void setStage1RequiredItem(Item stage1RequiredItem) {
        this.stage1RequiredItem = stage1RequiredItem;
    }

    public Item getStage2RequiredItem() {
        return stage2RequiredItem;
    }

    public void setStage2RequiredItem(Item stage2RequiredItem) {
        this.stage2RequiredItem = stage2RequiredItem;
    }

    public Item getStage3RequiredItem() {
        return stage3RequiredItem;
    }

    public void setStage3RequiredItem(Item stage3RequiredItem) {
        this.stage3RequiredItem = stage3RequiredItem;
    }
    
    public Spell getQuestSpell() {
        return questSpell;
    }

    public void setQuestSpell(Spell questSpell) {
        this.questSpell = questSpell;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }
    
    public void incrementStage() {
        this.stage += 1;
    }
}

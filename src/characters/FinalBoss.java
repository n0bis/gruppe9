/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

import controllers.FadeAnimation;
import controllers.SceneManager;
import items.Item;
import items.Spell;
import items.SpellBook;
import java.util.Scanner;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author madsfalken
 */
public class FinalBoss extends Boss {
    /* Boss concept:
    - Boss has 3 quests that needs to be completed in order to kill him
    - If you do not complete the 3 things, you will be thrown back
    - One command will be a spell
    
    Problem: go commands will still show?
    */
    private Item stage1RequiredItem;
    private Item stage2RequiredItem;
    private Item stage3RequiredItem;
    private Spell questSpell;
    private int stage;
    
    public boolean hasItem;
    
    public FinalBoss(Item stage1RequiredItem, Item stage2RequiredItem, Item stage3RequiredItem, Spell questSpell) {
        super("Cerberus", "Wufhahaha, I am Cerberus. The 3 headed dawg. 1 head of Fire, 1 of Metal and 1 of Stone");
        this.stage1RequiredItem = stage1RequiredItem;
        this.stage2RequiredItem = stage2RequiredItem;
        this.stage3RequiredItem = stage3RequiredItem;
        this.questSpell = questSpell;
        this.stage = 1; 
    }
    
    public boolean wonStage1(Player player) {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);
        Text fightText = new Text("Do you want to fight me pleb? (Yes or no)");
        Button okButton = new Button("YES");
        Button noButton = new Button("NO");
        dialogVbox.getChildren().addAll(fightText, okButton, noButton);
        Scene dialogSence = new Scene(dialogVbox);
        dialog.setScene(dialogSence);
        dialog.setAlwaysOnTop(true);
        dialog.setResizable(false);
        okButton.setOnAction((value) -> {
            dialog.close();
            hasItem = player.hasItem(this.getStage1RequiredItem());
        });
        noButton.setOnAction((value) -> {
            dialog.close();
            SceneManager.activate("Hall");
        });
        dialog.showAndWait();
        
        return hasItem;
    }
    
    public boolean wonStage2(Player player) {
        System.out.println("Ohh, you might have killed my first head, but I still have my Metalhead. FeelsGoodMan");
        
        return player.inventory.contains(this.getStage2RequiredItem());
    }
    
    public boolean wonStage3(String input, Player player) {
        if (!player.inventory.contains(this.stage3RequiredItem) || !((SpellBook)this.stage3RequiredItem).hasSpell(questSpell)) {
            return false;
        }
       
        System.out.println("You have killed 2 of my heads, but this last one, only a spell can kill.");
        System.out.println("Enter your spell:");
        String spellCast = input;

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

import controllers.QuizController;
import static controllers.QuizController.isQuizTime;
import static controllers.QuizController.isQuizTimeDialog;
import controllers.SceneManager;
import items.Item;
import items.Spell;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import missions.Quiz;
import static world.Game.fireball;
import static world.Game.spellBook;
import worldofzuul.StartGame;


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
    private Quiz stage1Quiz;
    private Quiz stage2Quiz;
    
    private Stage quizStage;
    
    public FinalBoss(Item stage1RequiredItem, Item stage2RequiredItem, Item stage3RequiredItem, Spell questSpell) {
        super("Cerberus", "Wufhahaha, I am Cerberus. The 3 headed monster dog! You will need some items to stand my tests!");
        this.stage1RequiredItem = stage1RequiredItem;
        this.stage2RequiredItem = stage2RequiredItem;
        this.stage3RequiredItem = stage3RequiredItem;
        this.questSpell = questSpell;
        this.stage = 1; 
        Quiz quiz1 = new Quiz("What is the hallway called that lead to U140", Arrays.asList("Krogene", "Knoldene", "Vangene"), "Krogene");
        Quiz quiz2 = new Quiz("What is the hallway called that lead to U133", Arrays.asList("Krogene", "Knoldene", "Vangene"), "Vangene");
        Quiz quiz3 = new Quiz("What is the hallway called that lead to U1", Arrays.asList("Krogene", "Knoldene", "Stenten"), "Stenten");
        
        List<Quiz> quizes = new LinkedList<>(Arrays.asList(quiz1, quiz2, quiz3));
        Collections.shuffle(quizes);
        stage1Quiz = quizes.get(0);
        stage2Quiz = quizes.get(1);
    }
    
    public boolean wonStage1(Player player) {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);
        Text fightText = new Text("Do you want to fight me, kid?");
        Button okButton = new Button("YES");
        Button noButton = new Button("NO");
        dialogVbox.getChildren().addAll(fightText, okButton, noButton);
        Scene dialogSence = new Scene(dialogVbox);
        dialog.setScene(dialogSence);
        dialog.setAlwaysOnTop(true);
        dialog.setResizable(false);
        
        okButton.setOnAction((value) -> {
            dialog.close();
            try {
                quizStage = isQuizTimeDialog(stage1Quiz);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        noButton.setOnAction((value) -> {
            dialog.close();
            SceneManager.activate("bossEntrance");
        });
        dialog.showAndWait();
        
        if (quizStage != null) quizStage.showAndWait();
        
        return QuizController.isCorrect;
    }
    
    public boolean wonStage2(Player player) {
        if (player.inventory.contains(this.getStage2RequiredItem())) {
            try {
                Stage dialog = isQuizTimeDialog(stage2Quiz);
                dialog.showAndWait();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return QuizController.isCorrect;
    }
    
    public boolean wonStage3(Item Spell, Player player) {
        if (!spellBook.hasSpell(fireball)) {
            return false;
        }

        if (spellBook.hasSpell(questSpell)) {
            return spellBook.getFireballState();
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
        return this.stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }
    
    public void incrementStage() {
        this.stage += 1;
    }
}

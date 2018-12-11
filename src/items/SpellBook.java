/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import controllers.SceneManager;
import controllers.GydehuttenSouth.BossFightController;
import java.io.IOException;
import java.util.*;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.css.PseudoClass;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import missions.Quest;
import utils.SpriteAnimation;
import static world.Game.boss;
import static world.Game.fireball;
import static world.Game.player;
import static world.Game.spellBook;



/**
 *
 * @author birke
 */
public class SpellBook extends Item {    
    
    private static final Image fireballIcon = new Image(SpellBook.class.getResourceAsStream("/images/menu/fireball.jpg"));
    private static final Image fireballImage = new Image(SpellBook.class.getResourceAsStream("/images/items/fireballz.png"));
    private static final Image explosionImage = new Image(SpellBook.class.getResourceAsStream("/images/items/explosion.png"));
    private final ArrayList<Spell> mySpells = new ArrayList<>();
    private static FXMLLoader loader;
    private static Parent root;
    private static boolean fireballActivate = false;

    public SpellBook(String name, int id) {
        super(name,id);
    }
    
    public void addSpell(Spell newSpell) {
        mySpells.add(newSpell);
    }
    
    public boolean hasSpell(Spell spell) {
        return this.mySpells.contains(spell);
    } 
    
    public void getSpellBook() {
        if (mySpells.isEmpty()) {
            System.out.println("Too bad, you got no spells yet.");
        } else {
            System.out.println("### Your spells are: ###");
            for(Spell spell : mySpells) {
                System.out.println("- " + spell.getName() + " ");
            }  
        }
    }
    
    public static void openSpellBook() throws IOException {
        if (!player.hasItem(spellBook)) {
            return;
        }
        loader = new FXMLLoader(
            SpellBook.class.getResource("/views/Spellbook.fxml")
        );
        root = loader.load();
        root.setLayoutX(300);
        root.setLayoutY(160);
        
        Group closeButton = (Group)loader.getNamespace().get("crossId");
        Group spellPage = (Group)loader.getNamespace().get("spellPage");
        Group questPage = (Group)loader.getNamespace().get("questPage");
        ListView<Quest> quests = (ListView)loader.getNamespace().get("logId");
        quests.setCellFactory((ListView<Quest> param) -> {
            ListCell<Quest> cell = new ListCell<Quest>() {
                @Override
                protected void updateItem(Quest item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null) {
                        setText(item.getName());
                        this.pseudoClassStateChanged(PseudoClass.getPseudoClass("completed"), item.isQuestDone());
                    } else {
                        setText("");
                    }
                }
            };
            return cell;
        });
        quests.setItems(FXCollections.observableArrayList(player.getQuestLog()));        
        TextArea description = (TextArea)loader.getNamespace().get("descriptionId");
        ImageView requiredItem = (ImageView)loader.getNamespace().get("requiredItem");
        ImageView rewardItem = (ImageView)loader.getNamespace().get("rewardItem");
        Label requiredItemLabel = (Label)loader.getNamespace().get("requiredItemLabel");
        Label rewardItemLabel = (Label)loader.getNamespace().get("rewardItemLabel");
        quests.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (!((Quest)newValue).isQuestDone()) {
                description.setText(((Quest)newValue).getQuestDescription());
                requiredItem.setImage(((Quest)newValue).getRequiredItem().getImage());
                rewardItem.setImage(((Quest)newValue).getRewardItem().getImage());
                rewardItemLabel.setVisible(true);
                requiredItemLabel.setVisible(true);
            }
        });
        Rectangle rightSide = (Rectangle)loader.getNamespace().get("rightSide");
        rightSide.setOnMouseClicked((mouseEvent) -> {
            questPage.setVisible(true);
            questPage.setMouseTransparent(false);
            spellPage.setVisible(false);
            spellPage.setMouseTransparent(true);
        });
        Rectangle leftSide = (Rectangle)loader.getNamespace().get("leftSide");
        leftSide.setOnMouseClicked((mouseEvent) -> {
            questPage.setVisible(false);
            questPage.setMouseTransparent(true);
            spellPage.setVisible(true);
            spellPage.setMouseTransparent(false);
        });
        closeButton.setOnMouseClicked((mouseEvent) -> SceneManager.getMain().getChildren().remove(root));
        SceneManager.getMain().getChildren().add(root);
    }
    
    public static void castFireball() {
        if (loader == null || root == null) return;
        if (player.hasItem(fireball)) {
            ImageView fireBallIcon = (ImageView)loader.getNamespace().get("fireBallId");
            fireBallIcon.setImage(fireballIcon);
            
            fireBallIcon.setOnMouseClicked((mouseEvent) -> {
                SceneManager.getMain().getChildren().remove(root);
                if (boss.getStage() == 3 && SceneManager.getController() instanceof BossFightController) {
                    fireballActivate = true;
                }
                
                BorderPane main = SceneManager.getMain();
                
                ImageView imageViewFire = new ImageView(fireballImage);
                Animation fireballAnimation = new SpriteAnimation(
                    imageViewFire,
                    Duration.millis(1000), 
                    14, 14,
                    1, 1,
                    97, 85
                );
                imageViewFire.setViewport(new Rectangle2D(1, 1, 97, 85));
                imageViewFire.setScaleX(2.0);
                imageViewFire.setScaleY(4.0);
                fireballAnimation.setCycleCount(Animation.INDEFINITE);
                fireballAnimation.play();
                
                PathTransition transition = new PathTransition();
                transition.setDuration(Duration.seconds(1.2));
                if (SceneManager.getController() instanceof BossFightController) {
                    BossFightController c = SceneManager.getController();
                    transition.setPath(c.bossHitbox);
                } else {
                    Line line = new Line(445, 600, 445, 350);
                    transition.setPath(line);
                }
                transition.setNode(imageViewFire);
                transition.play();
                transition.setOnFinished((actionEvent) -> {
                    ImageView imageViewExplosion = new ImageView(explosionImage);
                    imageViewExplosion.setScaleX(2.0);
                    imageViewExplosion.setScaleY(2.0);
                    imageViewExplosion.setViewport(new Rectangle2D(2, 1, 97, 150));
                    if (SceneManager.getController() instanceof BossFightController) {
                        imageViewExplosion.setLayoutX(150);
                        imageViewExplosion.setLayoutY(50);
                    } else {
                        imageViewExplosion.setLayoutX(360);
                        imageViewExplosion.setLayoutY(200);
                    }
                    main.getChildren().remove(imageViewFire);
                    Animation explosionAnimation = new SpriteAnimation(
                        imageViewExplosion,
                        Duration.millis(1000),
                        15, 15,
                        2, 1,
                        97, 150
                    );
                    explosionAnimation.setCycleCount(1);
                    explosionAnimation.play();
                    explosionAnimation.setOnFinished((actionEvt) -> {
                        if (fireballActivate && SceneManager.getController() instanceof BossFightController) {
                            BossFightController c = SceneManager.getController();
                            c.bossEncounter();
                        }
                        main.getChildren().remove(imageViewExplosion);
                    });
                    main.getChildren().add(imageViewExplosion);
                });
                main.getChildren().add(imageViewFire);
            });
        }
    }
    
    public boolean getFireballState() {
        return this.fireballActivate;
    }
}



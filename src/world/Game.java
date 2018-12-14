package world;

import characters.FinalBoss;
import items.SpellBook;
import items.Spell;
import characters.Player;
import items.Item;

public class Game 
{
    public static Player player = new Player();
    
    public static Item studyCard = new Item("studycard", 1);
    public static Item Bookie = new Item("Book", 2);
    public static SpellBook spellBook = new SpellBook("spellbook",3);
    public static Item teeth = new Item("Teeth", 4);
    public static Item bone = new Item("Bone", 5);
    public static Item stage1RequiredItem = new Item("Flamethrower", 6);
    public static Item stage2RequiredItem = new Item("Ironmelter", 7);
    public static Spell fireball = new Spell("Fireball", 8);
    public static Item toiletpaper = new Item("Toiletpaper", 9);
    public static Item coin = new Item("Coin",10);
    public static Item coffeeDrink = new Item("Coffee drink",11);
    public static Item boneone = new Item("Bone1", 12);
    public static Item bonetwo = new Item("Bone2", 13);
    public static Item bonethree = new Item("Bone3", 14);
    public static Item scissorItem = new Item("Scissor", 13);
    public static Item pulledPork = new Item("pulledpork",14);
    public static Item pieceOfLeg = new Item("piece of leg",15);
    public static Item ribeye = new Item("ribeye",16);
    public static Item fangs = new Item("Fangs", 17);   
    public static Item bones = new Item("Bones", 18);
    public static Item key = new Item("Key", 19);
    public static Item creepyBear = new Item("Creepy bear", 20);
    public static Item creepyDoll = new Item("Creepy Doll", 21);
    public static Item musicbook = new Item("music book", 22);
   
    public static boolean isStentenLocked = true;
    
    //Boss
    public static FinalBoss boss = new FinalBoss(stage1RequiredItem, pieceOfLeg, spellBook, fireball);
}

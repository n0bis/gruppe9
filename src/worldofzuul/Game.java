package worldofzuul;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import static worldofzuul.ShowMap.showMap;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Timer timer;
    private Player player;
    private NPC npc;
    private Boss boss;
    private Quest quest;
    Item teeth = new Item("Teeth", 4);
    Item bone = new Item("Bone", 5);
    Item bones = new Item("Bones", 22);
    Item fangs = new Item("Fangs", 21);
    Item studycard = new Item("Studiekort", 1);
    Item book = new Item("Bog", 2);
    Item questItem1 = new Item("Flamethrower", 6);
    Item questItem2 = new Item("Ironmelter", 7);
    Room outsideTek = new Room("outside the tek entrance of the university");
    Room tekHall = new Room("inside the tek building");
    Room studyRooms = new Room("upstairs infront of the study rooms - for projects");
    Room building44lvl1 = new Room("at level 1 in building 44");
    Room building44lvl2 = new Room("at level 2 in building 44");
    Room building44lvl3 = new Room("at level 3 in building 44");
    private Item ribeye, pulledPork, pieceOfLamb, coin;
    private SpellBook spellBook;

    
    public Game() 
    {
        createRooms();
        parser = new Parser();
        player = new Player();
        Timer timer = new Timer();
        timer.schedule(new TimeExpired(), TimeUnit.MINUTES.toMillis(20));
        timer.schedule(new TimeRemaining(), TimeUnit.MINUTES.toMillis(10));
    }

    private void createRooms()
    {

        // Create Quests
        Quest draculaQuest = new Quest("Quest 1: Find my teeth", "You still havent found my teeth",
        "Thanks for finding my teeth", false, bones, fangs);
        
        // Create NPCs
        NPC dracula = new NPC("Dracula", "Hello, I'm Dracula.", "Thanks for helping me. I have no more quests for you.");
        
        // Create Boss
        boss = new Boss("Cerberus", "Wufhahaha, I am Cerberus. The 3 headed dawg. 1 head of Fire, 1 of Metal and 1 of Stone", questItem1, questItem2,
            "Wingardiumleviosa");

        spellBook = new SpellBook("spellbook",2);
        ribeye = new Item("ribeye",3);
        pulledPork = new Item("pulledpork",4);
        pieceOfLamb = new Item("piece of lamb",5);
        coin = new Item("coin",6);

        Spell fireball;
        fireball = new Spell("Fireball", 8);

        
        Room outsideTek, tekHall, studyRooms, building44lvl1, building44lvl2, building44lvl3, u183, northMainHall,
            northToilets, u45, u55, southMainHall, building38, u140, building22a, building22alvl1, building22aNorth, u27a, building22aSouth, u1,
                building344, u133, outsideMainHall, nedenunder, theColourKitchen, underTheColourKitchen, library;
        
      
        outsideTek = new Room("outside the tek entrance of the university");
        tekHall = new Room("inside TEK hall");
        studyRooms = new Room("upstairs infront of the study rooms - for projects");
        building44lvl1 = new Room("at level 1 in building 44");
        building44lvl2 = new Room("at level 2 in building 44");
        building44lvl3 = new lockedRoom("at level 3 in building 44",Arrays.asList(studyCard));
        u183 = new Room("in classroom u183 on level 3 in building 44");
        northMainHall = new lockedRoom("in the northMainHall",Arrays.asList(spellBook));
        northToilets = new Room("in one of the toilets on the northMainHall");
        u45 = new Room("in classroom u45 which is in the northMainHall");
        southMainHall = new lockedRoom("in the southMainHall",Arrays.asList(ribeye,pulledPork,pieceOfLamb));
        u55 = new Room("in classroom u55 which is in the southMainhall");
        building38 = new Room("in building38");
        u140 = new Room("in classroom u140 which is in building38");
        building22a = new lockedRoom("in building22a",Arrays.asList(bone));
        building22alvl1 = new Room("at level 1 in building22a, but in building22a there are 3 levels");
        building22aNorth = new Room("in building22aNorth");
        u27a = new Room("in classroom 22a which is in building22asouthlvl1");
        building22aSouth = new Room("in building22aSouth");
        u1 = new Room("in classroom u1 which is in building22a");
        building344 = new Room("in building344");
        u133 = new Room("in classroom u133 which is in building344");
        outsideMainHall = new Room("outside of the main hall");
        nedenunder = new Room("in fredagsbaren where the halloween party is being held");
        theColourKitchen = new lockedRoom("in the biggest cafeteria of the southern university",Arrays.asList(coin));
        underTheColourKitchen = new Room("under the biggest cafeteria of the southern university");
        library = new Room("the library of the university");
 
        currentRoom = outsideTek;
        
        // Set exits
        outsideTek.setExit("north", tekHall);
        tekHall.setExit("west", tekHall);
        tekHall.setExit("up", studyRooms);
        studyRooms.setExit("down", tekHall);
        tekHall.setExit("east",building44lvl1);
        building44lvl1.setExit("up",building44lvl2);
        building44lvl2.setExit("up",building44lvl3);
        building44lvl3.setExit("u183", u183); 
        u183.setExit("back", building44lvl3); 
        building44lvl3.setExit("down",building44lvl2);
        building44lvl2.setExit("down",building44lvl1);
        building44lvl1.setExit("west", tekHall);
        tekHall.setExit("south", outsideTek);
        building44lvl1.setExit("east",northMainHall);
        northMainHall.setExit("west",building44lvl1);
        northMainHall.setExit("down",northToilets);
        northToilets.setExit("up",northMainHall);
        northMainHall.setExit("u45", u45);
        u45.setExit("back",northMainHall);
        northMainHall.setExit("u55",u55);
        u55.setExit("back", northMainHall);
        northMainHall.setExit("south",southMainHall);
        southMainHall.setExit("north",northMainHall);
        southMainHall.setExit("to TheColourKitchen", theColourKitchen);
        theColourKitchen.setExit("to nedenunder",nedenunder);
        nedenunder.setExit("back",theColourKitchen);
        theColourKitchen.setExit("back", southMainHall);
        southMainHall.setExit("east",building344);
        building344.setExit("u133",u133);
        u133.setExit("back",building344);
        building344.setExit("back",southMainHall);
        southMainHall.setExit("library",library);
        library.setExit("back", southMainHall);
        southMainHall.setExit("north",northMainHall);
        northMainHall.setExit("west",building38);
        building38.setExit("u140", u140);
        u140.setExit("back",building38);
        building38.setExit("back",northMainHall);
        northMainHall.setExit("building22a",building22a);
        building22a.setExit("to building22aSouth",building22aSouth);
        building22aSouth.setExit("u1",u1);
        u1.setExit("back",building22aSouth);
        building22aSouth.setExit("back",building22a);
        building22a.setExit("building22aNorth", building22aNorth);
        building22aNorth.setExit("up",u27a);
        u27a.setExit("back",building22aNorth);
        building22aNorth.setExit("back", building22a);   
        

        // Set items
        outsideTek.setItem(studycard);
        tekHall.setItem(fangs);
   
        // Set NPCs
        tekHall.setNPC(dracula);
        
        // Set NPC quest
        dracula.addQuest(draculaQuest);
        
        // Set Boss
        studyRooms.setBoss(boss);
 
        tekHall.setItem(spellBook);
        tekHall.setSpell(fireball);
        
        currentRoom = outsideTek;
    }
    
    public void play() 
    {            
        printWelcome();
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }
    
    public void textDelay(String str) { 
        for (char ch: str.toCharArray()) {
            System.out.print(ch);
            try {
                Thread.sleep(300); // Defines the delay in ms
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("");
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (null != commandWord) switch (commandWord) {
            case HELP:
                printHelp();
                break;
            case GO:
                goRoom(command);
                break;
            case QUIT:
                wantToQuit = quit(command);
                break;
            case SEARCH:
                search();
                break;
            case DROP:
                dropItem(command);
                break;
            case SHOW:
                show(command);
                break;
            case TALK:
                talk();
                break;
            default:
                break;
        }
        return wantToQuit;
    }
    
    private void checkSpellBook() {
        if (!player.inventory.contains(spellBook)) {
            System.out.println("You dont have a spellbook!");
            return;
        }
        spellBook.getSpellBook();
    }
    
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }
    
    private void talk() {
        if(!currentRoom.hasNPC()) {
            System.out.println("Who you talking to?");
            return;
        }
        
        NPC npc = currentRoom.getNPC();
        Quest tempQuest;
        Item tempReward;
        
        if(!npc.hasQuest()) {
            System.out.println(npc.questsDone);    
            return;
        }   
        
            for(int counter = 0; counter < npc.getQuests().size(); counter ++) {
                tempQuest = npc.quests.get(counter);
                tempReward = npc.quests.get(counter).getRewardItem();
                
                if(tempQuest.isQuestDone()) {
                    continue;
                } else {
                   if(!player.hasQuest(tempQuest)) {
                       System.out.println(tempQuest.getQuestDescription());
                       player.questLog.add(tempQuest);
                   } else if (player.hasQuest(tempQuest) && player.hasItem(tempQuest.getRequiredItem())) {
                       tempQuest.setIsQuestDone(true);
                       player.questLog.remove(tempQuest);
                       System.out.println(tempQuest.getQuestDone());
                       player.inventory.add(tempReward);
                       player.inventory.remove(tempQuest.getRequiredItem());
                   } else {
                       System.out.println(tempQuest.getQuestInProgress());
                   }
                }                                                                  
            }  
        }
    
    private void search() {
        if(currentRoom.getItem() == null) {
            System.out.println("There is not items here... Spooky");
        } else {
            textDelay("Searching...");
            System.out.println("Amazing you found " + currentRoom.getItem().name);
            player.addItem(currentRoom.getItem());
            if (currentRoom.getItem() == studycard) fillStudyCard();
            currentRoom.setItem(null);
        }

        if(currentRoom.getSpell() != null) {
            System.out.println("You have learned a new spell! You can now do a: " + currentRoom.getSpell().name);
            spellBook.addSpell(currentRoom.getSpell());
            currentRoom.setSpell(null);
        }
    }
    
    private void fillStudyCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please fill in your name: ");
        if (scanner.hasNext()) {
            player.setName(scanner.next());
            player.setMajor("Software Engineering");
            System.out.println("Welcome player " + player.getName() + " with the majoring " + player.getMajor());
           
        }
    }
    
    private void dropItem(Command command) {
        if(!command.hasSecondWord()) {
            System.out.println("You need to specify what item to drop..");
            return;
        }

        for(int index = 0; index < player.inventory.size(); index++) { 
            Item item = player.inventory.get(index);
            
            if(item.name.equalsIgnoreCase(command.getSecondWord())) {
                currentRoom.setItem(item);
                player.inventory.remove(item);
                System.out.println("You dropped " + item.name);
                return;
            }       
        }
        System.out.println("You do not have an item named " + "\"" + command.getSecondWord() + "\"");
    }
        
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else if (nextRoom instanceof lockedRoom && !((lockedRoom)nextRoom).canEnter(player.inventory)) {
            System.out.println("You cannot enter this room because it is locked. You need to find the needed item");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            if(currentRoom.hasNPC()) {
                System.out.println(currentRoom.getNPC().dialogue);
            }
            
            // If room has boss:
            
            if(currentRoom.hasBoss()){
                Scanner scanner = new Scanner(System.in);
                String fightAnswer;
                Item questItem1 = studycard;
                Item questItem2 = bone;
                String spell = "Wingardium leviosa";
                String spellCast;
                
                
                switch(boss.stage) {
                    case 1:
                        System.out.println(currentRoom.getBoss().dialogue);
                        System.out.println("Do you want to fight me pleb? (Yes or no)");
                        fightAnswer = scanner.nextLine();
                        
                        
                        if(fightAnswer.equalsIgnoreCase("Yes")) {
                            for(Item item : player.inventory) {
                                if(item == questItem1) {
                                    System.out.println("Argh, you killed my Frosthead with your " + questItem1);
                                    boss.stage += 1;
                                }
                            }     
                             if(boss.stage == 1) {
                                    System.out.println("Ha-ha, return to your home, pleb");
                                    currentRoom = tekHall;
                        }
                        
                        if(boss.stage == 2) {
                            System.out.println("Ohh, you might have killed my first head, but I still have my metal head. FeelsGoodMan");
                            
                            for(Item item : player.inventory) {
                                if(item == questItem2) {
                                    System.out.println("Argh, you killed my Metalhead with your " + questItem2);
                                    boss.stage += 1;
                                }                   
                            }
                            
                            if(boss.stage == 2) {
                                    System.out.println("Ha-ha, my Metalhead was too much for you..");
                                    System.out.println("Cerberus threw you out");
                                    currentRoom = tekHall;
                                    System.out.println(currentRoom.getLongDescription());
                            }           
                        } 
                        
                        if(boss.stage == 3) {
                            System.out.println("You have killed 2 of my heads, but this last one, only a spell can kill.");
                            System.out.println("Enter your spell plebby");
                            spellCast = scanner.nextLine();
                            
                            if(spellCast.equalsIgnoreCase(spell)) {
                                System.out.println("You got meeee");
                                // Remove boss
                            } else {
                                System.out.println("Ha-ha, wrong spell");
                                    System.out.println("Cerberus threw you out");
                                    currentRoom = tekHall;
                                    System.out.println(currentRoom.getLongDescription());
                            }                          
                        }
                                    
                        } else {
                            System.out.println("Run away you coward..");
                            textDelay("Cerberus threw you out");
                            currentRoom = tekHall;
                            System.out.println(currentRoom.getLongDescription());
                        }
                        break;
                        
                    case 2:
                     System.out.println("Ohh, you might have killed my first head, but I still have my metal head. FeelsGoodMan");
                            
                            for(Item item : player.inventory) {
                                if(item == questItem2) {
                                    System.out.println("Argh, you killed my Metalhead with your " + questItem2);
                                    boss.stage += 1;
                                }                   
                            }
                            
                            if(boss.stage == 2) {
                                    System.out.println("Ha-ha, my Metalhead was too much for you..");
                                    System.out.println("Cerberus threw you out");
                                    currentRoom = tekHall;
                                    System.out.println(currentRoom.getLongDescription());
                            }
                            
                            if(boss.stage == 3) {
                            System.out.println("You have killed 2 of my heads, but this last one, only a spell can kill.");
                            System.out.println("Enter your spell plebby");
                            spellCast = scanner.nextLine();
                            
                            if(spellCast.equalsIgnoreCase(spell)) {
                                System.out.println("You got meeee");
                                // Remove boss
                            } else {
                                System.out.println("Ha-ha, wrong spell");
                                    System.out.println("Cerberus threw you out");
                                    currentRoom = tekHall;
                                    System.out.println(currentRoom.getLongDescription());
                            }                          
                        }
                        break;
                        
                    case 3:
                        System.out.println("You have killed the doge. Much wow, so sad. RIP in pieces.");
                        break;
                }
            }
        }
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }

    private void show(Command command) {
        if (!command.hasSecondWord()){
            System.out.println("Show inventory or map");
            return;
        }
        switch (command.getSecondWord()) {
            case "map":
                showMap();
                break;
            case "inventory":
                player.getInventory();
                break;
            case "spellbook":
                checkSpellBook();
                break;
        }
    }
    
}

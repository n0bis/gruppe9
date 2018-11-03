package worldofzuul;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game 
{
    private Parser parser;
    public Room currentRoom;
    private Timer timer;
    private Player player;
    private NPC npc;
    private Boss boss;
    Item teeth = new Item("Teeth", 4);
    Item bone = new Item("Bone", 5);
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
    
    
    public Game() 
    {
        createRooms();
        parser = new Parser();
        player = new Player();
    }

    private void createRooms()
    {
        
        // Create NPCs
        NPC dracula;
        dracula = new NPC("Dracula", "Uurrrghhhh, I'll kill you boiii", 
        "Here is a quest for you", "Your quest is done", teeth, bone);
        
        // Create Boss
        boss = new Boss("Cerberus", "Muhahaha, I am Cerberus. The 3 headed dawg. 1 head of Fire, 1 of Metal and 1 of Stone", questItem1, questItem2,
            "Wingardiumleviosa");
        
        // Create rooms

        
        // Set exits
        outsideTek.setExit("north", tekHall);
        tekHall.setExit("up", studyRooms);
        studyRooms.setExit("down", tekHall);
        
        // Set items
        outsideTek.setItem(studycard);
        tekHall.setItem(teeth);
        
        // Set NPCs
        tekHall.setNPC(dracula);
        
        // Set Boss
        studyRooms.setBoss(boss);
        
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
            case INVENTORY:
                inventory();
                break;
            case TALK:
                talk();
                break;
            default:
                break;
        }
        return wantToQuit;
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
    if(currentRoom.hasNPC()) {
        if(currentRoom.getNPC().questItem == null) {
        if(player.inventory.size() > 0) {
          for(Item item : player.inventory) {
            if(item == currentRoom.getNPC().needItem) {
                System.out.println(currentRoom.getNPC().questDone);
                player.inventory.remove(item);
                currentRoom.getNPC().setQuestItem(item);
                if(currentRoom.getNPC().giveItem != null) {
                    player.addItem(currentRoom.getNPC().giveItem);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Awesome! " + currentRoom.getNPC().name + " gave you " + currentRoom.getNPC().giveItem);
                }
            }
          }
        } else {
            System.out.println(currentRoom.getNPC().quest);
        }
        } else {
        System.out.println("You have already helped me");
        }
    } else {
        System.out.println("There is no one to talk to... Who you talking to boiii");
    }
   }
    
    private void search() {
        if(currentRoom.getItem() == null) {
            System.out.println("There is not items here... Spooky");
        } else {
            textDelay("Searching...");
            System.out.println("Amazing you found " + currentRoom.getItem().name);
            player.addItem(currentRoom.getItem());
            currentRoom.setItem(null);
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
        
    private void inventory() {
        player.getInventory();
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
}

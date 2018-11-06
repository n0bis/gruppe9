package worldofzuul;

import java.util.Timer;
import java.util.concurrent.TimeUnit;
import static worldofzuul.ShowMap.showMap;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Player player;
    private SpellBook spellBook;
    private Item studycard, book;

    
    public Game() 
    {
        createRooms();
        parser = new Parser();
        player = new Player();
        Timer timer = new Timer();
        timer.schedule(new TimeExpired(), TimeUnit.MINUTES.toMillis(20));
        timer.schedule(new TimeRemaining(), TimeUnit.MINUTES.toMillis(10));
        spellBook = new SpellBook();
        }

    private void createRooms()
    {
        studycard = new Item("Study ID Card", 1);
        book = new Item("Spellbook", 2);
        
        Spell fireball;
        fireball = new Spell("Fireball", 1);
        
        Room outsideTek, tekHall, studyRooms, building44lvl1, building44lvl2, building44lvl3, u183, northMainHall,
            northToilets, u45, u55, southMainHall, building38, u140, building22a, building22alvl1, building22aNorth, u27a, building22aSouth, u1,
                building344, u133, outsideMainHall, nedenunder, theColourKitchen, underTheColourKitchen, library;
        
      
        outsideTek = new Room("outside the tek entrance of the university");
        tekHall = new Room("inside TEK hall");
        studyRooms = new Room("upstairs infront of the study rooms - for projects");
        building44lvl1 = new Room("at level 1 in building 44");
        building44lvl2 = new Room("at level 2 in building 44");
        building44lvl3 = new Room("at level 3 in building 44");
        u183 = new Room("in classroom u183 on level 3 in building 44");
        northMainHall = new Room("in the northMainHall");
        northToilets = new Room("in one of the toilets on the northMainHall");
        u45 = new Room("in classroom u45 which is in the northMainHall");
        southMainHall = new Room("in the southMainHall");
        u55 = new Room("in classroom u55 which is in the southMainhall");
        building38 = new Room("in building38");
        u140 = new Room("in classroom u140 which is in building38");
        building22a = new Room("in building22a");
        building22alvl1 = new Room("at level 1 in building22a, but in building22a there are 3 levels");
        building22aNorth = new Room("in building22aNorth");
        u27a = new Room("in classroom 22a which is in building22asouthlvl1");
        building22aSouth = new Room("in building22aSouth");
        u1 = new Room("in classroom u1 which is in building22a");
        building344 = new Room("in building344");
        u133 = new Room("in classroom u133 which is in building344");
        outsideMainHall = new Room("outside of the main hall");
        nedenunder = new Room("in fredagsbaren where the halloween party is being held");
        theColourKitchen = new Room("in the biggest cafeteria of the southern university");
        underTheColourKitchen = new Room("under the biggest cafeteria of the southern university");
        library = new Room("the library of the university");
 
        currentRoom = outsideTek;
        
        outsideTek.setExit("north", tekHall);
        tekHall.setExit("west", tekHall);
        tekHall.setExit("up", studyRooms);
        studyRooms.setExit("down", tekHall);
        tekHall.setExit("east",building44lvl1);
        building44lvl1.setExit("up",building44lvl2);
        building44lvl2.setExit("up",building44lvl3);
        building44lvl3.setExit("to u183", u183); 
        u183.setExit("back", building44lvl3); 
        building44lvl3.setExit("down",building44lvl2);
        building44lvl2.setExit("down",building44lvl1);
        building44lvl1.setExit("west", tekHall);
        tekHall.setExit("south", outsideTek);
        building44lvl1.setExit("east",northMainHall);
        northMainHall.setExit("west",building44lvl1);
        northMainHall.setExit("down",northToilets);
        northToilets.setExit("up",northMainHall);
        northMainHall.setExit("to u45", u45);
        u45.setExit("back",northMainHall);
        northMainHall.setExit("to u55",u55);
        u55.setExit("back", northMainHall);
        northMainHall.setExit("south",southMainHall);
        southMainHall.setExit("north",northMainHall);
        southMainHall.setExit("to TheColourKitchen", theColourKitchen);
        theColourKitchen.setExit("to nedenunder",nedenunder);
        nedenunder.setExit("back",theColourKitchen);
        theColourKitchen.setExit("back", southMainHall);
        southMainHall.setExit("east",building344);
        building344.setExit("to u133",u133);
        u133.setExit("back",building344);
        building344.setExit("back",southMainHall);
        southMainHall.setExit("to library",library);
        library.setExit("back", southMainHall);
        southMainHall.setExit("north",northMainHall);
        northMainHall.setExit("west",building38);
        building38.setExit("to u140", u140);
        u140.setExit("back", building38);
        building38.setExit("back",northMainHall);
        northMainHall.setExit("to building22a",building22a);
        building22a.setExit("to building22aSouth",building22aSouth);
        building22aSouth.setExit("to u1",u1);
        u1.setExit("back",building22aSouth);
        building22aSouth.setExit("back",building22a);
        building22a.setExit("to building22aNorth", building22aNorth);
        building22aNorth.setExit("up",u27a);
        u27a.setExit("back",building22aNorth);
        building22aNorth.setExit("back", building22a);   
        
        outsideTek.setItem(studycard);
        tekHall.setItem(book);
        
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
            default:
                break;
        }
        return wantToQuit;
    }
    
    private void checkSpellBook() {
        if (!player.inventory.contains(book)) {
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
    
    private void search() {
        if(currentRoom.getItem() == null) {
            System.out.println("There is not items here... Spooky");
        } else {
            textDelay("Searching...");
            System.out.println("Amazing you found " + currentRoom.getItem().name);
            player.addItem(currentRoom.getItem());
            currentRoom.setItem(null);
        }
        if(currentRoom.getSpell() == null) {
        } else {
            System.out.println("You have learned a new spell! You can now do a: " + currentRoom.getSpell().name);
            spellBook.addSpell(currentRoom.getSpell());
            currentRoom.setSpell(null);
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
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
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

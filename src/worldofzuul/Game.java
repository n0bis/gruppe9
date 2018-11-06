package worldofzuul;

import java.io.PrintStream;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Timer timer;
    private Player player;

    public Game() 
    {
        createRooms();
        parser = new Parser();
        player = new Player();
    }

    private void createRooms()
    {
        Item studycard, book;
        studycard = new Item("Studiekort", 1);
        book = new Item("Bog", 2);
        
        Room outsideTek, tekHall, studyRooms, building44lvl1, building44lvl2, building44lvl3, u183, northMainHall,
            northToilets, u45, u55, southMainHall, building38, u140, building22a, building22aNorth, u27a, building22aSouth, u1,
                building334, u133, outsideMainHall, nedenunder, theColourKitchen, underTheColourKitchen;
      
        outsideTek = new Room("outside the tek entrance of the university");
        tekHall = new Room("inside TEK hall");
        studyRooms = new Room("upstairs infront of the study rooms - for projects");
        building44lvl1 = new Room("at level 1 in building 44");
        building44lvl2 = new Room("at level 2 in building 44");
        building44lvl3 = new Room("at level 3 in building 44");
        
        outsideTek.setExit("north", tekHall);
        tekHall.setExit("up", studyRooms);
        studyRooms.setExit("down", tekHall);
        
        outsideTek.setItem(studycard);
        tekHall.setItem(book);
        
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
            case SHOWMAP:
                showMap();
                break;
            case TEKHALL:
                tekHall();
                break;
            case BYG44:
                Byg44();
                break;
            case NORTHMAINHALL:
                NorthMainHall();
                break;
            case B8:
                b8();
                break;
            case SOUTHMAINHALL:
                SouthMainHall();
                break;
            case OUTSIDETEK:
                outsideTek();
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
    private void showMap(){
        System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMM         M            MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMM         M   South    MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMM         M    Main    MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMM         M    Hall    MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" + 
"MMMMMMMMMMM         M            MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMM            M           MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMM            M     B8    MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMM            M     U140  MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMM____________M           MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMM         M            MMMMMMMMMMMMMMMMM outside    MMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMM   22A   M   North    MMMMMMMMMMMMMMMMM    Tek     MMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMM         M   Main     MMMMMMMMMMMMMMMMM____________MMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMM         M   Hall     MMMMMM          M            MMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMM         M            MMNNNN          M    tek     MMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMM         M            BBBBBB  byg44   M    Hall    MMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMM           MMMMMM          M            MMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMM           MMMMMM__________M________    MMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMNNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
        "If you are lost u can allways get help, just write the main room you're and you'll get some information");              
    }
    private void tekHall(){
        System.out.println("Tekhall is north of outsideTek, inside tekhall there is studyrooms");
    }
    private void Byg44(){
        System.out.println("Bygning44 is East of Tekhall and Vest of North Main hall. Bygning44 has 3 rooms: LvL2, LvL3 and U183");
    }
    private void NorthMainHall(){
        System.out.println("North Main Hall is East of Bygning 44, Vest of 22A and south of South main Hall - Room:U45-U55-North-T");
    }
    private void SouthMainHall(){
        System.out.println("South Main Hall is a big area! South of North Main Hall. Rooms:U133-");
    }
    private void b8(){
        System.out.println("");
    }
    private void outsideTek(){
        System.out.println("You're in the start area. Go north to start the experience or continue.");
    }
}

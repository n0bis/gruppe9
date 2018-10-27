package worldofzuul;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        

    public Game() 
    {
        createRooms();
        parser = new Parser();
    }


    private void createRooms()
    {
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
}

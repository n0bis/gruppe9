package worldofzuul;

public enum CommandWord
{
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), SEARCH("search"), DROP("drop"), INVENTORY("inventory"), SHOWMAP("showmap"), TEKHALL("tekhall"), BYG44("byg44"), NORTHMAINHALL("northmainhall"), SOUTHMAINHALL("southmainhall"), B8("b8"), OUTSIDETEK("outsidetek");
    
    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    public String toString()
    {
        return commandString;
    }
}

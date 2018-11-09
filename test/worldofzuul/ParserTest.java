/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import command.Command;
import command.Parser;
import command.CommandWord;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author madsfalken
 */
public class ParserTest {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    public ParserTest() {
    }
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    /**
     * Test of getCommand method, of class Parser.
     */
    @Test
    public void testGetCommand() {
        String input = "go south";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Parser instance = new Parser();
        Command expResult = new Command(CommandWord.GO, "south");
        Command result = instance.getCommand();
        assertEquals(expResult.getCommandWord(), result.getCommandWord());
        assertEquals(expResult.getSecondWord(), result.getSecondWord());
    }

    /**
     * Test of showCommands method, of class Parser.
     */
    @Test
    public void testShowCommands() {
        Parser instance = new Parser();
        instance.showCommands();
        assertEquals("help  go  quit  " + 
                System.getProperty("line.separator"),
                outContent.toString());
    }
    
}

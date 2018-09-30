/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author madsfalken
 */
@RunWith(Parameterized.class)
public class CommandWordsTest {
    
    private final String input;
    private final CommandWord expected;
    private final boolean validate;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    public CommandWordsTest(String input, 
            CommandWord expected, 
            boolean validate) {
        this.input = input;
        this.expected = expected;
        this.validate = validate;
    }
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList( new Object[][] { 
            { "go" , CommandWord.GO, true }, 
            { "help", CommandWord.HELP, true }, 
            { "quit", CommandWord.QUIT, true }, 
            { "bla", CommandWord.UNKNOWN, false },
            { null, CommandWord.UNKNOWN, false },
            { "   ", CommandWord.UNKNOWN, false }
        });
    }
    
    /**
     * Test of getCommandWord method, of class CommandWords.
     */
    @Test
    public void testGetCommandWord() {
        String commandWord = input;
        CommandWords instance = new CommandWords();
        CommandWord expResult = expected;
        CommandWord result = instance.getCommandWord(commandWord);
        assertEquals(expResult, result);
    }

    /**
     * Test of isCommand method, of class CommandWords.
     */
    @Test
    public void testIsCommand() {
        String aString = input;
        CommandWords instance = new CommandWords();
        boolean expResult = validate;
        boolean result = instance.isCommand(aString);
        assertEquals(expResult, result);
    }

    /**
     * Test of showAll method, of class CommandWords.
     */
    @Test
    public void testShowAll() {
        CommandWords instance = new CommandWords();
        instance.showAll();
        assertEquals("help  go  quit  " + 
                System.getProperty("line.separator"),
                outContent.toString());
    }
    
}

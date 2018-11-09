/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import command.Command;
import command.CommandWord;
import java.util.Arrays;
import java.util.Collection;
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
public class CommandTest {
    
    private CommandWord commandWord;
    private String secondWord;
    private boolean validate;
    
    public CommandTest(CommandWord commandWord,
            String secondWord,
            boolean validate) {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
        this.validate = validate;
    }
    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList( new Object[][] { 
            { CommandWord.GO, null, false }, 
            { CommandWord.HELP, null, false }, 
            { CommandWord.QUIT, null, false }, 
            { CommandWord.UNKNOWN, "Uni", true },
            { CommandWord.UNKNOWN, "Uni", true },
            { CommandWord.UNKNOWN, "Uni", true }
        });
    }

    /**
     * Test of isUnknown method, of class Command.
     */
    @Test
    public void testIsUnknown() {
        Command instance = new Command(this.commandWord, this.secondWord);
        boolean expResult = this.validate;
        boolean result = instance.isUnknown();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasSecondWord method, of class Command.
     */
    @Test
    public void testHasSecondWord() {
        Command instance = new Command(this.commandWord, this.secondWord);
        boolean expResult = this.validate;
        boolean result = instance.hasSecondWord();
        assertEquals(expResult, result);
    }
    
}

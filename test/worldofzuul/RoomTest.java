/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
package worldofzuul;

import world.Room;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


 *
 * @author madsfalken
 
public class RoomTest {
    
    public RoomTest() {
    }

    
     * Test of getLongDescription method, of class Room.
     
    @Test
    public void testGetLongDescription() {
        Room instance = new Room("outside of your domain boi");
        String expResult = "You are outside of your domain boi."  + System.getProperty("line.separator") + "Exits:";
        String result = instance.getLongDescription();
        assertEquals(expResult, result);
    }

    
     * Test of getExit method, of class Room.
     
    @Test
    public void testGetExit() {
        String direction = "south";
        Room instance = new Room("university");
        Room expResult = new Room("lab");
        instance.setExit(direction, expResult);
        Room result = instance.getExit(direction);
        assertEquals(expResult, result);
    }
    
}
 */


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import java.util.*;



/**
 *
 * @author birke
 */
public class SpellBook {    
        
    private final ArrayList<Spell> mySpells = new ArrayList<>();

    public SpellBook() {
        
    }
    
    public void addSpell(Spell newSpell) {
        mySpells.add(newSpell);
    }
    
    public void getSpellBook() {
        if (mySpells.isEmpty()) {
            System.out.println("Too bad, you got no spells yet.");
        } else {
            System.out.println("### Your spells are: ###");
            for(Spell spell : mySpells) {
                System.out.println("- " + spell.name + " ");
            }  
        }
    }
}



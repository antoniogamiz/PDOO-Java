/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antonio
 */
public class LootTest {
    
    public LootTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getNSupplies method, of class Loot.
     */
    @Test
    public void testGetNSupplies() {
        System.out.println("getNSupplies");
        Loot instance = new Loot(1,2,3,4,5);
        int expResult = 1;
        int result = instance.getNSupplies();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNWeapons method, of class Loot.
     */
    @Test
    public void testGetNWeapons() {
        System.out.println("getNWeapons");
        Loot instance = new Loot(1,2,3,4,5);
        int expResult = 2;
        int result = instance.getNWeapons();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNShields method, of class Loot.
     */
    @Test
    public void testGetNShields() {
        System.out.println("getNShields");
        Loot instance = new Loot(1,2,3,4,5);
        int expResult = 3;
        int result = instance.getNShields();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNHangars method, of class Loot.
     */
    @Test
    public void testGetNHangars() {
        System.out.println("getNHangars");
        Loot instance = new Loot(1,2,3,4,5);
        int expResult = 4;
        int result = instance.getNHangars();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNMedals method, of class Loot.
     */
    @Test
    public void testGetNMedals() {
        System.out.println("getNMedals");
        Loot instance = new Loot(1,2,3,4,5);
        int expResult = 5;
        int result = instance.getNMedals();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUIversion method, of class Loot.
     */
    @Test
    public void testGetUIversion() {
        System.out.println("getUIversion");
        Loot instance = new Loot(1,2,3,4,5);
        LootToUI result = instance.getUIversion();
    }

    /**
     * Test of toString method, of class Loot.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Loot instance = new Loot(1,2,3,4,5);
        String result = instance.toString();
    }
    
}

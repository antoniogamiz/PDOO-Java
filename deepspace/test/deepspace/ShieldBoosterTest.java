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
public class ShieldBoosterTest {
    
    public ShieldBoosterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getBoost method, of class ShieldBooster.
     */
    @Test
    public void testGetBoost() {
        System.out.println("getBoost");
        ShieldBooster instance = new ShieldBooster("shield", 10, 20);
        float expResult = 10.0F;
        float result = instance.getBoost();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getUses method, of class ShieldBooster.
     */
    @Test
    public void testGetUses() {
        System.out.println("getUses");
        ShieldBooster instance = new ShieldBooster("shield", 10, 20);
        int expResult = 20;
        int result = instance.getUses();
        assertEquals(expResult, result);
    }

    /**
     * Test of useIt method, of class ShieldBooster.
     */
    @Test
    public void testUseIt() {
        System.out.println("useIt");
        ShieldBooster instance = new ShieldBooster("shield", 10, 20);
        float expResult = 10.0F;
        float result = instance.useIt();
        assertEquals(expResult, result, 0.0);
        assertEquals(19, instance.getUses());
    }

    /**
     * Test of getUIversion method, of class ShieldBooster.
     */
    @Test
    public void testGetUIversion() {
        System.out.println("getUIversion");
        ShieldBooster instance = new ShieldBooster("shield", 10, 20);
        ShieldToUI result = instance.getUIversion();
    }
    
}

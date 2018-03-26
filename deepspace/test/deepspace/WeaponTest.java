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
public class WeaponTest {
    
    public WeaponTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getType method, of class Weapon.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Weapon instance = new Weapon("aaa", WeaponType.LASER, 2);
        WeaponType expResult = WeaponType.LASER;
        WeaponType result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUses method, of class Weapon.
     */
    @Test
    public void testGetUses() {
        System.out.println("getUses");
        Weapon instance = new Weapon("aaa", WeaponType.LASER, 2);
        int expResult = 2;
        int result = instance.getUses();
        assertEquals(expResult, result);
    }

    /**
     * Test of power method, of class Weapon.
     */
    @Test
    public void testPower() {
        System.out.println("power");
        Weapon instance = new Weapon("aaa", WeaponType.LASER, 2);
        float expResult = 2.0F;
        float result = instance.power();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of useIt method, of class Weapon.
     */
    @Test
    public void testUseIt() {
        System.out.println("useIt");
        Weapon instance = new Weapon("aaa", WeaponType.LASER, 2);
        float expResult = 2.0F;
        float result = instance.useIt();
        assertEquals(expResult, result, 0.0);
        assertEquals(1, instance.getUses(), 0.0);        
    }

    /**
     * Test of getUIversion method, of class Weapon.
     */
    @Test
    public void testGetUIversion() {
        System.out.println("getUIversion");
        Weapon instance = new Weapon("aaa", WeaponType.LASER, 2);
        WeaponToUI result = instance.getUIversion();
    }

    /**
     * Test of toString method, of class Weapon.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Weapon instance = new Weapon("aaa", WeaponType.LASER, 2);
        String expResult = "";
        String result = instance.toString();
    }
    
}

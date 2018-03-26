/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antonio
 */
public class HangarTest {
    
    public HangarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getUIversion method, of class Hangar.
     */
    @Test
    public void testGetUIversion() {
        System.out.println("getUIversion");
        Hangar instance = new Hangar(10);
        HangarToUI result = instance.getUIversion();
    }

    /**
     * Test of addWeapon method, of class Hangar.
     */
    @Test
    public void testAddWeapon() {
        System.out.println("addWeapon");
        Weapon w = new Weapon("test", WeaponType.LASER, 10);
        Hangar instance = new Hangar(10);
        boolean expResult = true;
        boolean result = instance.addWeapon(w);
        assertEquals(expResult, result);
    }

    /**
     * Test of addShieldBooster method, of class Hangar.
     */
    @Test
    public void testAddShieldBooster() {
        System.out.println("addShieldBooster");
        ShieldBooster s = new ShieldBooster("test", 10, 20);
        Hangar instance = new Hangar(10);
        boolean expResult = true;
        boolean result = instance.addShieldBooster(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaxElements method, of class Hangar.
     */
    @Test
    public void testGetMaxElements() {
        System.out.println("getMaxElements");
        Hangar instance = new Hangar(10);
        int expResult = 10;
        int result = instance.getMaxElements();
        assertEquals(expResult, result);
    }

    /**
     * Test of getShieldBoosters method, of class Hangar.
     */
    @Test
    public void testGetShieldBoosters() {
        System.out.println("getShieldBoosters");
        Hangar instance = new Hangar(10);
        ArrayList<ShieldBooster> expResult=new ArrayList<>();
        ShieldBooster s = new ShieldBooster("test", 10, 20);
        expResult.add(s);
        instance.addShieldBooster(s);
        ArrayList<ShieldBooster> result = instance.getShieldBoosters();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWeapons method, of class Hangar.
     */
    @Test
    public void testGetWeapons() {
        System.out.println("getWeapons");
        Hangar instance = new Hangar(10);
        ArrayList<Weapon> expResult=new ArrayList<>();
        Weapon w = new Weapon("test", WeaponType.LASER, 10);
        expResult.add(w);
        instance.addWeapon(w);        
        ArrayList<Weapon> result = instance.getWeapons();
        assertEquals(expResult, result);
    }

    /**
     * Test of removeWeapon method, of class Hangar.
     */
    @Test
    public void testRemoveWeapon() {
        System.out.println("removeWeapon");
        int w = 0;
        Hangar instance = new Hangar(10);
        Weapon expResult = new Weapon("test", WeaponType.LASER, 10);
        instance.addWeapon(expResult);
        Weapon result = instance.removeWeapon(w);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeShieldBooster method, of class Hangar.
     */
    @Test
    public void testRemoveShieldBooster() {
        System.out.println("removeShieldBooster");
        int s = 0;
        Hangar instance = new Hangar(10);
        ShieldBooster expResult = new ShieldBooster("test", 10, 20);
        instance.addShieldBooster(expResult);
        ShieldBooster result = instance.removeShieldBooster(s);
        assertEquals(expResult, result);
    }
    
}

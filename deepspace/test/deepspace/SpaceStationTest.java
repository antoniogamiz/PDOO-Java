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
public class SpaceStationTest {
    
    public SpaceStationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of cleanUpMountedItems method, of class SpaceStation.
     */
    @Test
    public void testCleanUpMountedItems() {
        System.out.println("cleanUpMountedItems");
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        instance.cleanUpMountedItems();
    }

    /**
     * Test of discardHangar method, of class SpaceStation.
     */
    @Test
    public void testDiscardHangar() {
        System.out.println("discardHangar");
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        instance.discardHangar();
    }

    /**
     * Test of discardShieldBooster method, of class SpaceStation.
     */
/*
    @Test
    public void testDiscardShieldBooster() {
        System.out.println("discardShieldBooster");
        int i = 0;
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        instance.discardShieldBooster(i);
    }
*/
    /**
     * Test of discardShieldBoosterInHangar method, of class SpaceStation.
     */
    @Test
    public void testDiscardShieldBoosterInHangar() {
        System.out.println("discardShieldBoosterInHangar");
        int i = 0;
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        instance.discardShieldBoosterInHangar(i);
    }

    /**
     * Test of discardWeapon method, of class SpaceStation.
     */
/*
    @Test
    public void testDiscardWeapon() {
        System.out.println("discardWeapon");
        int i = 0;
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        instance.discardWeapon(i);
    }
*/
    /**
     * Test of discardWeaponInHangar method, of class SpaceStation.
     */
    @Test
    public void testDiscardWeaponInHangar() {
        System.out.println("discardWeaponInHangar");
        int i = 0;
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        instance.discardWeaponInHangar(i);
    }

    /**
     * Test of fire method, of class SpaceStation.
     */
/*
    @Test
    public void testFire() {
        System.out.println("fire");
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        float expResult = 0.0F;
        float result = instance.fire();
    }
*/
    /**
     * Test of getAmmoPower method, of class SpaceStation.
     */
    @Test
    public void testGetAmmoPower() {
        System.out.println("getAmmoPower");
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        float expResult = 1.0F;
        float result = instance.getAmmoPower();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getFuelUnits method, of class SpaceStation.
     */
    @Test
    public void testGetFuelUnits() {
        System.out.println("getFuelUnits");
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        float expResult = 2.0F;
        float result = instance.getFuelUnits();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getHangar method, of class SpaceStation.
     */
    @Test
    public void testGetHangar() {
        System.out.println("getHangar");
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        Hangar expResult = null;
        Hangar result = instance.getHangar();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class SpaceStation.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        String expResult = "test";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNMedals method, of class SpaceStation.
     */
    @Test
    public void testGetNMedals() {
        System.out.println("getNMedals");
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        int expResult = 0;
        int result = instance.getNMedals();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPendingDamage method, of class SpaceStation.
     */
    @Test
    public void testGetPendingDamage() {
        System.out.println("getPendingDamage");
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        Damage expResult = null;
        Damage result = instance.getPendingDamage();
        assertEquals(expResult, result);
    }

    /**
     * Test of getShieldBoosters method, of class SpaceStation.
     */
    @Test
    public void testGetShieldBoosters() {
        System.out.println("getShieldBoosters");
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        ArrayList<ShieldBooster> expResult = new ArrayList<>();
        ArrayList<ShieldBooster> result = instance.getShieldBoosters();
        assertEquals(expResult, result);
    }

    /**
     * Test of getShieldPower method, of class SpaceStation.
     */
    @Test
    public void testGetShieldPower() {
        System.out.println("getShieldPower");
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        float expResult = 3.0F;
        float result = instance.getShieldPower();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getSpeed method, of class SpaceStation.
     */
    @Test
    public void testGetSpeed() {
        System.out.println("getSpeed");
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,100,3));
        float expResult = 1.0F;
        float result = instance.getSpeed();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getUIversion method, of class SpaceStation.
     */
    @Test
    public void testGetUIversion() {
        System.out.println("getUIversion");
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        SpaceStationToUI result = instance.getUIversion();
    }

    /**
     * Test of getWeapons method, of class SpaceStation.
     */
    @Test
    public void testGetWeapons() {
        System.out.println("getWeapons");
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        ArrayList<Weapon> expResult = new ArrayList<>();
        ArrayList<Weapon> result = instance.getWeapons();
        assertEquals(expResult, result);
    }

    /**
     * Test of mountShieldBooster method, of class SpaceStation.
     */
    @Test
    public void testMountShieldBooster() {
        System.out.println("mountShieldBooster");
        int i = 0;
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        instance.mountShieldBooster(i);
    }

    /**
     * Test of mountWeapon method, of class SpaceStation.
     */
    @Test
    public void testMountWeapon() {
        System.out.println("mountWeapon");
        int i = 0;
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        instance.mountWeapon(i);
    }

    /**
     * Test of move method, of class SpaceStation.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        instance.move();
    }

    /**
     * Test of protection method, of class SpaceStation.
     */
/*    @Test
    public void testProtection() {
        System.out.println("protection");
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        float expResult = 0.0F;
        float result = instance.protection();
    }
*/
    /**
     * Test of receiveHangar method, of class SpaceStation.
     */
    @Test
    public void testReceiveHangar() {
        System.out.println("receiveHangar");
        Hangar h = new Hangar(10);
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        instance.receiveHangar(h);
    }

    /**
     * Test of receiveShieldBooster method, of class SpaceStation.
     */
    @Test
    public void testReceiveShieldBooster() {
        System.out.println("receiveShieldBooster");
        ShieldBooster s = new ShieldBooster("test", 1, 2);
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        boolean expResult = false;
        boolean result = instance.receiveShieldBooster(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of receiveShot method, of class SpaceStation.
     */
/*
    @Test
    public void testReceiveShot() {
        System.out.println("receiveShot");
        float shot = 0.0F;
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        ShotResult result = instance.receiveShot(shot);
    }
*/
    /**
     * Test of receiveSupplies method, of class SpaceStation.
     */
    @Test
    public void testReceiveSupplies() {
        System.out.println("receiveSupplies");
        SuppliesPackage s = new SuppliesPackage(1, 2, 3);
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        instance.receiveSupplies(s);
    }

    /**
     * Test of receiveWeapon method, of class SpaceStation.
     */
    @Test
    public void testReceiveWeapon() {
        System.out.println("receiveWeapon");
        Weapon w = new Weapon("test", WeaponType.LASER, 2);
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        boolean expResult = false;
        boolean result = instance.receiveWeapon(w);
        assertEquals(expResult, result);
    }

    /**
     * Test of setLoot method, of class SpaceStation.
     */
/*    @Test
    public void testSetLoot() {
        System.out.println("setLoot");
        Loot loot = null;
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        instance.setLoot(loot);
    }
*/
    /**
     * Test of setPendingDamage method, of class SpaceStation.
     */
    @Test
    public void testSetPendingDamage() {
        System.out.println("setPendingDamage");
        Damage d = new Damage(1, 2);
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        instance.setPendingDamage(d);
    }

    /**
     * Test of validState method, of class SpaceStation.
     */
    @Test
    public void testValidState() {
        System.out.println("validState");
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        boolean expResult = true;
        boolean result = instance.validState();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class SpaceStation.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SpaceStation instance = new SpaceStation("test", new SuppliesPackage(1,2,3));
        String result = instance.toString();
    }
    
}

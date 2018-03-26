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
public class EnemyStarShipTest {
    
    public EnemyStarShipTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getUIversion method, of class EnemyStarShip.
     */
    @Test
    public void testGetUIversion() {
        System.out.println("getUIversion");
        EnemyStarShip instance = new EnemyStarShip("name", 1, 2, new Loot(1,2,3,4,5), new Damage(2,3));
        EnemyToUI result = instance.getUIversion();
    }

    /**
     * Test of fire method, of class EnemyStarShip.
     */
    @Test
    public void testFire() {
        System.out.println("fire");
        EnemyStarShip instance = new EnemyStarShip("name", 1, 2, new Loot(1,2,3,4,5), new Damage(2,3));
        float expResult = 1.0F;
        float result = instance.fire();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getAmmoPower method, of class EnemyStarShip.
     */
    @Test
    public void testGetAmmoPower() {
        System.out.println("getAmmoPower");
        EnemyStarShip instance = new EnemyStarShip("name", 1, 2, new Loot(1,2,3,4,5), new Damage(2,3));
        float expResult = 1.0F;
        float result = instance.getAmmoPower();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getDamage method, of class EnemyStarShip.
     */
    @Test
    public void testGetDamage() {
        System.out.println("getDamage");
        EnemyStarShip instance = new EnemyStarShip("name", 1, 2, new Loot(1,2,3,4,5), new Damage(2,3));
        Damage expResult = new Damage(2,3);
        Damage result = instance.getDamage();
        assertEquals(expResult.getNWeapons(), result.getNWeapons());
        assertEquals(expResult.getNShields(), result.getNShields());        
    }

    /**
     * Test of getLoot method, of class EnemyStarShip.
     */
    @Test
    public void testGetLoot() {
        System.out.println("getLoot");
        EnemyStarShip instance = new EnemyStarShip("name", 1, 2, new Loot(1,2,3,4,5), new Damage(2,3));
        Loot l = new Loot(1,2,3,4,5);
        Loot result = instance.getLoot();
        assertEquals( l.getNShields(), result.getNShields());
        assertEquals( l.getNWeapons(), result.getNWeapons());
        assertEquals( l.getNMedals(), result.getNMedals());
        assertEquals( l.getNHangars(), result.getNHangars());
        assertEquals( l.getNSupplies(), result.getNSupplies());

    }

    /**
     * Test of getName method, of class EnemyStarShip.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        EnemyStarShip instance = new EnemyStarShip("name", 1, 2, new Loot(1,2,3,4,5), new Damage(2,3));
        String expResult = "name";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getShieldPower method, of class EnemyStarShip.
     */
    @Test
    public void testGetShieldPower() {
        System.out.println("getShieldPower");
        EnemyStarShip instance = new EnemyStarShip("name", 1, 2, new Loot(1,2,3,4,5), new Damage(2,3));
        float expResult = 2.0F;
        float result = instance.getShieldPower();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of protection method, of class EnemyStarShip.
     */
    @Test
    public void testProtection() {
        System.out.println("protection");
        EnemyStarShip instance = new EnemyStarShip("name", 1, 2, new Loot(1,2,3,4,5), new Damage(2,3));
        float expResult = 2.0F;
        float result = instance.protection();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of receiveShot method, of class EnemyStarShip.
     */
    @Test
    public void testReceiveShot() {
        System.out.println("receiveShot");
        float shot1 = 10.0F;
        float shot2 = 1.0F;
        EnemyStarShip instance = new EnemyStarShip("name", 1, 2, new Loot(1,2,3,4,5), new Damage(2,3));
        
        ShotResult result1 = instance.receiveShot(shot1);
        ShotResult result2 = instance.receiveShot(shot2);
        
        assertEquals(ShotResult.DONOTRESIST, result1);
        assertEquals(ShotResult.RESIST, result2);
    }
    
}

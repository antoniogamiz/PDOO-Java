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
public class DamageTest {
    
    public DamageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getUIversion method, of class Damage.
     */
    @Test
    public void testGetUIversion() {
        System.out.println("getUIversion");
        Damage instance = new Damage(1,1);
        DamageToUI result = instance.getUIversion();
    }

    /**
     * Test of adjust method, of class Damage.
     */
    @Test
    public void testAdjust() {
        System.out.println("adjust");
        ArrayList<WeaponType> weapons = new ArrayList<>();
        weapons.add(WeaponType.LASER);
        weapons.add(WeaponType.LASER);
        weapons.add(WeaponType.PLASMA);
        weapons.add(WeaponType.PLASMA);
        weapons.add(WeaponType.PLASMA);
        weapons.add(WeaponType.MISSILE);
        weapons.add(WeaponType.MISSILE);

        ArrayList<WeaponType> exp_w = new ArrayList<>();
        exp_w.add(WeaponType.LASER);
        exp_w.add(WeaponType.PLASMA);
        exp_w.add(WeaponType.PLASMA);
        exp_w.add(WeaponType.MISSILE);
        exp_w.add(WeaponType.MISSILE);
        
        
        ArrayList<Weapon> weapons2 = new ArrayList<>();
        weapons2.add(new Weapon("w8", WeaponType.LASER, 11));
        weapons2.add(new Weapon("w9", WeaponType.PLASMA, 12));
        weapons2.add(new Weapon("w10", WeaponType.PLASMA, 13));
        weapons2.add(new Weapon("w11", WeaponType.MISSILE, 15));
        weapons2.add(new Weapon("w12", WeaponType.MISSILE, 16));
        weapons2.add(new Weapon("w13", WeaponType.MISSILE, 14));

        ArrayList<ShieldBooster> shields = new ArrayList<>();
        shields.add(new ShieldBooster("s1", 2, 3));
        shields.add(new ShieldBooster("s2", 3, 5));
        shields.add(new ShieldBooster("s3", 4, 6));
                
        Damage instance = new Damage(weapons, 10);
        Damage result = instance.adjust(weapons2, shields);
        assertEquals(exp_w, result.getWeapons());
        assertEquals(3, result.getNShields());
    }

    /**
     * Test of discardWeapon method, of class Damage.
     */
    @Test
    public void testDiscardWeapon() {
        System.out.println("discardWeapon");
        Weapon w = new Weapon("test", WeaponType.LASER, 10);
        Damage instance = new Damage(19,19);
        instance.discardWeapon(w);
    }

    /**
     * Test of discardShieldBooster method, of class Damage.
     */
    @Test
    public void testDiscardShieldBooster() {
        System.out.println("discardShieldBooster");
        Damage instance = new Damage(10,10);
        instance.discardShieldBooster();
        assertEquals(9, instance.getNShields());
    }

    /**
     * Test of hasNoEffect method, of class Damage.
     */
    @Test
    public void testHasNoEffect() {
        System.out.println("hasNoEffect");
        Damage instance = new Damage (10, 10);
        boolean expResult = false;
        boolean result = instance.hasNoEffect();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNShields method, of class Damage.
     */
    @Test
    public void testGetNShields() {
        System.out.println("getNShields");
        Damage instance = new Damage (2,3);
        int expResult = 3;
        int result = instance.getNShields();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNWeapons method, of class Damage.
     */
    @Test
    public void testGetNWeapons() {
        System.out.println("getNWeapons");
        Damage instance = new Damage(3,2);
        int expResult = 3;
        int result = instance.getNWeapons();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWeapons method, of class Damage.
     */
    @Test
    public void testGetWeapons() {
        System.out.println("getWeapons");
        ArrayList<WeaponType> weapons = new ArrayList<>();
        weapons.add(WeaponType.LASER);
        Damage instance = new Damage(weapons, 1);
        ArrayList<WeaponType> expResult = weapons;
        ArrayList<WeaponType> result = instance.getWeapons();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Damage.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Damage instance = new Damage(2,2);
        String result = instance.toString();
    }
    
}

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
public class SuppliesPackageTest {
    
    public SuppliesPackageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getAmmoPower method, of class SuppliesPackage.
     */
    @Test
    public void testGetAmmoPower() {
        System.out.println("getAmmoPower");
        SuppliesPackage instance = new SuppliesPackage(10,20,30);
        float expResult = 10.0F;
        float result = instance.getAmmoPower();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getFuelUnits method, of class SuppliesPackage.
     */
    @Test
    public void testGetFuelUnits() {
        System.out.println("getFuelUnits");
        SuppliesPackage instance = new SuppliesPackage(10,20,30);
        float expResult = 20.0F;
        float result = instance.getFuelUnits();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getShieldPower method, of class SuppliesPackage.
     */
    @Test
    public void testGetShieldPower() {
        System.out.println("getShieldPower");
        SuppliesPackage instance = new SuppliesPackage(10,20,30);
        float expResult = 30.0F;
        float result = instance.getShieldPower();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class SuppliesPackage.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SuppliesPackage instance = new SuppliesPackage(10,20,30);
        String result = instance.toString();
    }
    
}

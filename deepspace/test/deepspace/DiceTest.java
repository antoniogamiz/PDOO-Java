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
public class DiceTest {
    
    public DiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of initWithNHangars method, of class Dice.
     */
    @Test
    public void testInitWithNHangars() {
        System.out.println("initWithNHangars");
        Dice instance = new Dice();
        int result=0;
        for(int i=0; i<1000; i++){
            if ( instance.initWithNHangars() == 0 )
                result+=1;
        }
        double p=result/1000.0;
        assert(0.2 < p && p < 0.3);
    }

    /**
     * Test of initWithNWeapons method, of class Dice.
     */
    @Test
    public void testInitWithNWeapons() {
        System.out.println("initWithNWeapons");
        Dice instance = new Dice();
        int result=0;
        for(int i=0; i<1000; i++){
            if ( instance.initWithNWeapons() == 1 )
                result+=1;
        }
        double p=result/1000.0;
        assert(0.28 < p && p < 0.38);
    }

    /**
     * Test of initWithNShields method, of class Dice.
     */
    @Test
    public void testInitWithNShields() {
        System.out.println("initWithNShields");
        Dice instance = new Dice();
        int result=0;
        for(int i=0; i<1000; i++){
            if ( instance.initWithNShields() == 0 )
                result+=1;
        }
        double p=result/1000.0;
        assert(0.2 < p && p < 0.3);
    }

    /**
     * Test of whoStarts method, of class Dice.
     */
    @Test
    public void testWhoStarts() {
        System.out.println("whoStarts");
        int nPlayers = 10;
        Dice instance = new Dice();
        int expResult = 0;
        int result = instance.whoStarts(nPlayers);
        assert(result <= nPlayers);
    }

    /**
     * Test of firstShot method, of class Dice.
     */
    @Test
    public void testFirstShot() {
        System.out.println("firstShot");
        Dice instance = new Dice();
        int result=0;
        for(int i=0; i<1000; i++){
            if ( instance.firstShot() == GameCharacter.SPACESTATION )
                result+=1;
        }
        double p=result/1000.0;
        assert(0.45 < p && p < 0.55): p;
    }

    /**
     * Test of spaceStationMoves method, of class Dice.
     */
    @Test
    public void testSpaceStationMoves() {
        System.out.println("spaceStationMoves");
        float speed = 0.0F;
        Dice instance = new Dice();
        boolean expResult = false;
        boolean result = instance.spaceStationMoves(speed);
        assert(true);
    }
    
}

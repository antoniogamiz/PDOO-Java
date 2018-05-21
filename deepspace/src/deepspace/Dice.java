/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

import java.util.Random;

/**
 *
 * @author antonio
 */
public class Dice {
    
    private final float NHANGARSPROB;
    private final float NSHIELDSPROB;
    private final float NWEAPONSPROB;
    private final float FIRSTSHOTPROB;
    private final float EXTRAEFFICIENCYPROB;
    private Random generator;
    
    Dice(){
        NHANGARSPROB=0.25f;
        NSHIELDSPROB=0.25f;
        NWEAPONSPROB=0.33f;
        FIRSTSHOTPROB=0.5f;
        EXTRAEFFICIENCYPROB=0.8f;
        generator=new Random();
    }
    
    int initWithNHangars(){ return ( generator.nextFloat() < NHANGARSPROB ) ? 0 : 1;}
    
    int initWithNWeapons(){
        float p = generator.nextFloat();
        
        if(p < NWEAPONSPROB)
            return 1;
        else 
            return ( NWEAPONSPROB <= p && p < NWEAPONSPROB*2 ) ? 2 : 3;
    }
    
    int initWithNShields(){ return ( generator.nextFloat() < NSHIELDSPROB ) ? 0 : 1; }
    
    int whoStarts(int nPlayers){ return generator.nextInt(nPlayers); }
    
    GameCharacter firstShot(){ return ( generator.nextFloat() < FIRSTSHOTPROB ) ? GameCharacter.SPACESTATION : GameCharacter.ENEMYSTARSHIP; }
    
    boolean spaceStationMoves(float speed){ return generator.nextFloat() < speed; }
    
    boolean extraEfficiency(){ return generator.nextFloat() >= EXTRAEFFICIENCYPROB; }
}

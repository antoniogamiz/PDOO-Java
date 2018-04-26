/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

import java.util.ArrayList;

/**
 *
 * @author antonio
 */
public abstract class Damage {
    
    private int nShields;

    Damage(int s) { nShields=s; }
    
    public abstract Damage copy(Damage d);
    
    abstract DamageToUI getUIversion();
    
    public int adjustShieldBoosters(ArrayList<ShieldBooster> s){ return ( nShields > s.size() ) ? s.size() : nShields; }
    
    public abstract Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s);
    
    public abstract void discardWeapon(Weapon w); 
    
    public void discardShieldBooster() { if(nShields > 0) nShields--; }   
    
    public boolean hasNoEffect(){ return getNShields()==0; };
   
    public int getNShields(){ return nShields; }
    
    public abstract int getNWeapons();
    
    @Override
    public String toString() {
        return "Damage{" + "nShields=" + nShields;
    }
    
    
}

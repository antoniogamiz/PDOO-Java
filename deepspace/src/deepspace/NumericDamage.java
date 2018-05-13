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
public class NumericDamage extends Damage{
    
    int nWeapons;
    
    NumericDamage(int n, int s){ super(s); nWeapons=n; }

    @Override
    public NumericDamage copy(Damage d){ return new NumericDamage(getNWeapons(), getNShields()); }

    @Override
    NumericDamageToUI getUIversion(){ return new NumericDamageToUI(this); }
    
    @Override
    public NumericDamage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){ return new NumericDamage(( getNWeapons() > w.size() ) ? w.size() : getNWeapons() ,adjustShieldBoosters(s));}
    
    @Override
    public void discardWeapon(Weapon w){ if(getNWeapons() > 0 ) nWeapons--; }
    
    @Override
    public boolean hasNoEffect(){ return super.hasNoEffect() && getNWeapons()==0; }
    
    @Override
    public int getNWeapons(){ return nWeapons; }
    
    @Override
    public String toString(){ return super.toString()+", nWeapons=" + getNWeapons() + '}';}

}

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
public class SpecificDamage extends Damage {
    
    ArrayList<WeaponType> weapons;
    
    SpecificDamage(ArrayList<WeaponType> wl, int s){ super(s); weapons=wl; }
    
    @Override
    public SpecificDamage copy(Damage d){ return new SpecificDamage(weapons, getNShields()); }
    
    @Override
    SpecificDamageToUI getUIversion(){ return new SpecificDamageToUI(this); }
    
    @Override
    public SpecificDamage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s)
    {
        int index;        
        ArrayList<WeaponType> new_weapons = new ArrayList<>();            
        for(WeaponType x: weapons)
        {
            index=arrayContainsType(w, x);
            if ( index != -1 )
            {
                new_weapons.add(x);
                w.remove(index);
            }
        }

        return new SpecificDamage(new_weapons, adjustShieldBoosters(s));
    }

    private int arrayContainsType(ArrayList<Weapon> w, WeaponType t)
    {
        boolean f = false;
        int index = -1;
        
        for(int i= 0; i<w.size(); i++)
        {
            if(w.get(i).getType() == t){ return i; }
        }
        return index;
    }
    
    @Override
    public void discardWeapon(Weapon w){ weapons.remove(w.getType()); }
    
    @Override
    public boolean hasNoEffect(){ return super.hasNoEffect() && weapons.isEmpty(); }
    
    @Override
    public int getNWeapons(){ return weapons.size(); }
    
    public ArrayList<WeaponType> getWeapons(){ return weapons; }
    
    @Override
    public String toString(){ return super.toString()+", nWeapons=" + getNWeapons() + ", weapons=" + weapons + '}';}
}

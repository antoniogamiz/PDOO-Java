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
public class Damage {
    
    private int nShields;
    private int nWeapons;
    private ArrayList<WeaponType> weapons;

    Damage(int w, int s, ArrayList<WeaponType> wl)
    {
        if( wl!=null )
        {
            weapons=new ArrayList<>(wl);
        }
        else
            weapons=null;
    
        nWeapons=w;
        nShields=s;
    }
    
    Damage(int w, int s)
    {
        this(w, s, null);
    }
    
    Damage(ArrayList<WeaponType> wl, int s)
    {
        this(-1, s, wl);
    }
    
    Damage(Damage d)
    {
        this(d.nWeapons, d.nShields, d.weapons);
    }
    
    DamageToUI getUIversion()
    {
        return new DamageToUI(this);
    }

    Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s)
    {
        int ns = ( nShields > s.size() ) ? s.size() : nShields;
        
        int index;
        
        if (weapons != null)
        {
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

            if( new_weapons.size()==0 && ns==0 )
                return null;
            else
                return new Damage(new_weapons, ns);
        }
        else
        {
            int nw = ( nWeapons > w.size() ) ? w.size() : nWeapons;

            if( nw==0 && ns==0 ) 
                return null;
            else
                return new Damage(nw, ns);
        }
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
 
    public void discardWeapon(Weapon w)
    {
        if(weapons == null && nWeapons > 0)
            nWeapons--;
        else
            weapons.remove(w.getType());
    }
    
    public void discardShieldBooster() { if(nShields > 0) nShields--; }   
    
    public boolean hasNoEffect(){ return nShields <= 0 && nWeapons <= 0 && (weapons == null || weapons.isEmpty()); }
    
    public int getNShields(){ return nShields; }
    
    public int getNWeapons(){ return nWeapons; }
    
    public ArrayList<WeaponType> getWeapons(){ return weapons; }

    @Override
    public String toString() {
        return "Damage{" + "nShields=" + nShields + ", nWeapons=" + nWeapons + ", weapons=" + weapons + '}';
    }
    
    
}

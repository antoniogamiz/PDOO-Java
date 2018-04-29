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
public class Hangar {
    
    private int maxElements;
    private ArrayList<ShieldBooster> shieldBoosters;
    private ArrayList<Weapon> weapons;

    Hangar(int maxElements){ 
        this.maxElements=maxElements; 
        this.shieldBoosters=new ArrayList<>();
        this.weapons=new ArrayList<>();
    }
    
    Hangar( Hangar h )
    {
        maxElements=h.maxElements;
        shieldBoosters=h.shieldBoosters;
        weapons=h.weapons;
    }
    
    HangarToUI getUIversion()
    {
        return new HangarToUI(this);
    }
    
    private boolean spaceAvailable()
    {
       return shieldBoosters.size() + weapons.size() < maxElements;
    }
    
    public boolean addWeapon(Weapon w)
    {
        if( spaceAvailable() )
        {
            weapons.add(w);
            return true;
        } 
        else
            return false;              
    }

    public boolean addShieldBooster(ShieldBooster w)
    {
        if( spaceAvailable() )
        {
            shieldBoosters.add(w);
            return true;
        } else
            return false;              
    }
    
    public int getMaxElements() { return maxElements; }

    public ArrayList<ShieldBooster> getShieldBoosters() { return shieldBoosters; }

    public ArrayList<Weapon> getWeapons() { return weapons; }
    
    public Weapon removeWeapon(int w)
    { 
        if( w>=0 && w<weapons.size() ) 
            return weapons.remove(w); 
        else
            return null;
    }
   
    public ShieldBooster removeShieldBooster(int s)
    { 
        if( s>=0 && s<shieldBoosters.size() )
            return shieldBoosters.remove(s); 
        else
            return null;
    }

    @Override
    public String toString() {
        return "Hangar{" + "maxElements=" + maxElements + ", shieldBoosters=" + shieldBoosters + ", weapons=" + weapons + '}';
    }


}

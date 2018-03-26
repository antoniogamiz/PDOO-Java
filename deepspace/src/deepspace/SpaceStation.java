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
public class SpaceStation {
 
    private static final int MAXFUEL = 100; 
    private static final double SHIELDLOSSPERUNITSHOT=0.1; 
    
    private float ammoPower;
    private float fuelUnits;
    private String name;
    private int nMedals;
    private float shieldPower;
    
    private ArrayList<Weapon> weapons;
    private ArrayList<ShieldBooster> shieldBoosters;
    private Hangar hangar;
    private Damage pendingDamage;

    private void assignFuelValue(float f){ if(f<MAXFUEL) fuelUnits = f; }
    private void cleanPendingDamage(){ if(pendingDamage != null && pendingDamage.hasNoEffect()) pendingDamage=null; }

    SpaceStation(String n, SuppliesPackage supplies)
    {
        name = n;
        ammoPower = supplies.getAmmoPower();
        fuelUnits = supplies.getFuelUnits();
        shieldPower = supplies.getShieldPower();
        nMedals=0;
        weapons = new ArrayList<>();
        shieldBoosters = new ArrayList<>();
        hangar = null;
        pendingDamage = null;
    }
    
    public void cleanUpMountedItems()
    {
        for(Weapon x: weapons)
        {
            if(x.getUses() <= 0) weapons.remove(x);
        }
        for(ShieldBooster x: shieldBoosters)
        {
            if(x.getUses() <= 0) shieldBoosters.remove(x);
        }
    }
    
    public void discardHangar(){ hangar=null; }

    public void discardShieldBooster(int i){ throw new UnsupportedOperationException(); }

    public void discardShieldBoosterInHangar(int i){ if(hangar!=null) hangar.removeShieldBooster(i); }
    
    public void discardWeapon (int i){ throw new UnsupportedOperationException(); }
    
    public void discardWeaponInHangar(int i){ if(hangar!=null) hangar.removeWeapon(i); }
    
    public float fire(){ throw new UnsupportedOperationException(); }

    public float getAmmoPower() { return ammoPower; }

    public float getFuelUnits() { return fuelUnits; }

    public Hangar getHangar() { return hangar; }
    
    public String getName() { return name; }
    
    public int getNMedals() { return nMedals; }    

    public Damage getPendingDamage(){ return pendingDamage; }

    public ArrayList<ShieldBooster> getShieldBoosters(){ return shieldBoosters; }

    public float getShieldPower() { return shieldPower; }

    public float getSpeed(){ return (fuelUnits/MAXFUEL); }
    
    SpaceStationToUI getUIversion(){ return new SpaceStationToUI(this); }
    
    public ArrayList<Weapon> getWeapons(){ return weapons; }
  
    public void mountShieldBooster(int i){
        if(hangar != null){
            ShieldBooster s = hangar.removeShieldBooster(i);
            if(s!=null)
                shieldBoosters.add(s);
        }
    }
    
    public void mountWeapon(int i){
        if(hangar != null){
            Weapon w = hangar.removeWeapon(i);
            if(w!=null)
                weapons.add(w);
        }
    }
    
    public void move(){ fuelUnits -= getSpeed()*fuelUnits; }
    
    public float protection(){ throw new UnsupportedOperationException(); }
    
    public void receiveHangar(Hangar h){ if(hangar==null) hangar = h; }
    
    public boolean receiveShieldBooster(ShieldBooster s){
        if(hangar!=null)
            return hangar.addShieldBooster(s);
        return false;
    }
    
    public ShotResult receiveShot(float shot){ throw new UnsupportedOperationException(); }

    public void receiveSupplies(SuppliesPackage s){
        ammoPower += s.getAmmoPower();
        if ( fuelUnits + s.getFuelUnits() <= MAXFUEL )
            fuelUnits += s.getFuelUnits();
        else
            fuelUnits=MAXFUEL;
        shieldPower += s.getShieldPower();
    }
    
    public boolean receiveWeapon(Weapon w){
        if(hangar!=null)
            return hangar.addWeapon(w);
        return false;
    }
    
    public void setLoot(Loot loot){ throw new UnsupportedOperationException(); }
    
    public void setPendingDamage(Damage d){ pendingDamage= d.adjust(weapons, shieldBoosters); }
    
    public boolean validState(){ cleanPendingDamage(); return pendingDamage == null; }

    @Override
    public String toString() {
        return "SpaceStation{" + "ammoPower=" + ammoPower + ", fuelUnits=" + fuelUnits + ", name=" + name + ", nMedals=" + nMedals + ", shieldPower=" + shieldPower + ", weapons=" + weapons + ", shieldBoosters=" + shieldBoosters + ", hangar=" + hangar + ", pendingDamage=" + pendingDamage + '}';
    }
    
    
}

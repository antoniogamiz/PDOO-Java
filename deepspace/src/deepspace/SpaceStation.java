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
public class SpaceStation implements SpaceFighter{
 
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
    
    SpaceStation(SpaceStation sp)
    {
        weapons = new ArrayList<>();
        shieldBoosters = new ArrayList<>();
        
        name=sp.name;
        nMedals=sp.nMedals;
        
        ammoPower=sp.ammoPower;
        fuelUnits=sp.fuelUnits;
        shieldPower=sp.shieldPower;

        sp.getWeapons().forEach((w) -> {
            weapons.add(w);
        });
        
        sp.getShieldBoosters().forEach((s) -> {
            shieldBoosters.add(s);
        });
        
        hangar=sp.hangar;
        pendingDamage=sp.pendingDamage; 
    }
    
    public void cleanUpMountedItems()
    {
        /*for(Weapon w : weapons){
            if( w.getUses() <=0 ){
                if(pendingDamage!=null){
                    pendingDamage.discardWeapon(w);
                    cleanPendingDamage();
                }
                weapons.remove(w);
            }
        }

        for(ShieldBooster s : shieldBoosters){
            if( s.getUses() <=0 ){
                if(pendingDamage!=null){
                    pendingDamage.discardShieldBooster();
                    cleanPendingDamage();
                }
                shieldBoosters.remove(s);
            }
        }*/
      
        for( int i=weapons.size()-1; i>=0; i-- ){
            if( weapons.get(i).getUses()==0 )
                discardWeapon(i);
        }
        
        for( int i=shieldBoosters.size()-1; i>=0; i-- ){
            if( shieldBoosters.get(i).getUses()==0 )
                discardShieldBooster(i);
        }


        
    }
    
    public void discardHangar(){ hangar=null; }

    public void discardShieldBooster(int i)
    {
        int size=shieldBoosters.size();
        
        if( i>=0 && i<size )
        {
            shieldBoosters.remove(i);
            if( pendingDamage!=null )
            {
                pendingDamage.discardShieldBooster();
                cleanPendingDamage();
            }
        }

    }

    public void discardShieldBoosterInHangar(int i){ if(hangar!=null) hangar.removeShieldBooster(i); }
    
    public void discardWeapon (int i)
    {
        int size=weapons.size();
        
        if( i>=0 && i<size )
        {
            Weapon w = weapons.remove(i);
            if( pendingDamage!=null )
            {
                pendingDamage.discardWeapon(w);
                cleanPendingDamage();
            }
        }
    }
    
    public void discardWeaponInHangar(int i){ if(hangar!=null) hangar.removeWeapon(i); }
    
    @Override
    public float fire()
    {
        float factor= 1.0f;
        
        if(weapons!=null)
            for(Weapon w: weapons)
                factor *= w.useIt();  
        
        return ammoPower*factor;    
    }

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
    
    @Override
    public float protection()
    {
        float factor= 1.0f;
        
        if(shieldBoosters!=null)
            for(ShieldBooster s: shieldBoosters)
                factor *= s.useIt();
        
        return shieldPower*factor;    
    }
    
    public void receiveHangar(Hangar h){ if(hangar==null) hangar = h; }
    
    public boolean receiveShieldBooster(ShieldBooster s){
        if(hangar!=null)
            return hangar.addShieldBooster(s);
        return false;
    }
    
    @Override
    public ShotResult receiveShot(float shot)
    {
        float myProtection = protection();
        
        if( myProtection >= shot )
        {
            shieldPower-=SHIELDLOSSPERUNITSHOT*shot;
            shieldPower=Math.max(0.0f, shieldPower);
            
            return ShotResult.RESIST;
        }
        else
        {
            shieldPower=0.0f;
            return ShotResult.DONOTRESIST;
        }
    }

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
    
    public Transformation setLoot(Loot loot)
    {
        CardDealer dealer= CardDealer.getInstance();
        
        if(loot.getNHangars()>0) receiveHangar(dealer.nextHangar());
          
        for(int i=0; i<loot.getNSupplies(); i++) receiveSupplies(dealer.nextSuppliesPackage());
        for(int i=0; i<loot.getNWeapons(); i++) receiveWeapon(dealer.nextWeapon());
        for(int i=0; i<loot.getNShields(); i++) receiveShieldBooster(dealer.nextShieldBooster());
        
        nMedals+=loot.getNMedals();
                
        if( loot.getEfficient() ) return Transformation.GETEFFICIENT;
        if( loot.spaceCity() ) return Transformation.SPACECITY;
        return Transformation.NOTRANSFORM;
    
    }
    
    public void setPendingDamage(Damage d){ pendingDamage= d.adjust(weapons, shieldBoosters); }
    
    public boolean validState(){ cleanPendingDamage(); return pendingDamage == null; }

    @Override
    public String toString() {
        return "SpaceStation{" + "ammoPower=" + ammoPower + ", fuelUnits=" + fuelUnits + ", name=" + name + ", nMedals=" + nMedals + ", shieldPower=" + shieldPower + ", weapons=" + weapons + ", shieldBoosters=" + shieldBoosters + ", hangar=" + hangar + ", pendingDamage=" + pendingDamage + '}';
    }
    
    
}

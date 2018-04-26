/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

/**
 *
 * @author antonio
 */
public class EnemyStarShip implements SpaceFighter{
    
    private float ammoPower;
    private String name;
    private float shieldPower;
    private Loot loot;
    private Damage damage;

    EnemyStarShip(String n, float a, float s, Loot l, Damage d)
    {
        name = n;
        ammoPower = a;
        shieldPower = s;
        loot = new Loot(l.getNSupplies(), l.getNWeapons(), l.getNShields(), l.getNHangars(), l.getNMedals(), false, false);
        damage = d;
    }
    
    EnemyStarShip(EnemyStarShip e){ this(e.name, e.ammoPower, e.shieldPower, e.loot, e.damage); }
    
    EnemyToUI getUIversion(){ return new EnemyToUI(this); }
    
    @Override
    public float fire(){ return ammoPower; }

    public float getAmmoPower() { return ammoPower; }

    public Damage getDamage(){ return damage; }

    public Loot getLoot(){ return loot; }
    
    public String getName() { return name; }

    public float getShieldPower() { return shieldPower; }
    
    @Override
    public float protection(){ return shieldPower; }
    
    @Override
    public ShotResult receiveShot(float shot){ return (shieldPower < shot) ? ShotResult.DONOTRESIST : ShotResult.RESIST; }     
}

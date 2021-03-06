
/**
 *
 * @author antonio
 */

package deepspace;

public class EnemyStarShip implements SpaceFighter{
    
    private float ammoPower;
    private String name;
    private float shieldPower;
    private Loot loot;
    private Damage damage;

    EnemyStarShip(String n, float a, float s, Loot l, Damage d){
        name = n;
        ammoPower = a;
        shieldPower = s;
        loot = l;
        damage = d;
    }

    @Override
    public String toString() {
        return "EnemyStarShip{" + "ammoPower=" + ammoPower + ", name=" + name + ", shieldPower=" + shieldPower + ", damage=" + damage.toString() + '}';
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

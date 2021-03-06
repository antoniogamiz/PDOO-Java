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
public class Weapon implements CombatElement{

    private String name;
    private WeaponType type;
    private int uses;
    
    Weapon(String name, WeaponType type, int uses){
        this.name=name;
        this.type=type;
        this.uses=uses;
    }
    
    Weapon(Weapon w){
        this(w.name, w.getType(), w.getUses());
    }
    
    public WeaponType getType(){
        return type;
    }
    
    @Override
    public int getUses(){
        return uses;
    }
    
    public float power(){
        return type.getPower();
    }
    
    @Override
    public float useIt(){
        if( uses > 0 ){
            uses--;
            return power();
        }
        else
            return 1.0f;
    }
    
    WeaponToUI getUIversion(){
        return new WeaponToUI(this);
    }
    
    @Override
    public String toString() {
        return "Weapon{" + "name=" + name + ", type=" + type + ", uses=" + uses + '}';
    }
}

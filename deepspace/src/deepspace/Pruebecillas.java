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
public class Pruebecillas {
    public static void main(String [] args)
    {
        ArrayList w1 = new ArrayList<>();
        w1.add(WeaponType.LASER);
        w1.add(WeaponType.MISSILE);
        //w1.add(WeaponType.PLASMA);
        w1.add(WeaponType.LASER);

        ArrayList w2 = new ArrayList<>();
        w2.add(new Weapon("w3", WeaponType.LASER, 11));
        w2.add(new Weapon("w3", WeaponType.MISSILE, 10));
        w2.add(new Weapon("w3", WeaponType.MISSILE, 10));
        w2.add(new Weapon("w3", WeaponType.MISSILE, 10));
        w2.add(new Weapon("w3", WeaponType.MISSILE, 10));
        w2.add(new Weapon("w3", WeaponType.MISSILE, 10));
        w2.add(new Weapon("w3", WeaponType.MISSILE, 10));
        w2.add(new Weapon("w3", WeaponType.MISSILE, 10));
        w2.add(new Weapon("w3", WeaponType.MISSILE, 10));
        w2.add(new Weapon("w3", WeaponType.MISSILE, 10));
        w2.add(new Weapon("w3", WeaponType.PLASMA, 10));
        w2.add(new Weapon("w3", WeaponType.LASER, 10));
        
        ArrayList s1 = new ArrayList<>();
        s1.add(new ShieldBooster("s1", 10, 10));
        s1.add(new ShieldBooster("s1", 10, 10));
        s1.add(new ShieldBooster("s1", 10, 10));
        s1.add(new ShieldBooster("s1", 10, 10));

        
        //Damage d=new Damage(w1, 3);
        
        //Damage pendingDamage = d.adjust(w2, s1);
        
        //System.out.println(pendingDamage.toString());
    
        SpaceStation station = new SpaceStation("pruebas", new SuppliesPackage(1,2,3));
        
        
        station.receiveHangar(new Hangar(10));
        
        station.receiveWeapon(new Weapon("w1", WeaponType.LASER, 10));
        station.receiveWeapon(new Weapon("w1", WeaponType.MISSILE, 10));
        station.receiveWeapon(new Weapon("w1", WeaponType.MISSILE, 14));
        station.receiveWeapon(new Weapon("w1", WeaponType.MISSILE, 13));
        station.receiveWeapon(new Weapon("w1", WeaponType.MISSILE, 12));
        station.receiveWeapon(new Weapon("w1", WeaponType.PLASMA, 10));
        station.receiveShieldBooster(new ShieldBooster("s1", 10, 10));
        
        station.mountShieldBooster(0);
        station.mountWeapon(0);
        station.mountWeapon(0);
        station.mountWeapon(0);
        station.mountWeapon(0);
        station.mountWeapon(0);
        station.mountWeapon(0);
        
        station.setPendingDamage(new Damage(w1, 3));
        
        System.out.println(station.getPendingDamage().toString());
    }
}

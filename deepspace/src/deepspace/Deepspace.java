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
public class Deepspace {
    public static void main( String[] args ) {
        System.out.println("Programa de pruebas para P4");

        //Inicializamos GameUniverse
        GameUniverse game = new GameUniverse();
        ArrayList<String> names = new ArrayList();
        names.add("Antonio"); names.add("Antonio2");
        game.init(names);
        
        //nSupplies, nWeapons, nShields, nHangars, nMedals, [ef, city]
        Loot loot0 = new Loot( 0, 1, 2, 3, 10, true, false); //constructor protected MODIFICADO A PACAKGE
        Loot loot1 = new Loot( 0, 1, 2, 3, 10, false, true); //constructor protected MODIFICADO A PACAKGE
        
        ArrayList<WeaponType> weapons = new ArrayList();
        weapons.add( WeaponType.LASER );
        weapons.add( WeaponType.MISSILE );
        weapons.add( WeaponType.PLASMA );
        
        //Constructores cambiados a public para hacer pruebas!
        Damage damage0 = new NumericDamage(1,1);
        Damage damage1 = new SpecificDamage(weapons,10);
        
        CardDealer dealer = CardDealer.getInstance();
        
        //name, ammoPower, shieldPower, loot, damage
        EnemyStarShip enemy0 = new EnemyStarShip( "enemy0", 0, 0, loot0, damage0 );
        EnemyStarShip enemy1 = new EnemyStarShip( "enemy1", 0, 0, loot1, damage1 );
        
        //ammoPower, fuelUnits, shieldPower
        SuppliesPackage s = new SuppliesPackage( 100000, 100000, 100000 );
        
        //name, suppliesPackage
        SpaceStation space = new SpaceStation( "station0", s);
        
        CombatResult result;
        
        System.out.println("\n\nLuchando con enemy0");
        
        result=game.combat(space, enemy0);
        System.out.println( "La espacion se encuentra en un estado "+(space.validState() ? "valido": "invalido") );
        System.out.println("Resultado de la batalla: "+result);
        System.out.println( "La estacion "+( ( result==CombatResult.STATIONWINSANDCONVERT ) ? "" : "no ") + "se ha transformado" );

        System.out.println("\n\nLuchando con enemy1");

        result=game.combat(space, enemy1);
        System.out.println( "La espacion se encuentra en un estado "+(space.validState() ? "valido": "invalido") );
        System.out.println("Resultado de la batalla: "+result);
        System.out.println( "La estacion "+( ( result==CombatResult.STATIONWINSANDCONVERT ) ? "" : "no ") + "se ha transformado" );
    
    }
}

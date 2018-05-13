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
        names.add("JugadorTest1"); names.add("JugadorTest2");
        game.init(names);
        
        //Comentar linea 51 de CardDeck (Collections.suffle() en shuffle()
            
        //Aniadir esas dos lineas al principio de createSuppliesPackage() en CardDealer.
        //suppliesPackages.add(new SuppliesPackage(100000,100000,100000)); //primer jugador
        //suppliesPackages.add(new SuppliesPackage(100000,100000,100000)); //segundo jugador
        
        //Copiar esto encima del primer enemies.add(---) de createEnemies() en CardDealer
        //Loot l0=new Loot(1,1,1,1,1,true,false);
        //enemies.add(new EnemyStarShip("enemy0",0,0,l0,regularDamage0));
        //Loot l1=new Loot(1,1,1,1,1,false,true);
        //enemies.add(new EnemyStarShip("enemy1",0,0,l1,regularDamage0));
        //Loot l2=new Loot(1,1,1,1,1,true,true);
        //enemies.add(new EnemyStarShip("enemy2",0,0,l2,regularDamage0));        
        
        //Si añades primero enemy0, entonces la estacion se debera convertir en efficiente (normal o beta)
        //Si añades primero enemy1, entonces en SpaceCity
        //Si añedes primero enemy2, entonces descomenta el segundo combate y el resultado dependera
        //de tu implementacion (no se como hacer para que se transforme en efficient y en spacestation)
        
        
        //Modificar Dice.extraEfficiency() para que siempre devuelve true/false dependiendo de si quieres
        //probar PowerEfficientSpaceStation o BetaPowerEfficientSpaceStation
        
        
        //Recomendacion: sobreescribe metodos toString en las clases PowerEfficientSpaceStation y
        // BetaPowerEfficientSpaceStation para que muestren su nomnre, es decir:
        //@Override
        //public String toString(){ return "POWEREFFICIENT "+super.toString(); }

        CombatResult result;
        
        System.out.println("\n\nLuchando con enemy0, enemy1 o enemy2");
        
        result=game.combat();
        System.out.println("Resultado de la batalla: "+result);
        System.out.println( "La estacion "+( ( result==CombatResult.STATIONWINSANDCONVERTS ) ? "" : "no ") + "se ha transformado" );
        System.out.println(game.toString());
        
        game.nextTurn();
        
        System.out.println("\n\nLuchando con el mismo enemigo, con la estacion transformada");

        result=game.combat();
        System.out.println("Resultado de la batalla: "+result);
        System.out.println( "La estacion "+( ( result==CombatResult.STATIONWINSANDCONVERTS ) ? "" : "no ") + "se ha transformado" );
        System.out.println(game.toString());
    
    }
}

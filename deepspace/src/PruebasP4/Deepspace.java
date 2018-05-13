/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebasP4;
import java.util.ArrayList;

import deepspace.*;
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
        //Loot loot = new Loot( 0, 1, 2, 3, 4); constructor protected
        

    }
}

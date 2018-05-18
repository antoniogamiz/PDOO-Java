/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.util.ArrayList;

import deepspace.CombatResult;
import deepspace.GameState;
import deepspace.GameUniverse;
import deepspace.GameUniverseToUI;
import deepspace.LootToUI;
import deepspace.WeaponToUI;
import deepspace.WeaponType;

import View.View;
import View.GUI.MainView;
import View.GUI.NamesCapture;
/**
 *
 * @author antonio
 */
public class Controller {
    
    private GameUniverse model;
    private View view;

    public Controller(GameUniverse model_, View view_){
        model=model_;
        view=view_;
        view.setController(this);
    }
    
    public void start(){
        model.init( ( (MainView) view).getNames() );
        view.updateView();
        view.showView();
    }
    
    public void finish(int i){ 
        System.exit(i);
    }
    
    public WeaponToUI getTestWeapon(){ return model.getTestWeapon(); }
    public LootToUI getTestLoot(){ return model.getTestLoot(); }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @author antonio
*/


package Controller;

import deepspace.CombatResult;
import deepspace.GameState;
import deepspace.GameUniverse;
import deepspace.GameUniverseToUI;


import View.View;
import View.GUI.MainView;

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
    public GameUniverseToUI getUIversion() {
        return model.getUIversion();
    }

    public GameState getState() {
        return model.getState();
    }

    public CombatResult combat() {
        CombatResult result = model.combat();
        switch( result ){
            case ENEMYWINS:
                view.showEnemyWinsMessage();
                break;
            case STATIONESCAPES:
                view.showStationEscapesMessage();
                break;
            case STATIONWINS:
                if( haveAWinner() ){
                    view.showVictoryMessage();
                    System.exit(0);
                } else view.showYouWinMessage();
                break;
            case STATIONWINSANDCONVERTS:
                if( haveAWinner() ){
                    view.showVictoryMessage();
                    System.exit(0);
                } else view.showYouWinAndConvertMessage();
                break;
                
        }
        view.updateView();
        return result;
    }

    public boolean haveAWinner() {
        return model.haveAWinner();
    }

    public void discardHangar() {
        model.discardHangar();
        view.updateView();
    }

    public boolean nextTurn() {
        boolean result = model.nextTurn();
        
        if( !result )
            view.showNextTurnError();
        
        view.updateView();
        return result;
    }

    public void mountWeaponFromHangar(int option){
        model.mountWeapon(option); 
        view.updateView();
    }
    
    public void mountShieldBoosterFromHangar(int option){ 
        model.mountShieldBooster(option); 
        view.updateView();
    }
    
    public void discardShieldBoosterFromHangar(int option){ 
        model.discardShieldBoosterInHangar(option); 
        view.updateView();
    }    
    
    public void discardWeaponFromHangar(int option){ 
        model.discardWeaponInHangar(option);
        view.updateView();
    }
    
    public void discardWeapon(int option){
        model.discardWeapon(option); 
        view.updateView();
    }
    
    public void discardShieldBooster(int option){ 
        model.discardShieldBooster(option);
        view.updateView();
    }

}

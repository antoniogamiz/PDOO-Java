/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import deepspace.GameUniverse;

import View.View;
import View.GUI.MainView;

import Controller.Controller;
/**
 *
 * @author antonio
 */
public class PlayUI {
    public static void main(String[] args) {
        GameUniverse game = new GameUniverse();
        View view = new MainView();
        Controller controller = new Controller (game,view);
        
        controller.start();   // Let's play whith 2 players
    }
    
}

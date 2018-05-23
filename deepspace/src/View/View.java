/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;

/**
 *
 * @author antonio
 */
public interface View {
    public void setController(Controller c);
    public void updateView();
    public void showView();
    public void showNextTurnError();
    public void showEnemyWinsMessage();
    public void showStationEscapesMessage();
    public void showYouWinMessage();
    public void showYouWinAndConvertMessage();
    public void showVictoryMessage();
}

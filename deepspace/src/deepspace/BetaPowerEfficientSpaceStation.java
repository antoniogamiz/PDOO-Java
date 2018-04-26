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
public class BetaPowerEfficientSpaceStation extends PowerEfficientSpaceStation {
    private final float EXTRAEFFICIENCY=1.2f;
    private Dice dice;
    
    BetaPowerEfficientSpaceStation(SpaceStation station) { super(station); }
    
    public float fire() {
        if (dice.extraEfficiency()) {
           return EXTRAEFFICIENCY*super.fire();
        } else {
           return super.fire();
        }
    }
}

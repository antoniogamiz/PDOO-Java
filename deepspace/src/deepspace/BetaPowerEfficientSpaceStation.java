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
    private Dice dice=new Dice();
    
    public BetaPowerEfficientSpaceStation(SpaceStation station) { super(station); }
    
    @Override
    public float fire() {
        if (dice.extraEfficiency()) {
           return EXTRAEFFICIENCY*super.fire();
        } else {
           return super.fire();
        }
    }

    @Override
    public BetaPowerEfficientSpaceStationToUI getUIversion(){
        return new BetaPowerEfficientSpaceStationToUI(this);
    }
    
    @Override
    public String toString(){ return "BETAPOWEREFFICIENT "+super.toString(); }

}

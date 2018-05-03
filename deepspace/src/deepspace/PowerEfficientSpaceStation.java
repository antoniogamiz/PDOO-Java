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
public class PowerEfficientSpaceStation extends SpaceStation{
    
    private final float EFFICIENCYFACTOR=1.1f;
    
    public PowerEfficientSpaceStation (SpaceStation station) { super(station); } 
    
    @Override
    public float fire() {
        return super.fire()*EFFICIENCYFACTOR;
    }
    
    @Override
    public float protection() {
        return super.protection()*EFFICIENCYFACTOR;
    }
    
    @Override
    public Transformation setLoot(Loot loot){
        super.setLoot(loot);
        return Transformation.NOTRANSFORM;
}
}

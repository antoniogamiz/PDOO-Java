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
public class SpaceCity extends SpaceStation{

    private SpaceStation base;
    private ArrayList<SpaceStation> collaborators = new ArrayList();
    
    
    SpaceCity(SpaceStation base, ArrayList<SpaceStation> rest)
    {
        super(base);
        this.base=base;
        this.collaborators=rest;
    }
    
    public ArrayList<SpaceStation> getCollaborators(){ return collaborators; }
    
    @Override
    public float fire()
    {
        float fire = base.fire();
        for(int i = 0; i < collaborators.size(); ++i) fire += collaborators.get(i).fire();
        return fire;       
    }
    
    @Override
    public float protection()
    {
        float protect = base.protection();
        for(int i = 0; i < collaborators.size(); ++i) protect += collaborators.get(i).protection();
        return protect;
    }

    @Override
    public Transformation setLoot(Loot loot){
        super.setLoot(loot);
        return Transformation.NOTRANSFORM;
    }
    
    @Override
    public SpaceCityToUI getUIversion(){
        return new SpaceCityToUI(this);
    }
}

/**
 *
 * @author antonio
 */

package deepspace;

import java.util.ArrayList;

public class GameUniverse {
    
    private static final int WIN = 10;
    
    private int currentStationIndex;
    private int turns;
    private Dice dice;
    private GameStateController gameState;
    private SpaceStation currentStation;
    private EnemyStarShip currentEnemy;
    private ArrayList<SpaceStation> spaceStations;
    private boolean haveSpaceCity;
    
    public GameUniverse(){
        gameState = new GameStateController();
        turns = 0;
        dice = new Dice();
        haveSpaceCity=false;
    }
    
    CombatResult combat(SpaceStation station, EnemyStarShip enemy){
        boolean enemyWins;
        float fire;
        ShotResult result;
        CombatResult combatResult;
        
        if( dice.firstShot() == GameCharacter.ENEMYSTARSHIP ){
            fire = enemy.fire();
            result = station.receiveShot(fire);
            
            if( result == ShotResult.RESIST ){
                fire = station.fire();
                result = enemy.receiveShot(fire);
                enemyWins = (result == ShotResult.RESIST);
            }
            else 
                enemyWins = true;
        }
        else{
            fire = station.fire();
            result = enemy.receiveShot(fire);
            enemyWins = (result == ShotResult.RESIST);   
        }
        
        if(enemyWins){
            if(!dice.spaceStationMoves(station.getSpeed())){
                station.setPendingDamage(enemy.getDamage());
                combatResult = CombatResult.ENEMYWINS;
            } 
            else{
                station.move();
                combatResult = CombatResult.STATIONESCAPES;
            }
        }
        else{
            Loot loot=enemy.getLoot();
            Transformation t = station.setLoot(loot);
            combatResult = CombatResult.STATIONWINS;
            if(t == Transformation.GETEFFICIENT){
                makeStationEfficient();
                combatResult = CombatResult.STATIONWINSANDCONVERTS;
            }
            else if (t == Transformation.SPACECITY){
                createSpaceCity();
                combatResult = CombatResult.STATIONWINSANDCONVERTS;
            }
            
        }
        
        gameState.next(turns, spaceStations.size());
        
        return combatResult;
        
    }
    
    public CombatResult combat(){
        GameState state = gameState.getState();
        
        if( state == GameState.BEFORECOMBAT || state == GameState.INIT )
            return combat(currentStation, currentEnemy);
        else
            return CombatResult.NOCOMBAT;
    }
    
    private void makeStationEfficient(){
        currentStation=(dice.extraEfficiency()) ? new BetaPowerEfficientSpaceStation(currentStation): new PowerEfficientSpaceStation(currentStation);
        spaceStations.set(currentStationIndex, currentStation);
    }
    
    private void createSpaceCity(){
        if(!haveSpaceCity){
            ArrayList<SpaceStation> aux = new ArrayList(spaceStations);
            aux.remove(currentStationIndex);
            currentStation = new SpaceCity(currentStation, aux);
            spaceStations.set(currentStationIndex, currentStation);
            haveSpaceCity = true;
        }    
    }
    
    public void discardHangar(){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT)
            currentStation.discardHangar();
    }
    
    public void discardShieldBooster(int i){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT)
            currentStation.discardShieldBooster(i);
    }
    
    public void discardShieldBoosterInHangar(int i){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT)
            currentStation.discardShieldBoosterInHangar(i);
    }
    
    public void discardWeapon(int i){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT)
            currentStation.discardWeapon(i);
        
    }
    
    public void discardWeaponInHangar(int i){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT)
            currentStation.discardWeaponInHangar(i);
        
    }

    public GameState getState() { return gameState.getState(); }

    public GameUniverseToUI getUIversion(){ return new GameUniverseToUI(currentStation, currentEnemy); }
    
    public boolean haveAWinner(){ return currentStation.getNMedals() >= WIN; }

    public void init(ArrayList<String> names){
        if( getState()==GameState.CANNOTPLAY ){
            spaceStations = new ArrayList<>();
            CardDealer dealer = CardDealer.getInstance();
            
            int nh; 
            int nw;
            int ns;
            
            SuppliesPackage supplies;
            SpaceStation station;
            Loot loot;
            
            for( String name: names ){
                supplies = dealer.nextSuppliesPackage();
                station = new SpaceStation(name, supplies);
                
                nh = dice.initWithNHangars();
                nw = dice.initWithNWeapons();
                ns = dice.initWithNShields();
                
                loot = new Loot(0, nw, ns, nh, 0);
                station.setLoot(loot);
                spaceStations.add(station);
            }
            
            currentStationIndex = dice.whoStarts(names.size());
            currentStation = spaceStations.get(currentStationIndex);
            currentEnemy = dealer.nextEnemy();
            
            gameState.next(turns, spaceStations.size());
        }
    }
    
    public void mountShieldBooster(int i){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT)
            currentStation.mountShieldBooster(i);
        
    }
    
    public void mountWeapon(int i){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT)
            currentStation.mountWeapon(i);
        
    }
    
    public boolean nextTurn(){
        GameState state = gameState.getState();
        
        if(state == GameState.AFTERCOMBAT){
            boolean stationState = currentStation.validState();
         
            if(stationState){
                currentStationIndex=(currentStationIndex+1)%spaceStations.size();
                turns++;
                
                currentStation=spaceStations.get(currentStationIndex);
                currentStation.cleanUpMountedItems();
                CardDealer dealer = CardDealer.getInstance();
                currentEnemy = dealer.nextEnemy();           
                gameState.next(turns, spaceStations.size());
                
                return true;
            }
            else
                return false;
            
        }
        else
            return false;
    }
    
    @Override
    public String toString() {
        return "GameUniverse{" + "currentStationIndex=" + currentStationIndex + ", turns=" + turns + ", dice=" + dice + ", gameState=" + gameState + ", currentStation=" + currentStation + ", currentEnemy=" + currentEnemy + ", spaceStations=" + spaceStations + '}';
    }
    
}

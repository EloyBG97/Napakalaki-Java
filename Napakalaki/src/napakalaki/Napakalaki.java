/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Adri
 */
public class Napakalaki {
    private static final Napakalaki instance = new Napakalaki();
    private Monster currentMonster;
    private CardDealer dealer;
    private Player currentPlayer;
    private ArrayList<Player> players;
 
    private Napakalaki(){}
    
    private void initPlayer(ArrayList<String> names){
        for (int i = 0 ; i < names.size() ; i++)
            players.add(new Player(names.get(i)));
    }
    
    private Player nextPlayer(){
        
        
        return currentPlayer;
    }
    
    //private boolean nextTurnAllowed(){ }
    
    public static Napakalaki getInstance(){
        return instance;
    }
    
    //public CombatResult developCombat(){ }
    
    //public void discardVisibleTreasure(ArrayList<Treasure> treasures){ }
    
    //public void discardHiddenTreasure(ArrayList<Treasure> treasures){ }
    
    //public void makeTreasureVisible(ArrayList<Treasure> treasures){ }
    
    public void initGame(ArrayList<String> players){
        initPlayer(players);
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster() {
        return currentMonster;
    }
    
    //public boolean nextTurn() { }
    
    //public boolean endOfGame(CombatResult result){ }
}
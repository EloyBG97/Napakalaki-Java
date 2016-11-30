/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Adri
 * 
 */
public class Napakalaki {
    private static final Napakalaki instance = new Napakalaki();
    private Monster currentMonster;
    private CardDealer dealer;
    private Player currentPlayer;
    private ArrayList<Player> players;
 
    private Napakalaki(){
        currentMonster = null;
        dealer = CardDealer.getInstance();
        currentPlayer = null;
        players = new ArrayList<>();
    }
    
    private void initPlayer(ArrayList<String> names){
        for (int i = 0 ; i < names.size() ; i++)
            players.add(new Player(names.get(i)));
        
        currentPlayer = nextPlayer();
    }
    
    private Player nextPlayer(){
        int pos;
        
        if (currentPlayer == null)
            pos = Dice.getInstance().nextNumber() % players.size();
        else
            pos = (players.indexOf(currentPlayer) + 1) % players.size();
        
        currentPlayer = players.get(pos);
        return currentPlayer;
    }
    
    private boolean nextTurnAllowed(){
        if (currentPlayer == null)
            return true;
        else
            return currentPlayer.validState();
    }
    
    private void setEnemies(){
        Random rnd = new Random();
        int idx;
        
        for (Player p : players){
            do{
                idx = rnd.nextInt() % players.size();
            }while (players.get(idx) == p);

            p.setEnemy(players.get(idx));
        }
    }
    
    public static Napakalaki getInstance(){
        return instance;
    }
    
    public CombatResult developCombat(){
        CombatResult combatResult = currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        return combatResult;
    }
    
    public void discardVisibleTreasure(ArrayList<Treasure> treasures){
        for (Treasure t : treasures){
            currentPlayer.discardVisibleTreasure(t);
            dealer.giveTreasureBack(t);
        }
    }
    
    public void discardHiddenTreasure(ArrayList<Treasure> treasures){
        for (Treasure t : treasures){
            currentPlayer.discardHiddenTreasure(t);
            dealer.giveTreasureBack(t);
        }
    }
    
    public void makeTreasureVisible(ArrayList<Treasure> treasures){
        for (Treasure t : treasures)
            currentPlayer.makeTreasureVisible(t);
    }
    
    public void initGame(ArrayList<String> players){
        initPlayer(players);
        setEnemies();
        dealer.initCards();
        nextTurn();
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster() {
        return currentMonster;
    }
    
    public boolean nextTurn() {
        boolean stateOK = nextTurnAllowed();
        
        if (stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            boolean dead = currentPlayer.isDead();
            
            if(dead){
                currentPlayer.initTreasures();
            }
        }
        
        return stateOK;
    }
    
    public boolean endOfGame(CombatResult result){
        return (result == CombatResult.WINGAME);
    }
}
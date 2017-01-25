/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Random;
import GUI.Dice;

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
    private static int jugada = 0;
 
    private Napakalaki(){
        currentMonster = null;
        dealer = CardDealer.getInstance();
        currentPlayer = new Player("");
        players = new ArrayList<>();
    }
    
    private void initPlayer(ArrayList<String> names){
        for (String n : names)
            players.add(new Player(n));
        
        currentPlayer = nextPlayer();
    }
    
    private Player nextPlayer(){
        Random rnd = new Random();
        int pos;
        
        if (jugada == 0)
            pos = (rnd.nextInt(6) + 1) % players.size();
        else
            pos = (players.indexOf(currentPlayer) + 1) % players.size();
        
        currentPlayer = players.get(pos);
        return currentPlayer;
    }
    
    private boolean nextTurnAllowed(){
        if (jugada == 0)
            return true;
        else
            return currentPlayer.validState();
    }
    
    private void setEnemies(){
        Random rnd = new Random();
        int idx;
        
        for (Player p : players){
            do{
                idx = (int) rnd.nextInt(players.size());
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
        
        if (combatResult == CombatResult.LOSEANDCONVERT){
            Player nuevo = new CultistPlayer(currentPlayer, dealer.nextCultist());
            players.set(players.indexOf(currentPlayer), nuevo);
            
            for (Player p : players){
                if (p.getEnemy() == currentPlayer)
                    p.setEnemy(nuevo);
            }
            
            currentPlayer = nuevo;
        }
        
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

            jugada++;
        }
        else if (currentPlayer.getPendingBadConsequence() != null 
                && !currentPlayer.getPendingBadConsequence().isEmpty()){
            currentPlayer.applyPendingBadConsequence();
            stateOK = nextTurn();
        }
        
        return stateOK;
    }
    
    public boolean endOfGame(CombatResult result){
        return (result == CombatResult.WINGAME);
    }
}
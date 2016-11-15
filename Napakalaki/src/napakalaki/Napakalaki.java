/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.*;
        
public class Napakalaki {
 private static final Napakalaki instance= new Napakalaki();
 private Monster currentMonster;
 private CardDealer dealer;
 private Player currentPlayer;
 private ArrayList<Player> players;
 
 private Napakalaki(){}
 private Player initPlayer(ArrayList<String> names){}
 private Player nextPlayer(){}
 private boolean nextTurnAllowed(){}
 public static Napakalaki getInstance(){
     return instance;
 }
 public CombatResult developCombat(){}
 public void discardVisibleTreasure(ArrayList<Treasure> treasures){}
 public void discardHiddenTreasure(ArrayList<Treasure> treasures){}
 public void makeTreasureVisible(ArrayList<Treasure> treasures){}
 public void initGame(ArrayList<String> players){
     for(int i=0;i<this.players.size();++i){
           Player play = new Player(players.get(i));
           this.players.add(play);
     }
 }
 public Player getCurrentPlayer(){
     return currentPlayer;
 }
 public Monster getCurrentMonster() {
     return currentMonster;
 }
 public boolean nextTurn() {}
 public boolean endOfGame(CombatResult result){}
}

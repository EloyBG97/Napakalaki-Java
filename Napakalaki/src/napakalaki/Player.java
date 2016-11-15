/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package napakalaki;

import java.util.ArrayList;

public class Player {
     static final int  MAXLEVEL=10;
     private String name;
     private int level;
     private boolean dead=true;
     private static boolean canISteal=true;
     private ArrayList<Treasure> hiddenTreasures;
     private ArrayList<Treasure> visibleTreasures;
     private BadConsequence pendingBadConsequence;
     private Player enemy;
     
     private void bringToLife(){ 
         dead=false;
     }
     private int getCombatLevel(){ 
         int bonus=0;
         
         for(int i=0;i<visibleTreasures.size();i++) {
             bonus+=visibleTreasures.get(i).getBonus();
         }
         
         for(int i=0;i<hiddenTreasures.size();i++) {
             bonus+=hiddenTreasures.get(i).getBonus();
         }
         
         return level+bonus;
     }
     private void incrementLevels(int l){
         level+=l;
     }
     private void decrementLevels(int l){ 
         level-=l;
     }
     private void setPendingBadConsequence(BadConsequence b) {
           pendingBadConsequence=b;
     }
     private void applyPrize(Monster m){}
     private void applyBadConsequence(Monster m){}
     private boolean canMakeTreasureVisible(Treasure t){}
     private int howManyVisibleTreasures(TreasureKind tKind){
         int cont=0;
         for(int i=0;i<visibleTreasures.size();i++) {
             if(visibleTreasures.get(i).getType()==tKind)
                 ++cont;
         }
         
         return cont;
     }
     private void dieIfNoTreasures(){
         if(hiddenTreasures.isEmpty() && visibleTreasures.isEmpty()){
              dead=true;
         }
     }
     private Treasure giveMeATreasure(){}
     private boolean canYouGiveMeATreasure(){
         return (visibleTreasures.size()>0 || hiddenTreasures.size()>0);
     }
     private void haveStolen(){
         canISteal=false;
     }
 
     public Player(String name){
         this.name=name;
     }
     public String getName(){
         return name;
     }
     public boolean isDead(){
         return dead;
     }
     public ArrayList<Treasure> getHiddenTreasures(){
         return hiddenTreasures;
     }
     public ArrayList<Treasure> getVisibleTreasures(){
         return visibleTreasures;
     }
     public CombatResult combat(Monster m){}
     public void makeTreasureVisible(Treasure t){}
     public void discardVisibleTreasure(Treasure t){}
     public void discardHiddenTreasure(Treasure t){}
     public boolean validState(){
         if(pendingBadConsequence==null && hiddenTreasures.size()<=4) {
             return true;
         }
         else
             return false;
     }
     public void initTreasures(){}
     public int getLevels(){
         return level;
     }
     public Treasure stealTreasure(){}
     public void setEnemy(Player enemy){
         this.enemy=enemy;
     }
     public boolean canISteal(){
         return canISteal;
     }
     public void discardAllTreasures(){
          hiddenTreasures.removeAll(hiddenTreasures);
     }
}

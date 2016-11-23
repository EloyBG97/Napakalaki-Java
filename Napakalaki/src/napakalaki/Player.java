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
public class Player {
    static final int  MAXLEVEL=10;
    private String name;
    private int level;
    private boolean dead = true;
    private static boolean canISteal = true;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private Player enemy;
    private BadConsequence pendingBadConsequence;
    
    public Player(String name){
        this.name = name;
        this.level = 1;
        this.hiddenTreasures = new ArrayList();
        this.visibleTreasures = new ArrayList();
    }
    
    private void bringToLife(){
        dead = false;
    }
    
    private int getCombatLevel(){
        int lvl = level;
        
        for (int i = 0 ; i < visibleTreasures.size() ; i++)
            lvl += visibleTreasures.get(i).getBonus();
        
        return lvl;
    }
    
    private void incrementLevels(int l){
        level += l;
    }
    
    private void decrementLevels(int l){
        level -= l;
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence = b;
    }
    
    private void applyPrize(Monster m){}
    
    private void applyBadConsequence(Monster m){}
    
    //private boolean canMakeTreasureVisible(Treasure t){}
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        int howMany = 0;
        
        for (int i = 0 ; i < visibleTreasures.size() ; i++){
            if (visibleTreasures.get(i).getType() == tKind)
                howMany++;
        }
        
        return howMany;
    }
    
    private void dieIfNoTreasures(){
        if(hiddenTreasures.isEmpty() && visibleTreasures.isEmpty()){
            dead=true;
        }
    }
    
    //private Treasure giveMeATreasure(){}
    
    private boolean canYouGiveMeATreasure(){
        return !visibleTreasures.isEmpty();
    }
    
    private void haveStolen(){
        canISteal = !canISteal; 
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
    
    //public CombatResult combat(Monster m){}
    
    public void makeTreasureVisible(Treasure t){}
    
    public void discardVisibleTreasure(Treasure t){}
    
    public void discardHiddenTreasure(Treasure t){}
    
    public boolean validState(){
        return (hiddenTreasures.size() <= 4 && pendingBadConsequence.isEmpty());
    }
    
    public void initTreasures(){}
    
    public int getLevels(){
        return level;
    }
    
    //public Treasure stealTreasure(){}
    
    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }
    
    public boolean canISteal(){
        return canISteal;
    }
    
    public void discardAllTreasures(){
        hiddenTreasures.removeAll(hiddenTreasures);
    }
}
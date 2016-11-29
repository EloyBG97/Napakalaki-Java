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
 * 
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
    
    private void applyPrize(Monster m){
        level += m.getLevelsGained();
        
        for (int i = 0 ; i < m.getTreasuesGained() ; i++)
            hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
    }
    
    private void applyBadConsequence(Monster m){
        BadConsequence badConsequence = m.getBadConsequence();
        level -= badConsequence.getLevels();
        
        BadConsequence pendingBad = badConsequence.adjustToFitTreasureList(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        boolean can = true;
        int numOneHand = 0, numBothHands = 0, numIguales = 0;
        
        for (Treasure i : visibleTreasures){
            if (i.getType() == TreasureKind.ONEHAND)
                numOneHand++;
            else if(i.getType() == TreasureKind.BOTHHANDS)
                numBothHands++;
            else if (i.getType() == t.getType())
                numIguales++;
        }
        
        if (t.getType() == TreasureKind.ONEHAND){
            if (!(numOneHand < 2 && numBothHands != 0) || numBothHands != 0)
                can = false;
        }
        else if (numIguales != 0){
            can = false;
        }
        
        return can;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        int howMany = 0;
        
        for (int i = 0 ; i < visibleTreasures.size() ; i++){
            if (visibleTreasures.get(i).getType() == tKind)
                howMany++;
        }
        
        return howMany;
    }
    
    private void dieIfNoTreasures(){
        if(hiddenTreasures.isEmpty() && visibleTreasures.isEmpty())
            dead = true;
    }
    
    private Treasure giveMeATreasure(){
        int pos = Dice.getInstance().nextNumber() % hiddenTreasures.size();
        return hiddenTreasures.get(pos);
    }
    
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
    
    public CombatResult combat(Monster m){
        CombatResult combatResult;
        int myLevel = getCombatLevel();
        int monsterLevel = m.getCombatLevel();
        
        if (!canISteal){
            Dice dice = Dice.getInstance();
            int number = dice.nextNumber();
            if (number < 3)
                monsterLevel += enemy.getCombatLevel();
        }
        
        if(myLevel > monsterLevel){
            applyPrize(m);
            if (level >= MAXLEVEL)
                combatResult = CombatResult.WINGAME;
            else
                combatResult = CombatResult.WIN;
        }
        else{
            applyBadConsequence(m);
            combatResult = CombatResult.LOSE;
        }
        
        return combatResult;
    }
    
    public void makeTreasureVisible(Treasure t){
        if (canMakeTreasureVisible(t)){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        
        if(pendingBadConsequence != null && !pendingBadConsequence.isEmpty())
            pendingBadConsequence.substractVisibleTreasure(t);
        
        this.dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        
        if(pendingBadConsequence != null && !pendingBadConsequence.isEmpty())
            pendingBadConsequence.substractVisibleTreasure(t);
        
        this.dieIfNoTreasures();
    }
    
    public boolean validState(){
        return (hiddenTreasures.size() <= 4 && pendingBadConsequence.isEmpty());
    }
    
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        Treasure treasure;
        
        bringToLife();
        treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        int number = dice.nextNumber();
        
        if (number > 1){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        
        if (number == 6){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
    
    public int getLevels(){
        return level;
    }
    
    public Treasure stealTreasure(){
        Treasure treasure = null;
        
        if(canISteal())
            if (enemy.canYouGiveMeATreasure()){
                treasure = enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                haveStolen();
            }
        
        return treasure;
    }
    
    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }
    
    public boolean canISteal(){
        return canISteal;
    }
    
    public void discardAllTreasures(){
        ArrayList<Treasure> visible = new ArrayList(visibleTreasures);
        ArrayList<Treasure> hidden = new ArrayList(hiddenTreasures);
        
        if (!visible.isEmpty())
            for (Treasure t : visible)
                discardVisibleTreasure(t);
        
        if (!hidden.isEmpty())
            for (Treasure t : hidden)
                discardHiddenTreasure(t);
                    
    }
}
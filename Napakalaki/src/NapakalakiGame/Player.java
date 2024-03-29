/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import GUI.Dice;
import java.util.Random;

/**
 *
 * @author Adri
 * 
 */
public class Player {
    static final int  MAXLEVEL=10;
    private String name;
    private int level;
    private boolean dead;
    private boolean canISteal;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    protected Player enemy;
    private BadConsequence pendingBadConsequence;
    
    public Player(String name){
        this.name = name;
        this.level = 1;
        this.dead = true;
        this.canISteal = true;
        this.hiddenTreasures = new ArrayList();
        this.visibleTreasures = new ArrayList();
        this.enemy = null;
    }
    
    public Player(Player p){
        this.name = p.name;
        this.level = p.level;
        this.dead = p.dead;
        this.canISteal = p.canISteal;
        this.hiddenTreasures = p.hiddenTreasures;
        this.visibleTreasures = p.visibleTreasures;
        this.enemy = p.enemy;
    }
    
    private void bringToLife(){
        dead = false;
    }
    
    protected int getCombatLevel(){
        int lvl = level;
        
        for (Treasure t : visibleTreasures)
            lvl += t.getBonus();
        
        return lvl;
    }
    
    protected int getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    
    protected boolean shouldConvert(){
        return (Dice.getInstance().nextNumber("Llamada en metodo", "shouldConvert") == 1);
    }
    
    private void incrementLevels(int l){
        level += l;
    }
    
    private void decrementLevels(int l){
        if (level - l >= 1)
            level -= l;
        else
            level = 1;
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence = b;
    }
    
    public BadConsequence getPendingBadConsequence() {
        return pendingBadConsequence;
    }
    
    private void applyPrize(Monster m){
        incrementLevels(m.getLevelsGained());
        
        for (int i = 0 ; i < m.getTreasuesGained() ; i++)
            hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
    }
    
    private void applyBadConsequence(Monster m){
        BadConsequence badConsequence = m.getBadConsequence();
        decrementLevels(badConsequence.getLevels());
        
        BadConsequence pendingBad = badConsequence.adjustToFitTreasureList(visibleTreasures, hiddenTreasures);
        
        setPendingBadConsequence(pendingBad);
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        boolean can = false;
        int numOneHand = 0, numBothHands = 0;
        int numIguales = howManyVisibleTreasures(t.getType());
        
        for (Treasure i : visibleTreasures){
            if (i.getType() == TreasureKind.ONEHAND)
                numOneHand++;
            else if(i.getType() == TreasureKind.BOTHHANDS)
                numBothHands++;
        }
        
        if (t.getType() == TreasureKind.ONEHAND){
            if (numOneHand < 2 && numBothHands == 0)
                can = true;
        }
        else if (t.getType() == TreasureKind.BOTHHANDS){
            if (numOneHand == 0 && numBothHands == 0)
                can = true;
        }
        else if (numIguales == 0){
            can = true;
        }
        
        return can;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        int howMany = 0;
        
        for (Treasure t : visibleTreasures){
            if (t.getType() == tKind)
                howMany++;
        }
        
        return howMany;
    }
    
    private void dieIfNoTreasures(){
        if(hiddenTreasures.isEmpty() && visibleTreasures.isEmpty())
            dead = true;
    }
    
    protected Treasure giveMeATreasure(){
        int pos = Dice.getInstance().nextNumber("Llamada en metodo", "giveMeATreasure") % hiddenTreasures.size();
        return hiddenTreasures.get(pos);
    }
    
    protected boolean canYouGiveMeATreasure(){
        return !hiddenTreasures.isEmpty();
    }
    
    private void haveStolen(){
        canISteal = false; 
    }
    
    public String getName(){
        return name;
    }
    
    public boolean isDead(){
        return dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return new ArrayList(hiddenTreasures);
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return new ArrayList(visibleTreasures);
    }
    
    public CombatResult combat(Monster m){
        CombatResult combatResult;
        int myLevel = getCombatLevel();
        int monsterLevel = getOponentLevel(m);
        
        if (!canISteal){
            int number = Dice.getInstance().nextNumber("Llamada en metodo", "Combat");
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
            if (shouldConvert())
                combatResult = CombatResult.LOSEANDCONVERT;
            else
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
        if (pendingBadConsequence == null)
            return hiddenTreasures.size() <= 4;
        else
            return (hiddenTreasures.size() <= 4 && pendingBadConsequence.isEmpty());
    }
    
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Treasure treasure;
        
        bringToLife();
        treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        int number = Dice.getInstance().nextNumber("Llamada en metodo", "initTreasures");
        
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
    
    public void applyPendingBadConsequence(){
        ArrayList<Treasure> sVisible = new ArrayList<>(visibleTreasures);
        ArrayList<Treasure> sHidden = new ArrayList<>(hiddenTreasures);
        ArrayList<TreasureKind> pVisible = new ArrayList<>(pendingBadConsequence.getSpecificVisibleTreasures());
        ArrayList<TreasureKind> pHidden = new ArrayList<>(pendingBadConsequence.getSpecificHiddenTreasures());
        int nVisible = pendingBadConsequence.getNVisibleTreasures();
        int nHidden = pendingBadConsequence.getNHiddenTreasures();

        if (!pVisible.isEmpty())
            for(Treasure v : sVisible)
                if (pVisible.contains(v.getType()))
                    discardVisibleTreasure(v);

        if (!pHidden.isEmpty())
            for(Treasure h : sHidden)
                if (pHidden.contains(h.getType()))
                    discardHiddenTreasure(h);
        
        if (nVisible != 0)
            for (Treasure v : sVisible)
                discardVisibleTreasure(v);

        if (nHidden != 0)
            for (Treasure h : sHidden)
                discardHiddenTreasure(h);
            
        pendingBadConsequence = null;
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
    
    public Player getEnemy(){
        return enemy;
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
    
    public String toString(){
        String mensaje = (name + "\nNivel: " + level
                + "\nDead: " + dead + "\nCan I Steal: " + canISteal
                + "\nVisible Treasures: \t" + visibleTreasures
                + "\nHidden Treasures: \t" + hiddenTreasures
                + "\nEnemy: " + enemy.name);
        
        if (pendingBadConsequence != null)
            mensaje += "\nPending Bad Consequence: \n\t" 
                + pendingBadConsequence.toString();
        else
            mensaje += "\nNo hay Bad Consequence pendiente";
        
        return mensaje;
    }
}
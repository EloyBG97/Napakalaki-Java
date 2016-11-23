/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Adri
 */
public class Monster {
    private String name;
    private int combatLevel;
    private BadConsequence bc;
    private Prize prize;
    
    public Monster(String name, int level, BadConsequence bc, Prize prize){
        this.name = name;
        this.combatLevel = level;
        this.bc = bc;
        this.prize = prize;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }   
    
    public BadConsequence getBadConsequence(){
        return bc;
    }
    
    public Prize getPrize(){
        return prize;
    }
    
    public int getLevelsGained() {
           return prize.getLevels();
    }
    
    public int getTreasuesGained() {
            return prize.getTreasures();
    }
    public String toString(){
        return "Name = " + name + "\nCombat level = " 
                + Integer.toString(combatLevel)
                + "\nBad consecuences: " + bc.toString() 
                + "\nPrize: " + prize.toString();
    }
}

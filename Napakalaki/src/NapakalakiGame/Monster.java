/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author Adri
 * 
 */
public class Monster {
    private String name;
    private int combatLevel;
    private BadConsequence bc;
    private Prize prize;
    private int levelChangeAgainstCultistPlayer;
    
    public Monster(String name, int level, BadConsequence bc, Prize prize, int levelChange){
        this.name = name;
        this.combatLevel = level;
        this.bc = bc;
        this.prize = prize;
        this.levelChangeAgainstCultistPlayer = levelChange;
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
    
    public int getCombatLevelAgainstCultistPlayer(){
        return combatLevel + levelChangeAgainstCultistPlayer;
    }
    
    public int getLevelChangeAgainstCultistPlayer(){
        return levelChangeAgainstCultistPlayer;
    }
    
    public String toString(){
        String mensaje = "Name = " + name + "\nCombat level = " 
                + Integer.toString(combatLevel)
                + "\nBad consecuence: " + bc.toString() 
                + "\nPrize: " + prize.toString();
        
        if (levelChangeAgainstCultistPlayer != 0){
            if (levelChangeAgainstCultistPlayer > 0)
                mensaje += "\n\n+" + Integer.toString(levelChangeAgainstCultistPlayer);
            else
                mensaje += "\n\n" + Integer.toString(levelChangeAgainstCultistPlayer);
            
            mensaje += " contra sectarios";
        }
        
        return mensaje;
    }
}

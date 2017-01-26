/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import GUI.Dice;

/**
 *
 * @author Adri
 * 
 */
public class CultistPlayer extends Player{
    private static int TotalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        myCultistCard = c;
        TotalCultistPlayers++;
    }
    
    protected int getCombatLevel(){
        int lvl = getLevels();
        
        for (Treasure t : getVisibleTreasures())
            lvl += t.getBonus();
        
        lvl += lvl * 0.2;
        lvl += myCultistCard.getGainedLevels() * TotalCultistPlayers;
        
        return (int)lvl;
    }
    
    public Cultist getCultistCard(){
        return myCultistCard;
    }
    
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    protected boolean shouldConvert(){
        return false;
    }
    
    protected Treasure giveMeATreasure(){
        int pos = Dice.getInstance().nextNumber("Llamada en metodo", "giveMeATreasure") % getVisibleTreasures().size();
        
        return getVisibleTreasures().get(pos);
    }
    
    protected boolean canYouGiveMeATreasure(){
        return !getVisibleTreasures().isEmpty();
    }
    
    public int getTotalCultistPlayers(){
        return TotalCultistPlayers;
    }
    
    public String toString(){
        String mensaje = (getName() + "\nNivel: " + getLevels()
                + "\nDead: " + isDead() + "\nCan I Steal: " + canISteal()
                + "\nSectario: " + myCultistCard.toString()
                + "\nVisible Treasures: \t" + getVisibleTreasures()
                + "\nHidden Treasures: \t" + getHiddenTreasures()
                + "\nEnemy: " + enemy.getName());
        
        if (getPendingBadConsequence() != null)
            mensaje += "\nPending Bad Consequence: \n\t" 
                + getPendingBadConsequence().toString();
        else
            mensaje += "\nNo hay Bad Consequence pendiente";
        
        return mensaje;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Adri
 * 
 */
public class CultistPlayer extends Player{
    static int TotalCultistPlayer = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        myCultistCard = c;
    }
    
    //protected int getCombatLevel(){}
    
    //protected int getOponentLevel(){}
    
    //protected boolean shouldConvert(){}
    
    //private Treasure giveMeATreasure(){}
    
    //private boolean canYouGiveMeATreasure(){}
    
    public int getTotalCultistPlayers(){
        return TotalCultistPlayer;
    }
}

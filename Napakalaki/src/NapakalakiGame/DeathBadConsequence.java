/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author Adri
 * 
 */
public class DeathBadConsequence extends NumericBadConsequence{
    private boolean death;
    
    public DeathBadConsequence(String text, boolean death){
        super(text,0,MAXTREASURES,MAXTREASURES);
        this.death = death;
    }
    
    public boolean getDeath(){
        return death;
    }
    
    public String toString(){
        return getText() 
            + "\n\tlevels = " + getLevels()
            + "\n\tdeath = " + death;
    }
}

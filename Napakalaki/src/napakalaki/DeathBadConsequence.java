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
public class DeathBadConsequence extends NumericBadConsequence{
    private boolean death;
    
    public DeathBadConsequence(String text, boolean death){
        super(text,0,0,0);
        this.death = death;
    }
    
    public boolean getDeath(){
        return death;
    }
    
    public String toString(){
        return super.toString() + "\n\tdeath = " + death;
    }
}

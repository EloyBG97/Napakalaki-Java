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
public class Cultist {
    private String name;
    private int gainedLevels;
    
    public Cultist(String name, int gainedLevels){
        this.name = name;
        this.gainedLevels = gainedLevels;
    }
    
    public int getGainedLevels(){
        return gainedLevels;
    }
    
    public String toString(){
        return "\t+" + Integer.toString(gainedLevels) + " por cada sectario en juego"
            + "\n\t\tNo puedes dejar de ser sectario";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import java.util.*;
/**
 *
 * @author Adri
 * 
 */
public abstract class BadConsequence {
    private String text;
    private int levels;
    
    public BadConsequence(String text, int levels){
        this.text = text;
        this.levels = levels;
    }
    
    public boolean isEmpty(){
        return true;
    }
    
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    public abstract int getNVisibleTreasures();
    public abstract int getNHiddenTreasures();
    public abstract ArrayList getSpecificVisibleTreasures();
    public abstract ArrayList getSpecificHiddenTreasures();
    public abstract void substractVisibleTreasure(Treasure t);
    public abstract void substractHiddenTreasure(Treasure t);
    public abstract BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h);
    
    public String toString(){
        return text 
            + "\n\tlevels = " + levels;
    }
}
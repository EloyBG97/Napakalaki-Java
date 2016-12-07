/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.*;
/**
 *
 * @author Adri
 */
public class BadConsequence {
    static final int MAXTREASURES=10;
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures;
    
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
        this.death = false;  
        this.specificHiddenTreasures = new ArrayList<>();
        this.specificVisibleTreasures = new ArrayList<>();
        
    }
    
    public BadConsequence(String text, boolean death){
        this.text = text;
        this.levels = Player.MAXLEVEL;
        this.nVisibleTreasures = MAXTREASURES;
        this.nHiddenTreasures = MAXTREASURES;
        this.death = death;
        this.specificHiddenTreasures = new ArrayList<>();
        this.specificVisibleTreasures = new ArrayList<>();
    }
    
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = 0;
        this.nHiddenTreasures = 0;
        this.death = false;
        this.specificVisibleTreasures = new ArrayList(tVisible);
        this.specificHiddenTreasures = new ArrayList(tHidden);
    }
    
    public boolean isEmpty() {
        return (specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty()
                && nVisibleTreasures == 0 && nHiddenTreasures == 0);
    }
    
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    public boolean getDeath(){
        return death;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return new ArrayList(specificHiddenTreasures);
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return new ArrayList(specificVisibleTreasures);
    }
       
    public void substractVisibleTreasure(Treasure T){
        if(!specificVisibleTreasures.isEmpty())
            if(!specificVisibleTreasures.remove(T.getType()))
                if(nVisibleTreasures > 1)
                    nVisibleTreasures--;
    }
    
    public void substractHiddenTreasure(Treasure T){
        if(!specificHiddenTreasures.isEmpty())
            if(!specificHiddenTreasures.remove(T.getType()))
                if (nHiddenTreasures > 1)
                    nVisibleTreasures--;
    }
    
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h ){
        BadConsequence bad = null;
        int nVisible = 0, nHidden = 0;
        ArrayList<TreasureKind> sVisible = new ArrayList<>();
        ArrayList<TreasureKind> sHidden = new ArrayList<>();
        
        if (!v.isEmpty()){
            if (!specificVisibleTreasures.isEmpty()){
                for (Treasure t : v)
                    if (specificVisibleTreasures.contains(t.getType()) && !sVisible.contains(t.getType()))
                        sVisible.add(t.getType());
            }
            
            if (sVisible.isEmpty()){
                if (nVisibleTreasures > v.size())
                    nVisible = v.size();
                else if (nVisibleTreasures > 0)
                    nVisible = nVisibleTreasures - v.size();
            }
            
        }
        else{
            if (nVisibleTreasures > v.size())
                nVisible = v.size();
            else if (nVisibleTreasures > 0)
                nVisible = nVisibleTreasures - v.size();
        }
        
        if (!h.isEmpty()){
            if (!specificHiddenTreasures.isEmpty()){
                for (Treasure t : h)
                    if (specificHiddenTreasures.contains(t.getType()) && !sHidden.contains(t.getType()))
                        sHidden.add(t.getType());
            }
            
            if (sHidden.isEmpty()){
                if (nHiddenTreasures > h.size())
                    nHidden = h.size();
                else if (nHiddenTreasures > 0)
                    nHidden = nHiddenTreasures - h.size();
            }
        }
        else{
            if (nHiddenTreasures > h.size())
                nHidden = h.size();
            else if (nHiddenTreasures > 0)
                nHidden = nHiddenTreasures - h.size();
        }
        
        if (nVisible != 0 || nHidden != 0)
            bad = new BadConsequence(text,0,nVisible,nHidden);
        else if (!sVisible.isEmpty() || !sHidden.isEmpty())
            bad = new BadConsequence(text,0,sVisible,sHidden);
        
        return bad;
    }
    
    public String toString(){
        return "\n\t" + text + "\n\tlevel = " + Integer.toString(levels) 
                + "\n\tdeath = " + death + "\n\tvisible treasures = " 
                + Integer.toString(nVisibleTreasures) + "  |  " 
                + specificVisibleTreasures.toString() + "\n\thidden treasures = " 
                + Integer.toString(nHiddenTreasures) + "  |  " 
                + specificHiddenTreasures.toString() + "\n";
    }
}
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
public class SpecificBadConsequence extends BadConsequence{
    private ArrayList<TreasureKind> specificHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures;
    
    public SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        super(text, levels);
        this.specificVisibleTreasures = new ArrayList(tVisible);
        this.specificHiddenTreasures = new ArrayList(tHidden);
    }
    
    public int getNVisibleTreasures(){
        return 0;
    }
    
    public int getNHiddenTreasures(){
        return 0;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return new ArrayList(specificHiddenTreasures);
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return new ArrayList(specificVisibleTreasures);
    }
    
    public void substractVisibleTreasure(Treasure T){
        specificVisibleTreasures.remove(T.getType());
    }
    
    public void substractHiddenTreasure(Treasure T){
        specificHiddenTreasures.remove(T.getType());
    }
    
    public boolean isEmpty(){
        return (specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty());
    }
    
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h ){
        BadConsequence bad = null;
        ArrayList<TreasureKind> sVisible = new ArrayList<>();
        ArrayList<TreasureKind> sHidden = new ArrayList<>();
        
        if (!v.isEmpty()){
            if (!specificVisibleTreasures.isEmpty()){
                for (Treasure t : v)
                    if (specificVisibleTreasures.contains(t.getType()) && !sVisible.contains(t.getType()))
                        sVisible.add(t.getType());
            }
        }
        
        if (!h.isEmpty()){
            if (!specificHiddenTreasures.isEmpty()){
                for (Treasure t : h)
                    if (specificHiddenTreasures.contains(t.getType()) && !sHidden.contains(t.getType()))
                        sHidden.add(t.getType());
            }
        }
        
        if (!sVisible.isEmpty() || !sHidden.isEmpty())
            bad = new SpecificBadConsequence(getText(),0,sVisible,sHidden);
        
        return bad;
    }
    
    public String toString(){
        return super.toString()
            + "\n\tVisible treasures = " + specificVisibleTreasures.toString() 
            + "\n\tHidden treasures = " + specificHiddenTreasures.toString();
    }
}

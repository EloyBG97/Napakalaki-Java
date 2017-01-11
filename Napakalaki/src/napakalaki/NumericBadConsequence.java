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
public class NumericBadConsequence extends BadConsequence{
    static final int MAXTREASURES = 10;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    
    public NumericBadConsequence(String text, int levels, int nVisible, int nHidden){
        super(text, levels);
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    public boolean isEmpty() {
        return (nVisibleTreasures == 0 && nHiddenTreasures == 0);
    }
    
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h ){
        BadConsequence bad = null;
        int nVisible = 0, nHidden = 0;
        
        if (nVisibleTreasures > v.size())
            nVisible = v.size();
        else if (nVisibleTreasures > 0)
            nVisible = nVisibleTreasures - v.size();
        
        if (nHiddenTreasures > h.size())
            nHidden = h.size();
        else if (nHiddenTreasures > 0)
            nHidden = nHiddenTreasures - h.size();
        
        if (nVisible != 0 || nHidden != 0)
            bad = new NumericBadConsequence(super.getText(),0,nVisible,nHidden);
        
        return bad;
    }
    
    public String toString(){
        return super.toString()
            + "\n\tn visible treasures = " + Integer.toString(nVisibleTreasures) 
            + "\n\tn hidden treasures = " + Integer.toString(nHiddenTreasures) + "\n";
    }
}

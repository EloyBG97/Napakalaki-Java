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
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return new ArrayList();
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return new ArrayList();
    }
    
    public void substractVisibleTreasure(Treasure T){ }
    
    public void substractHiddenTreasure(Treasure T){ }
    
    public boolean isEmpty(){
        return (nVisibleTreasures == 0 && nHiddenTreasures == 0);
    }
    
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h ){
        BadConsequence bad = null;
        int nVisible = 0, nHidden = 0;
        int vSize = v.size();
        int hSize = h.size();
        
        if (nVisibleTreasures >= vSize)
            nVisible = vSize;
        else if (nVisibleTreasures < vSize)
            nVisible = nVisibleTreasures;
        
        if (nHiddenTreasures >= hSize)
            nHidden = hSize;
        else if (nHiddenTreasures < hSize)
            nHidden = nHiddenTreasures;
                
        if (nVisible != 0 || nHidden != 0)
            bad = new NumericBadConsequence(getText(),0,nVisible,nHidden);
        
        return bad;
    }
    
    public String toString(){
        return super.toString()
            + "\n\tVisible treasures = " + Integer.toString(nVisibleTreasures)
            + "\n\tHidden treasures = " + Integer.toString(nHiddenTreasures);
    }
}

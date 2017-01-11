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
 * 
 */
public class BadConsequence {
    private String text;
    private int levels;
    
    public BadConsequence(String text, int levels){
        this.text = text;
        this.levels = levels;
    }
        
    public boolean isEmpty() {
        return true;
    }
    
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    public String toString(){
        return text + "\n\tlevels = " + levels;
    }
}
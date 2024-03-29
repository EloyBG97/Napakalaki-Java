/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author eloy
 */
public class Treasure {
    private String name;
    private int bonus;
    private TreasureKind type;
    
    Treasure(String n, int bonus, TreasureKind t){
        this.name = n;
        this.bonus = bonus;
        this.type = t;
    }
    
    public String getName() {
        return name;
    }
    
    public int getBonus() {
        return bonus;
    }
    
    public TreasureKind getType() {
           return type;
    }
    
    public String toString(){
        return (name + "\t[" + type + ", +" + bonus + " ]");
    }
}

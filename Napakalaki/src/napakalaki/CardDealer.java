/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
/**
 *
 * @author eloy
 */
public class CardDealer {
    static final CardDealer instance=null;
    private ArrayList<Monster> unusedMonster;
    private ArrayList<Monster> usedMonster;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    
    private CardDealer(){
        unusedMonster=null;
        usedMonster=null;
        unusedTreasures=null;
        usedTreasures=null;    
    }
    private void initTreasureCardDeck(){}
    private void initMonsterCardDeck(){}
    private void shuffleTreasures(){
       unusedTreasures.
    }
    private void shuffleMonsters(){}
    
    public static CardDealer getInstance(){
        return instance;
    }
    public Treasure nextTreasure(){}
    public Monster nextMonster(){}
    public void giveTreasureBack(Treasure t){}
    public void giveMonsterBack(Monster m){}
    public void initCards(){}
    
}

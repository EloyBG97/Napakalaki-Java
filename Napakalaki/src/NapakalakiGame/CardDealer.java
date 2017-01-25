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
 */
public class CardDealer {
    static final CardDealer instance = new CardDealer();
    private ArrayList<Monster> unusedMonster;
    private ArrayList<Monster> usedMonster;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Cultist> unusedCultists;
    private ArrayList<Cultist> usedCultists;
    
    private CardDealer(){
        unusedMonster = new ArrayList<>();
        usedMonster = new ArrayList<>();
        unusedTreasures = new ArrayList<>();
        usedTreasures = new ArrayList<>();
        unusedCultists = new ArrayList<>();
        usedCultists = new ArrayList<>();
    }
    
    private void initTreasureCardDeck(){
        unusedTreasures.add(new Treasure("¡Sí mi amo!",4,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigación",3,TreasureKind.SHOES));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu",3,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("A prueba de babas",2,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia ácida",1,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco minero",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora ACME",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la ETSIIT",1,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alópodo",3,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistórica",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla",4,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato místico",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metálica",2,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Lanzallamas",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrocomicón",1,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicón",5,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a 2 manos",3,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrognomicón",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Mazo de los antiguos",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necroplayboycón",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Porra preternatural",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Shogulador",1,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentáculo de pega",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos",1,TreasureKind.SHOES));
    }
    
    private void initMonsterCardDeck(){
        /*
        *      Cartas de monstruos
        */
        BadConsequence bc = new SpecificBadConsequence("Pierdes tu armadura visible \ny otra oculta",
            0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        unusedMonster.add(new Monster("3 Byakhees de bonanza",8,bc,new Prize(2,1),0));
        
        
        bc = new SpecificBadConsequence("Embobados con el lindo primigenio \nte descartas de tu casco visible",
            0,new ArrayList(Arrays.asList(TreasureKind.HELMET)),new ArrayList());
        unusedMonster.add(new Monster("Tenochtitlan",2,bc,new Prize(1,1),0));
        
        
        bc = new SpecificBadConsequence("El primordial bostezo contagioso.\nPierdes el calzado visible",
            0,new ArrayList(Arrays.asList(TreasureKind.SHOES)),new ArrayList());
        unusedMonster.add(new Monster("El sopor de Dunwich",2,bc,new Prize(1,1),0));
        
        
        bc = new SpecificBadConsequence("Te atrapan para llevarte de fiesta \ny te dejan caer en mitad del vuelo.\nDescarta 1 mano visible y 1 mano oculta",
            0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        unusedMonster.add(new Monster("Demonios de Magaluf",2,bc,new Prize(4,1),0));
        
        
        bc = new NumericBadConsequence("Pierdes todos tus tesoros visibles",0,NumericBadConsequence.MAXTREASURES,0);
        unusedMonster.add(new Monster("El gorrón en el umbral",13,bc,new Prize(3,1),0));
        
        
        bc = new SpecificBadConsequence("Pierdes la armadura visible",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList());
        unusedMonster.add(new Monster("H.P. Munchcraft",6,bc,new Prize(2,1),0));
        
        
        bc = new SpecificBadConsequence("Sientes bichos bajo la ropa.\nDescarta la armadura visible",
            0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList());
        unusedMonster.add(new Monster("Necrófago",13,bc,new Prize(1,1),0));
        
        
        bc = new NumericBadConsequence("Pierdes 5 niveles\ny 3 tesoros visibles",5,3,0);
        unusedMonster.add(new Monster("El rey de rosado",11,bc,new Prize(3,2),0));
        
        
        bc = new NumericBadConsequence("Toses los pulmones\ny pierdes 2 niveles",2,0,0);
        unusedMonster.add(new Monster("Flecher",2,bc,new Prize(1,1),0));
        
        
        bc = new DeathBadConsequence("Estos monstruos resultan bastante "
                + "\nsuperficiales y te aburren mortalmente.\nEstas muerto",true);
        unusedMonster.add(new Monster("Los hondos",8,bc,new Prize(2,1),0));
        
        
        bc = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos",2,0,2);
        unusedMonster.add(new Monster("Semillas Cthulhu",4,bc,new Prize(2,1),0));
        
        
        bc = new SpecificBadConsequence("Te intentas escaquear.\nPierdes una mano visible",
            0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList());
        unusedMonster.add(new Monster("Dameargo",1,bc,new Prize(2,1),0));
        
        
        bc = new NumericBadConsequence("Da mucho asquito.\nPierdes 3 niveles",3,0,0);
        unusedMonster.add(new Monster("Pollipólipo volante",3,bc,new Prize(2,1),0));
        
        
        bc = new DeathBadConsequence("No le hace gracia que \npronuncien mal su nombre.\nEstas muerto",true);
        unusedMonster.add(new Monster("Yskhtihyssg-Goth",14,bc,new Prize(3,1),0));
        
        
        bc = new DeathBadConsequence("La familida te atrapa.\nEstas muerto",true);
        unusedMonster.add(new Monster("Familia feliz",1,bc,new Prize(3,1),0));
        
        
        bc = new SpecificBadConsequence("La quinta directiva primaria \nte obliga a perder 2 niveles \ny un tesoro 2 manos visible",
            2,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),new ArrayList());
        unusedMonster.add(new Monster("Roboggoth",8,bc,new Prize(2,1),0));
        
        
        bc = new SpecificBadConsequence("Te asusta en la noche.\nPierdes un casco visible",
            0,new ArrayList(Arrays.asList(TreasureKind.HELMET)),new ArrayList());
        unusedMonster.add(new Monster("El espía sordo",5,bc,new Prize(1,1),0));
        
        
        bc = new NumericBadConsequence("Menudo susto te llevas.\nPierdes 2 niveles y \n5 tesoros visibles",2,5,0);
        unusedMonster.add(new Monster("Tongue",19,bc,new Prize(2,1),0));
        
        
        bc = new SpecificBadConsequence("Te faltan manos para tanta cabeza.\nPierdes 3 niveles y tus tesoros \nvisibles de las manos",
            3, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS,TreasureKind.ONEHAND, TreasureKind.ONEHAND)), new ArrayList());
        unusedMonster.add(new Monster("Bicéfalo",21,bc,new Prize(2,1),0));
        
        /*
        *      Cartas de monstruos con sectarios
        */
        bc = new SpecificBadConsequence("Pierdes 1 mano visible",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList());
        unusedMonster.add(new Monster("El mal indecible impronunciable",10,bc,new Prize(3,1),-2));
        
        bc = new NumericBadConsequence("Pierdes tus tesoros visibles. Ja ja ja",0,NumericBadConsequence.MAXTREASURES,0);
        unusedMonster.add(new Monster("Testigos Oculares",6,bc,new Prize(2,1),+2));
        
        bc = new DeathBadConsequence("Hoy no es tu día de suerte. Mueres",true);
        unusedMonster.add(new Monster("El gran cthulhu",20,bc,new Prize(2,5),+4));
        
        bc = new NumericBadConsequence("Tu gobierno te recorta 2 niveles",2,0,0);
        unusedMonster.add(new Monster("Serpiente Político",8,bc,new Prize(2,1),-2));
        
        bc = new SpecificBadConsequence("Pierdes tu casco \ny tu armadura visible.\nPierdes tus manos ocultas",
            0,new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)),new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.ONEHAND,TreasureKind.BOTHHANDS)));
        unusedMonster.add(new Monster("Felpuggoth",2,bc,new Prize(1,1),+5));
        
        bc = new NumericBadConsequence("Pierdes 2 niveles",2,0,0);
        unusedMonster.add(new Monster("Shoggoth",16,bc,new Prize(4,2),-4));
        
        bc = new NumericBadConsequence("Pintalabios negro.\nPierdes 2 niveles",2,0,0);
        unusedMonster.add(new Monster("Lolitagooth",2,bc,new Prize(1,1),+3));
        
    }
    
    private void initCultistCardDeck(){
        unusedCultists.add(new Cultist("Sectario",1));
        unusedCultists.add(new Cultist("Sectario",2));
        unusedCultists.add(new Cultist("Sectario",1));
        unusedCultists.add(new Cultist("Sectario",2));
        unusedCultists.add(new Cultist("Sectario",1));
        unusedCultists.add(new Cultist("Sectario",1));
    }
    
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures, new Random());
    }
    
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonster, new Random());
    }
    
    private void shuffleCultists(){
        Collections.shuffle(unusedCultists, new Random());
    }
    
    public static CardDealer getInstance(){
        return instance;
    }
    
    public Treasure nextTreasure(){
        Treasure treasure;
        
        if (unusedTreasures.isEmpty()){
            for (int i = 0 ; i < usedTreasures.size() ; i++)
                unusedTreasures.add(usedTreasures.get(i));
            
            usedTreasures.clear();
            shuffleTreasures();
        }
        
        treasure = unusedTreasures.get(0);
        usedTreasures.add(treasure);
        unusedTreasures.remove(treasure);
        
        return treasure;
    }
    
    public Monster nextMonster(){
        Monster monster;
        
        if (unusedMonster.isEmpty()){
            for (Monster m : usedMonster)
                unusedMonster.add(m);
            
            usedMonster.clear();
            shuffleMonsters();
        }
        
        monster = unusedMonster.get(0);
        usedMonster.add(monster);
        unusedMonster.remove(monster);
        
        return monster;
    }
    
    public Cultist nextCultist(){
        Cultist cultist;
        
        if (unusedCultists.isEmpty()){
            for (Cultist c : usedCultists)
                unusedCultists.add(c);
            
            usedCultists.clear();
            shuffleCultists();
        }
        
        cultist = unusedCultists.get(0);
        usedCultists.add(cultist);
        unusedCultists.remove(cultist);
        
        return cultist;
    }
    
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        usedMonster.add(m);
    }
    
    public void initCards(){
        instance.initMonsterCardDeck();
        instance.shuffleMonsters();
        instance.initTreasureCardDeck();
        instance.shuffleTreasures();
        instance.initCultistCardDeck();
        instance.shuffleCultists();
    }
}

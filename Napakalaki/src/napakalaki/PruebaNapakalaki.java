/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Adri
 * 
 */
public class PruebaNapakalaki {

    static ArrayList<Monster> monstruos = new ArrayList();
    
    public static void addMonsters(){
        BadConsequence bc = new BadConsequence("Pierdes tu armadura visible "
                + "y otra oculta",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        monstruos.add(new Monster("3 Byakhees de bonanza",8,bc,new Prize(2,1)));
        
        
        bc = new BadConsequence("Embobados con el lindo primigenio te descartas "
                + "de tu casco visible",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                new ArrayList());
        monstruos.add(new Monster("Tenochtitlan",2,bc,new Prize(1,1)));
        
        
        bc = new BadConsequence("El primordial bostezo contagioso. "
                + "Pierdes el calzado visible",0,
                new ArrayList(Arrays.asList(TreasureKind.SHOES)),
                new ArrayList());
        monstruos.add(new Monster("El sopor de Dunwich",2,bc,new Prize(1,1)));
        
        
        bc = new BadConsequence("Te atrapan para llevarte "
                + "de fiesta y te dejan caer en mitad del vuelo. Descarta "
                + "1 mano visible y 1 mano oculta",0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        monstruos.add(new Monster("Demonios de Magaluf",2,bc,new Prize(4,1)));
        
        
        bc = new BadConsequence("Pierdes todos tus tesoros visibles",
                0,BadConsequence.MAXTREASURES,0);
        monstruos.add(new Monster("El gorrón en el umbral",13,bc,new Prize(3,1)));
        
        
        bc = new BadConsequence("Pierdes la armadura visible",0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList());
        monstruos.add(new Monster("H.P. Munchcraft",6,bc,new Prize(2,1)));
        
        
        bc = new BadConsequence("Sientes bichos bajo la ropa. "
                + "Descarta la armadura visible",0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList());
        monstruos.add(new Monster("Necrófago",13,bc,new Prize(1,1)));
        
        
        bc = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles",5,3,0);
        monstruos.add(new Monster("El rey de rosado",11,bc,new Prize(3,2)));
        
        
        bc = new BadConsequence("Toses los pulmones y pierdes 2 niveles",2,0,0);
        monstruos.add(new Monster("Flecher",2,bc,new Prize(1,1)));
        
        
        bc = new BadConsequence("Estos monstruos resultan bastante "
                + "superficiales y te aburren mortalmente. Estas muerto",true);
        monstruos.add(new Monster("Los hondos",8,bc,new Prize(2,1)));
        
        
        bc = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos",2,0,2);
        monstruos.add(new Monster("Semillas Cthulhu",4,bc,new Prize(2,1)));
        
        
        bc = new BadConsequence("Te intentas escaquear. Pierdes una mano "
                + "visible",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList());
        monstruos.add(new Monster("Dameargo",1,bc,new Prize(2,1)));
        
        
        bc = new BadConsequence("Da mucho asquito. Pierdes 3 niveles",3,0,0);
        monstruos.add(new Monster("Pollipólipo volante",3,bc,new Prize(2,1)));
        
        
        bc = new BadConsequence("No le hace gracia que pronuncien mal "
                + "su nombre. Estas muerto",true);
        monstruos.add(new Monster("Yskhtihyssg-Goth",14,bc,new Prize(3,1)));
        
        
        bc = new BadConsequence("La familida te atrapa. Estas muerto",true);
        monstruos.add(new Monster("Familia feliz",1,bc,new Prize(3,1)));
        
        
        bc = new BadConsequence("La quinta directiva primaria te obliga a "
                + "perder 2 niveles y un tesoro 2 manos visible",
                2,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                new ArrayList());
        monstruos.add(new Monster("Roboggoth",8,bc,new Prize(2,1)));
        
        
        bc = new BadConsequence("Te asusta en la noche. Pierdes un casco "
                + "visible",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                new ArrayList());
        monstruos.add(new Monster("El espía sordo",5,bc,new Prize(1,1)));
        
        
        bc = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles "
                + "y 5 tesoros visibles",2,5,0);
        monstruos.add(new Monster("Tongue",19,bc,new Prize(2,1)));
        
        
        bc = new BadConsequence("Te faltan manos para tanta cabeza. "
                + "Pierdes 3 niveles y tus tesoros visibles de las manos",
                3, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS, 
                TreasureKind.ONEHAND, TreasureKind.ONEHAND)), new ArrayList());
        monstruos.add(new Monster("Bicéfalo",21,bc,new Prize(2,1)));
    }
    
    
    public static ArrayList nivelSup10(){
        ArrayList<Monster> aux = new ArrayList();
        
        for (int i = 0 ; i < monstruos.size() ; i++)
            if (monstruos.get(i).getCombatLevel() > 10)
                   aux.add(monstruos.get(i));
        
        return aux;
    }
    
    
    public static ArrayList pierdeSoloNivel(){
        ArrayList<Monster> aux = new ArrayList();
        boolean c;
        
        for (int i = 0 ; i < monstruos.size() ; i++){
            if ((monstruos.get(i).getBadConsequence().getLevels() != 0) &&
            (monstruos.get(i).getBadConsequence().getNHiddenTreasures() == 0) &&
            (monstruos.get(i).getBadConsequence().getSpecificHiddenTreasures().isEmpty()) &&
            (monstruos.get(i).getBadConsequence().getNVisibleTreasures() == 0) &&
            (monstruos.get(i).getBadConsequence().getSpecificVisibleTreasures().isEmpty()))
                aux.add(monstruos.get(i));
        }
        
        return aux;
    }
    
    
    public static ArrayList ganaNivel(){
        ArrayList<Monster> aux = new ArrayList();
        
        for (int i = 0 ; i < monstruos.size() ; i++)
            if (monstruos.get(i).getPrize().getLevels() > 1)
                aux.add(monstruos.get(i));
        
        return aux;
    }
    
    
    public static ArrayList pierdeTConcreto(TreasureKind t){
        ArrayList<Monster> aux = new ArrayList();
        
        for (int i = 0 ; i < monstruos.size() ; i++)
            if (monstruos.get(i).getBadConsequence().getSpecificVisibleTreasures().contains(t) || monstruos.get(i).getBadConsequence().getSpecificHiddenTreasures().contains(t))
                aux.add(monstruos.get(i));
        
        return aux;
    }
}
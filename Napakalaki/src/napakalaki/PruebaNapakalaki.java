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
 */
public class PruebaNapakalaki {

    static ArrayList<Monster> monstruos = new ArrayList();
    
    public static void addMonsters(){
        BadConsecuence bc1 = new BadConsecuence("Pierdes tu armadura visible "
                + "y otra oculta",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize p1 = new Prize(2,1);
        monstruos.add(new Monster("3 Byakhees de bonanza",8,bc1,p1));
        
        
        BadConsecuence bc2 = new BadConsecuence("Embobados con el lindo "
                + "primigenio te descartas de tu casco visible",0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                new ArrayList());
        Prize p2 = new Prize(1,1);
        monstruos.add(new Monster("Tenochtitlan",2,bc2,p2));
        
        
        BadConsecuence bc3 = new BadConsecuence("El primordial bostezo "
                + "contagioso. Pierdes el calzado visible",0,
                new ArrayList(Arrays.asList(TreasureKind.SHOES)),
                new ArrayList());
        Prize p3 = new Prize(1,1);
        monstruos.add(new Monster("El sopor de Dunwich",2,bc3,p3));
        
        
        BadConsecuence bc4 = new BadConsecuence("Te atrapan para llevarte "
                + "de fiesta y te dejan caer en mitad del vuelo. Descarta "
                + "1 mano visible y 1 mano oculta",0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        Prize p4 = new Prize(4,1);
        monstruos.add(new Monster("Demonios de Magaluf",2,bc4,p4));
        
        
        BadConsecuence bc5 = new BadConsecuence("Pierdes todos tus "
                + "tesoros visibles",0,Integer.MAX_VALUE,0);
        Prize p5 = new Prize(3,1);
        monstruos.add(new Monster("El gorrón en el umbral",13,bc5,p5));
        
        
        BadConsecuence bc6 = new BadConsecuence("Pierdes la armadura "
                + "visible",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList());
        Prize p6 = new Prize(2,1);
        monstruos.add(new Monster("H.P. Munchcraft",6,bc6,p6));
        
        
        BadConsecuence bc7 = new BadConsecuence("Sientes bichos bajo la"
                + "ropa. Descarta la armadura visible",0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList());
        Prize p7 = new Prize(1,1);
        monstruos.add(new Monster("Necrófago",13,bc7,p7));
        
        
        BadConsecuence bc8 = new BadConsecuence("Pierdes 5 niveles y 3"
                + "tesoros visibles",5,3,0);
        Prize p8 = new Prize(3,2);
        monstruos.add(new Monster("El rey de rosado",11,bc8,p8));
        
        
        BadConsecuence bc9 = new BadConsecuence("Toses los pulmones y pierdes"
                + "2 niveles",2,0,0);
        Prize p9 = new Prize(1,1);
        monstruos.add(new Monster("Flecher",2,bc9,p9));
        
        
        BadConsecuence bc10 = new BadConsecuence("Estos monstruos resultan"
                + "bastante superficiales y te aburren mortalmente. "
                + "Estas muerto",true);
        Prize p10 = new Prize(2,1);
        monstruos.add(new Monster("Los hondos",8,bc10,p10));
        
        
        BadConsecuence bc11 = new BadConsecuence("Pierdes 2 niveles y 2 tesoros"
                + "ocultos",2,0,2);
        Prize p11 = new Prize(2,1);
        monstruos.add(new Monster("Semillas Cthulhu",4,bc11,p11));
        
        
        BadConsecuence bc12 = new BadConsecuence("Te intentas escaquear. "
                + "Pierdes una mano visible",0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList());
        Prize p12 = new Prize(2,1);
        monstruos.add(new Monster("Dameargo",1,bc12,p12));
        
        
        BadConsecuence bc13 = new BadConsecuence("Da mucho asquito. Pierdes"
                + "3 niveles",3,0,0);
        Prize p13 = new Prize(2,1);
        monstruos.add(new Monster("Pollipólipo volante",3,bc13,p13));
        
        
        BadConsecuence bc14 = new BadConsecuence("No le hace gracia que "
                + "pronuncien mal su nombre. Estas muerto",true);
        Prize p14 = new Prize(3,1);
        monstruos.add(new Monster("Yskhtihyssg-Goth",14,bc14,p14));
        
        
        BadConsecuence bc15 = new BadConsecuence("La familida te atrapa."
                + "Estas muerto",true);
        Prize p15 = new Prize(3,1);
        monstruos.add(new Monster("Familia feliz",1,bc15,p15));
        
        
        BadConsecuence bc16 = new BadConsecuence("La quinta directiva primaria "
                + "te obliga a perder 2 niveles y un tesoro 2 manos visible",
                2,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                new ArrayList());
        Prize p16 = new Prize(2,1);
        monstruos.add(new Monster("Roboggoth",8,bc16,p16));
        
        
        BadConsecuence bc17 = new BadConsecuence("Te asusta en la noche. "
                + "Pierdes un casco visible",0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                new ArrayList());
        Prize p17 = new Prize(1,1);
        monstruos.add(new Monster("El espía sordo",5,bc17,p17));
        
        
        BadConsecuence bc18 = new BadConsecuence("Menudo susto te llevas. "
                + "Pierdes 2 niveles y 5 tesoros visibles",2,5,0);
        Prize p18 = new Prize(2,1);
        monstruos.add(new Monster("Tongue",19,bc18,p18));
        
        
        BadConsecuence bc19 = new BadConsecuence("Te faltan manos para tanta"
                + "cabeza. Pierdes 3 niveles y tus tesoros visibles de las"
                + "manos",3, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS, 
                        TreasureKind.ONEHAND, TreasureKind.ONEHAND)), new ArrayList());
        Prize p19 = new Prize(2,1);
        monstruos.add(new Monster("Bicéfalo",21,bc19,p19));
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
            if ((monstruos.get(i).getBc().getLevels() != 0) &&
            (monstruos.get(i).getBc().getNHiddenTreasures() == 0) &&
            (monstruos.get(i).getBc().getSpecificHiddenTreasures().isEmpty()) &&
            (monstruos.get(i).getBc().getNVisibleTreasures() == 0) &&
            (monstruos.get(i).getBc().getSpecificVisibleTreasures().isEmpty()))
                aux.add(monstruos.get(i));
        }
        
        return aux;
    }
    
    
    public static ArrayList ganaNivel(){
        ArrayList<Monster> aux = new ArrayList();
        
        for (int i = 0 ; i < monstruos.size() ; i++)
            if (monstruos.get(i).getPrize().getLevel() > 1)
                aux.add(monstruos.get(i));
        
        return aux;
    }
    
    
    public static ArrayList pierdeTConcreto(TreasureKind t){
        ArrayList<Monster> aux = new ArrayList();
        
        for (int i = 0 ; i < monstruos.size() ; i++)
            if (monstruos.get(i).getBc().getSpecificVisibleTreasures().contains(t) || monstruos.get(i).getBc().getSpecificHiddenTreasures().contains(t))
                aux.add(monstruos.get(i));
        
        return aux;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        addMonsters();
        
        System.out.print(pierdeSoloNivel());
    }
}

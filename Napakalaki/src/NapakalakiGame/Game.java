/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import GUI.*;
import java.util.ArrayList;

/**
 *
 * @author Adri
 */
public class Game {
    public static void main (String[] args){
        Napakalaki game = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        ArrayList<String> names;
        PlayerNameCapture namesCapture = new PlayerNameCapture(napakalakiView, true);
        
        //Pedir nombres a los jugadores
        names = namesCapture.getNames();
        
        //Crear instancia del dado
        Dice.createInstance(napakalakiView);
        
        //Iniciar juego
        game.initGame(names);
        
        //Enlazar el modelo a la vista
        napakalakiView.setNapakalaki(game);
        
        //Mostrar ventana principal
        napakalakiView.setVisible(true);
    }
}

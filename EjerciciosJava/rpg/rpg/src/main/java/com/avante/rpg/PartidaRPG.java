/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.rpg;

import com.avante.rpg.logica.*;

/**
 * Punto de entrada de nuestro programa que utilizará la jerarquía de
 *   clases de nuestro modelado de personajes de un juego RPG.
 * 
 * @author Juan Manuel
 */
public class PartidaRPG {

    public static void main(String[] args) {
        System.out.println("--- DEBUG: INICIO\n\n");
        
        Personaje p1 = new Arquero("Ajax");
        Personaje p2 = new Mago("Harry Potter");
        
        for (int i=0; i<5; i++) {
            p1.ataca(p2);
        }
        
        for (int i=0; i<35; i++) {
            p2.ataca(p1);
        }
        
        
        System.out.println("\n\n--- DEBUG: FIN");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.zoologico.principal;

import com.zoologico.animales.Leon;
import com.zoologico.animales.Pajaro;


/**
 *
 * @author Usuario
 */
public class Zoologico {

    public static void main(String[] args) {
        
        System.out.println("bienvenido al Zoo.");
        
        Leon simba = new Leon("Simba", 5);
        
        Pajaro piolin = new Pajaro("Piolin", 2);
        
        System.out.println("--- Información del León ---");
        System.out.println("Nombre: " + simba.getNombre()); // Heredado
        System.out.println("Edad: " + simba.getEdad());     // Heredado
        simba.comer();  // Sobrescrito
        simba.rugir();  // Propio

        System.out.println("\n--- Información del Pájaro ---");
        System.out.println("Nombre: " + piolin.getNombre()); // Heredado
        System.out.println("Edad: " + piolin.getEdad());     // Heredado
        piolin.comer();   // Sobrescrito
        piolin.volar();   // Propio
    }
}

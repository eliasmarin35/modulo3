/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.juego;

import java.util.Scanner;

/**
 *
 * @author Curso Desarrollo
 */
public class Juego {

    public static void main(String[] args) {
        
       int marcadorP1;
       int marcadorP2;
       int rondas;
       
       
        
        
        
        System.out.println("Juguemos a un juego : ");
        Scanner teclado = new Scanner(System.in);
        System.out.println(" Jugador 1 introduce valor (piedra - pepel - tijera )");
        String valorP1 = teclado.nextLine();
        System.out.println(valorP1);
        System.out.println(" Jugador 2 introduce valor (piedra - pepel - tijera )");
        String valorP2 = teclado.nextLine();
        System.out.println(valorP2);
        
        for (rondas = 1; rondas < 5; rondas++) {
            if (valorP1 == "tijera" && valorP2 = "papel") {
                
            }
        }
        
        
        
        
        
        teclado.close();
        
        

    }
}

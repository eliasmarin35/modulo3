/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.ahorcado;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Curso Desarrollo
 */
public class Ahorcado {

    
    
    public static void main(String[] args) {
        System.out.println("Juegemos a un juego : EL AHORCADO ! ");
        Juego miJuego = new Juego("JESUSITO");
        Scanner teclado = new Scanner(System.in);
        do{
           System.out.println("Introduce una letra : ");
           char letra = teclado.next().charAt(0);
           letra = Character.toUpperCase(letra);
           miJuego.CompruebaAcierto(letra);
            System.out.println("Has introducido la letra " + letra);
        }while(miJuego.FinJuego(miJuego.intentos) == false);
       
        
        teclado.close();
    }
    
}

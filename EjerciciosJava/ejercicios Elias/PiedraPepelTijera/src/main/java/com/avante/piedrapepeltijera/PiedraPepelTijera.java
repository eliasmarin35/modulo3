/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.piedrapepeltijera;

import java.util.Scanner;
/**
 *
 * @author Elias
 */
public class PiedraPepelTijera {
    
    // Variables para controlar el flujo del juego
    static int marcadorJ1 = 0;
    static int marcadorJ2 = 0;
    static int rondaActual = 1;
    static String valorP1;
    static String valorP2;
    static boolean finJuego = false;
    
    //Inicio Scanner en variable teclado como siempre hago
    static Scanner teclado = new Scanner(System.in);
    
    
    
    public static void main(String[] args) {
        System.out.println("Juguemos a un juego con tijera y demas ! ");
        
        // esto seria como el game controller
        while (finJuego == false){
            Partida();
            Compara();
        }
        System.out.println("Fin de partida");
        if (marcadorJ1 == 3) {
            System.out.println("GANADOR EL JUGADOR 1 ");
        }else if(marcadorJ2 == 3){
            System.out.println("GANADOR EL JUGADOR 2 ");
        }else{
            if (marcadorJ1 > marcadorJ2) {
                System.out.println("GANADOR EL JUGADOR 1 ");
            }else{
                System.out.println("GANADOR EL JUGADOR 2 ");
            }
        }
  
       
       //  cierra Scanner
       teclado.close();
    }
    
    // este metodo pide datos y valida y no sale de bucle hasta que jugador 1 y 2 dan un valor por teclado valido.
    public static void Partida(){
        
        //Este metodo pide valores a los jugadores los guarda y valida
        do{
            System.out.println("Jugador 1 introduce valor (piedra - papel - tijera)");
            valorP1 = teclado.nextLine().toLowerCase().trim();
            System.out.println(valorP1);
        }while(!valorP1.equals("piedra") && !valorP1.equals("papel") && !valorP1.equals("tijera"));
        System.out.println("El juegador uno ha elegido : " + valorP1);
        do{
            System.out.println("Jugador 2 introduce valor (piedra - papel - tijera)");
            valorP2 = teclado.nextLine().toLowerCase().trim();
            System.out.println(valorP2);
        }while(!valorP2.equals("piedra") && !valorP2.equals("papel") && !valorP2.equals("tijera"));
        System.out.println("El juegador uno ha elegido : " + valorP2);
        rondaActual = rondaActual + 1;
    }
    // este metodod compara y suma puntos e infomra de marcadores y si se cumple las condicones de fin de juego se cambia para salir del 
    //del controlador del juego
    public static void Compara(){
        switch (valorP1) {
            case "tijera" -> {
                if (valorP1.equals("tijera")&&(valorP2.equals("tijera"))) {
                    System.out.println("Empate !");
                }
                if (valorP1.equals("tijera")&&(valorP2.equals("piedra"))) {
                    System.out.println("Punto para el jugador 2");
                    marcadorJ2 = marcadorJ2 + 1;
                }
                if (valorP1.equals("tijera")&&(valorP2.equals("papel"))) {
                    System.out.println("Punto para el jugador 1");
                    marcadorJ1 = marcadorJ1 + 1;
                }
            }
            case "papel" -> {
                if (valorP1.equals("papel")&&(valorP2.equals("tijera"))) {
                    System.out.println("Punto para el jugador 2");
                    marcadorJ2 = marcadorJ2 + 1;
                }
                if (valorP1.equals("papel")&&(valorP2.equals("piedra"))) {
                    System.out.println("Punto para el jugador 1");
                    marcadorJ1 = marcadorJ1 + 1;
                }
                if (valorP1.equals("papel")&&(valorP2.equals("papel"))) {
                    System.out.println("Empate !");
                }
            }
            case "piedra" -> {
                if (valorP1.equals("piedra")&&(valorP2.equals("tijera"))) {
                    System.out.println("Punto para el jugador 1");
                    marcadorJ1 = marcadorJ1 + 1;
                }
                if (valorP1.equals("piedra")&&(valorP2.equals("piedra"))) {
                    System.out.println("Empate !");
                }
                if (valorP1.equals("piedra")&&(valorP2.equals("papel"))) {
                    System.out.println("Punto para el jugador 2");
                    marcadorJ2 = marcadorJ2 + 1;
                }
            }
                
            default -> throw new AssertionError();
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("EL CONTADOR DE  J1 ES : " + marcadorJ1 + " - || -  EL CONTADOR DE J2 ES " + marcadorJ2);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(" // ESTAMOS EN LA RONDA  " + rondaActual + " DE 5 // ");
        System.out.println("-----------------------------------------------------------------------------------------");
        
        if (rondaActual >= 5 || marcadorJ1 == 3 || marcadorJ2 == 3 ) {
            finJuego = true;
        }
    }
}

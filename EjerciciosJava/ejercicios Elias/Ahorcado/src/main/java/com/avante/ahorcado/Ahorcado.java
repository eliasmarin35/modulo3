package com.avante.ahorcado;

import java.util.Scanner;

public class Ahorcado {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Juego miJuego = new Juego();

        System.out.println("¡Bienvenido al Juego del Ahorcado!");
        System.out.println("=====================================");

        // El bucle principal del juego
        while (!miJuego.haGanado() && !miJuego.haPerdido()) {
            
            // 1. Muestra el estado actual del juego
            System.out.println(miJuego.getEstadoVisual());
            
            // 2. Pide una letra al usuario
            System.out.print("Introduce una letra: ");
            String entrada = teclado.next();

            // 3. Valida la entrada del usuario
            if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
                System.out.println("Error: Por favor, introduce una unica letra.");
                continue; // Vuelve al inicio del bucle
            }

            // 4. Procesa la letra y muestra el resultado
            char letra = entrada.charAt(0);
            String resultado = miJuego.procesarLetra(letra);
            System.out.println(resultado);
        }

        // --- Fin del Juego ---
        System.out.println("\n=====================================");
        System.out.println("Fin de juego !");

        if (miJuego.haGanado()) {
            System.out.println("¡Has adivinado la palabra! 🎉");
            System.out.println("La palabra era: " + miJuego.getPalabraSecreta());
        } else {
            System.out.println(" Se acabo a la horca !");
            System.out.println("La palabra secreta era: " + miJuego.getPalabraSecreta());
            // Muestra el estado final del ahorcado
            System.out.println(miJuego.getEstadoVisual());
        }
        
        teclado.close();
    }
}
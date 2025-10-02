/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.avante.ecoeco;

import java.util.Scanner;

/**
 *
 * @author jprof
 */
public class EcoEco {

    public static void main(String[] args) throws Exception {
        // =======> VARIABLES
        String texto;
        Scanner scan;
        boolean ok = true;

        // =======> PROGRAMA
        // Abrimos el scan
        scan = new Scanner(System.in);

        while (ok) {
            // Pedimos la entrada
            System.out.printf("\n=======\nEscribe algo:\n> ");
            texto = scan.nextLine();
            System.out.println("");

            // limpiar y preparar el texto
            texto = texto.trim();
            texto = texto.toUpperCase();
            
            // condición de salida
            if ( texto.equals("") ) {
                ok = false;
                // Imprimimos la entrada
                System.out.println("ADIOS!!!");
            }
            else {
                // Imprimimos la entrada
                System.out.println(texto);
            }
        }

        // Ceramos el scanner
        scan.close();
    }
}

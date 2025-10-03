/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.paresonones.logica;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jprof
 */
public class ParesNones {

    private static final String NOMBRE_J1 = "JUGADOR";
    private static final String NOMBRE_J2 = "COMPUTADORA";

    private Scanner scan;

    private ParesNonesEnum jugadaJ1;
    private ParesNonesEnum jugadaJ2;

    private int numeroJ1;
    private int numeroJ2;
    
    private String ganador;

    public ParesNones() {
        this.scan = new Scanner(System.in);

        this.pideNumeroJ2();
    }

    public void close() {
        this.scan.close();
    }

    private void pideNumeroJ1() {
        // VARS
        String texto;
        int resultado = -1;
        boolean ok = false;

        // BUCLE QUE SE REPITA HASTA QUE TODO SEA OK
        while (!ok) {
            // Pide texto
            System.out.printf(
                    "\n[%s] introduze un numero de 0 a 5.\n\t(0-5) > ",
                    ParesNones.NOMBRE_J1
            );

            texto = this.scan.nextLine().trim();

            System.out.println("");

            // Convierte a entero
            try {
                resultado = Integer.parseInt(texto);
                ok = true;
            } catch (NumberFormatException e) {
            }

            // Comprueba que el numero esta entre 0 y 5
            if (ok) {
                ok = (resultado >= 0 && resultado <= 5);
            }

            // Si el numero es erroneo, muestra un error
            if (!ok) {
                System.out.println("El número introducido no es correcto.");
            }
        }

        // Guarda el numero
        this.numeroJ1 = resultado;
    }

    private void pideNumeroJ2() {
        Random rng = new Random();
        this.numeroJ2 = rng.nextInt(6);
    }

    private void pideParesNones() {
        // VARIABLES
        String texto;
        ParesNonesEnum paresNones = ParesNonesEnum.ERROR;

        while (paresNones == ParesNonesEnum.ERROR) {
            // Pide el dato
            System.out.printf(
                    "[%s] indica si quieres jugar con pares o nones.\n\t(pares|nones) > ",
                    ParesNones.NOMBRE_J1
            );

            texto = this.scan.nextLine();

            System.out.println("");
            
            // Convierte el dato a enumerado
            paresNones = ParesNonesEnum.paresNonesTexto(texto);
            
            // Si hay error pon mensaje de error
            if ( paresNones == ParesNonesEnum.ERROR ) {
                System.out.println("No has introducido \"pares\" o \"nones\".\n");
            }
        }

        this.jugadaJ1 = paresNones;
        this.jugadaJ2 = paresNones.getContrario();
    }
    
    private void calculaGanador () {
        if ( (this.numeroJ1 + this.numeroJ2) % 2 == 0 ) {
            // SI LA SUMA ES PAR
            
            if (this.jugadaJ1 == ParesNonesEnum.PARES) {
                // SI EL J1 ELIGIO PARES
                
                this.ganador = ParesNones.NOMBRE_J1;
            }
            else {
                // SI EL J1 ELIGIO NONES
                this.ganador = ParesNones.NOMBRE_J2;
            }
        }
        else {
            // SI LA SUMA ES IMPAR
            
            if (this.jugadaJ1 == ParesNonesEnum.NONES) {
                // SI EL J1 ELIGIO NONES
                
                this.ganador = ParesNones.NOMBRE_J1;
            }
            else {
                // SI EL J1 ELIGIO PARES
                this.ganador = ParesNones.NOMBRE_J2;
            }
        }
    }

    public void jugar() {
        // 1.- JUGADOR introduce pares o nones
        this.pideParesNones();

        // 2.- JUGADOR introduzca un numero
        this.pideNumeroJ1();
        
        // 3.- Calculamos ganador
        this.calculaGanador();

        // 4.- Imprimo los valores por pantalla:
        System.out.println("\n================ RESULTADOS ============");
        System.out.printf(
                "\t[%s] ha elegido %s.\n",
                ParesNones.NOMBRE_J1,
                this.jugadaJ1
        );

        System.out.printf(
                "\t[%s] entonces se queda con %s.\n",
                ParesNones.NOMBRE_J2,
                this.jugadaJ2
        );

        System.out.printf(
                "\t[%s] ha sacado %d.\n",
                ParesNones.NOMBRE_J1,
                this.numeroJ1
        );

        System.out.printf(
                "\t[%s] ha sacado %d.\n",
                ParesNones.NOMBRE_J2,
                this.numeroJ2
        );
        
        System.out.printf(
                "\t----> [%s] HA GANADO <----- \n\n",
                this.ganador
        );
    }
}

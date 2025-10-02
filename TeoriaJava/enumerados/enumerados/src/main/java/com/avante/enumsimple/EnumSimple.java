/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.avante.enumsimple;

import java.util.Scanner;

import com.avante.enumsimple.logica.DiaSemana;

/**
 *
 * @author jprof
 */
public class EnumSimple {

    public static void main1(String[] args) throws Exception {
        // Variables
        String entrada;
        Scanner scan = new Scanner(System.in);
        DiaSemana dia;

        // Recoger por teclado el dia de la semana
        System.out.printf("\nPor favor introduzca el dia de la semana.\n> ");
        entrada = scan.nextLine();
        System.out.println("");

        // Limpiar la entrada
        entrada = entrada.trim().toLowerCase();

        // Dependiendo de la entrada, asignamos el valor
        switch (entrada) {
            case "lunes":
                dia = DiaSemana.LUNES;
                break;

            case "martes":
                dia = DiaSemana.MARTES;
                break;

            case "miercoles":
                dia = DiaSemana.MIERCOLES;
                break;

            case "jueves":
                dia = DiaSemana.JUEVES;
                break;

            case "viernes":
                dia = DiaSemana.VIERNES;
                break;

            case "sabado":
                dia = DiaSemana.SABADO;
                break;

            case "domingo":
                dia = DiaSemana.DOMINGO;
                break;

            default:
                throw new Exception("El dato introducido no es válido.");
        }

        // Hacemos cositas
        System.out.printf("El dia elegido es %s.\n", dia);
        System.out.printf("El dia elegido tiene el número: %s.\n", dia.ordinal());

        // cerrar el escaner
        scan.close();
    }

    public static void main2(String[] args) throws Exception {
        DiaSemana[] dias = DiaSemana.values();

        for (int i = 0; i < dias.length; i++) {
            System.out.printf("El día %d es %s.\n", i + 1, dias[i]);
        }
    }

    public static void main3(String[] args) throws Exception {
        // Variables
        String entrada;
        Scanner scan = new Scanner(System.in);
        DiaSemana dia;

        // Recoger por teclado el dia de la semana
        System.out.printf("\nPor favor introduzca el dia de la semana.\n> ");
        entrada = scan.nextLine();
        System.out.println("");

        // Limpiar la entrada
        entrada = entrada.trim().toLowerCase();

        // Dependiendo de la entrada, asignamos el valor
        switch (entrada) {
            case "lunes":
                dia = DiaSemana.LUNES;
                break;

            case "martes":
                dia = DiaSemana.MARTES;
                break;

            case "miercoles":
                dia = DiaSemana.MIERCOLES;
                break;

            case "jueves":
                dia = DiaSemana.JUEVES;
                break;

            case "viernes":
                dia = DiaSemana.VIERNES;
                break;

            case "sabado":
                dia = DiaSemana.SABADO;
                break;

            case "domingo":
                dia = DiaSemana.DOMINGO;
                break;

            default:
                throw new Exception("El dato introducido no es válido.");
        }

        // Hacemos cositas
        if (dia == DiaSemana.SABADO
                || dia == DiaSemana.DOMINGO) {
            System.out.println("Feliz Fin de Semana!!!");
        } else {
            System.out.println("Todavia no es Fin de Semana :(");
        }

        // cerrar el escaner
        scan.close();
    }

    public static void main4(String[] args) throws Exception {
        // Variables
        String entrada;
        Scanner scan = new Scanner(System.in);
        DiaSemana dia;

        // Recoger por teclado el dia de la semana
        System.out.printf("\nPor favor introduzca el dia de la semana.\n> ");
        entrada = scan.nextLine();
        System.out.println("");

        // Limpiar la entrada
        entrada = entrada.trim().toLowerCase();

        // Dependiendo de la entrada, asignamos el valor
        switch (entrada) {
            case "lunes":
                dia = DiaSemana.LUNES;
                break;

            case "martes":
                dia = DiaSemana.MARTES;
                break;

            case "miercoles":
                dia = DiaSemana.MIERCOLES;
                break;

            case "jueves":
                dia = DiaSemana.JUEVES;
                break;

            case "viernes":
                dia = DiaSemana.VIERNES;
                break;

            case "sabado":
                dia = DiaSemana.SABADO;
                break;

            case "domingo":
                dia = DiaSemana.DOMINGO;
                break;

            default:
                throw new Exception("El dato introducido no es válido.");
        }

        // Hacemos cositas
        switch (dia) {
            case DiaSemana.SABADO:
            case DiaSemana.DOMINGO:
                System.out.println("Feliz Fin de Semana!!!");
                break;
            default:
                System.out.println("Todavia no es Fin de Semana :(");
                break;
        }

        // cerrar el escaner
        scan.close();
    }

    public static void main(String[] args) throws Exception {
        //String dia = "HOLA";
        DiaSemana dia = DiaSemana.LUNES;

        System.out.println(dia);
    }
}

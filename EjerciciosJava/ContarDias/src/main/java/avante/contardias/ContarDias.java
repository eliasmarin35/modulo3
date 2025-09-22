/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package avante.contardias;

/**
 *
 * @author Elias
 * 
 */
/* cuando le introduces un mes te dice cuFebreantos dias tiene ese mes  */

import java.util.Scanner;

public class ContarDias {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre de un mes : ");
         // Convertimos a minúsculas para no distinguir entre mayúsculas y minúsculas
        String nombreMes = scanner.nextLine().toLowerCase();

        int dias;

        switch (nombreMes) {
            case "enero":
            case "marzo":
            case "mayo":
            case "julio":
            case "agosto":
            case "octubre":
            case "diciembre":
                dias = 31;
                break;
            case "abril":
            case "junio":
            case "septiembre":
            case "noviembre":
                dias = 30;
                break;
            case "febrero":
                dias = 28; // Asumimos un año no bisiesto para simplificar
                break;
            default:
                dias = 0; // Indicamos que el mes no es válido
                break;
        }

        if (dias != 0) {
            System.out.println("El mes de " + nombreMes + " tiene " + dias + " días.");
        } else {
            System.out.println("El nombre del mes introducido no es válido.");
        }

        scanner.close();
    }
}
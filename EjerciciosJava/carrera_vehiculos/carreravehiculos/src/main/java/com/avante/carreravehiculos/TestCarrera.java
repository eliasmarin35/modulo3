/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.carreravehiculos;

import com.avante.carreravehiculos.logica.Carrera;
import java.util.Scanner;

/**
 *
 * @author jprof
 */
public class TestCarrera {

    /*
        Se trata de una carrera en la que los participantes pueden elegir el
            vehiculo que van a usar (coche, moto o bicicleta).
        
        La carrera acaba cuando un participante llega a la meta.
    
        La distancia a la meta se establece al crear la Carrera.
    
        Cada tipo de vehiculo tiene una velocidad maxima y minima, cuando un
            jugardor elige un vehiculo, se le asigna una velocidad aleatoria
            entre el minimo y el maximo.
    
        La velocidad se mide en metros por iteracion.
    
        La distancia se mide en metros.
    
        En cada iteración debe aparecer la posicion de cada jugador con un mensaje
            personalizado dependiendo del vehiculo que tenga.
    
        Al finalizar se muestra que jugador ha ganado para cada una de las categorias
            (coche, moto o bicicleta).
    
    */
    public static void main(String[] args) {
        // VARS
        int numero;
        int distancia;
        Carrera carrera;
        
        // Inicializamos el scanner
        Scanner scan = new Scanner(System.in);
        
        // Obtenemos el número de jugadores y la distancia
        numero = pedirNumero(scan, "número de jugadores", 2);
        distancia = pedirNumero(scan, "distancia en metros", 100);
        
        // Creamos el objeto carrera
        carrera = new Carrera(numero, distancia);
        
        // iniciamos la carrera
        carrera.jugar(scan);
        
        // _____
        // System.out.printf("Numero: %s  -- Distancia: %d\n",numero,distancia);
        // System.out.println(carrera);
        
        // Cerramos el scaner
        scan.close();
    }
    
    private static int pedirNumero (Scanner scan, String peticion, int minimo) {
        String texto;
        int    numero = -1;
        
        while (numero < minimo) { 
            System.out.printf("\nIntroduzca %s (minimo %d): \n> ", peticion, minimo);
            texto = scan.nextLine().trim();
            System.out.println("");

            try {
                numero = Integer.parseInt(texto);
            }
            catch (NumberFormatException e) {}

            if (numero < minimo) {
                System.err.printf("El número no es correcto, debe de ser al menos %s.\n\n", minimo);
            }
        }
        
        return numero;
    }
}

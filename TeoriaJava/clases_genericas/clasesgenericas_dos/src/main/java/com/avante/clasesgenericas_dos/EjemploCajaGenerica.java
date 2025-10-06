/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.clasesgenericas_dos;

import com.avante.clasesgenericas_dos.logica.Caja;
import com.avante.clasesgenericas_dos.logica.CajaBasica;

/**
 *
 * @author jprof
 */
public class EjemploCajaGenerica {
    public static void main (String [] args) throws Exception {     
        // VARIABLES
        String cadena1="XX", cadena2="YY";
        int    longitud=-1;
        
        // PROGRAMA

        
        // ------- 
        // Almaceno un String, para ello...
        //      * Instancio la clase genérica Caja.
        //      * En la instanciación indico el tipo real que quiero usar.
        //          (en nuestro caso, Integer).
        System.out.println("\n==== 1.- Caja Generica con String");
        
        // 1. Declarar un objecto de una clase generica
        //      Hace falta indicar los tipos reales.
        //      * El tipo de la variable sera el nombre de la clase con
        //          los tipos reales que hemos indicado.
        //      * Durante toda la vida de la variable, los símbolos de tipo
        //          genérico se habrán sustituído por los tipos reales.
        
        Caja<String> cajaCadena = null;

        
        // 1. Instanciar la variable de clase generíca con "new"
        //      Hay 3 formas de hacerlo.
        
        // 1.1.- Usando el "nombre completo" de la clase, que incluye el tipo
        //      real.
        
        cajaCadena = new Caja<String>();
        
        
        // 1.2.- Usando solo el nombe de la clase genérica, pero seguido de
        //      "<>" para indicar que es genérica.
        //      * Los tipos reales ya se conocen porque cuando se declaró la
        //          variable ya se indicaron.
        
        cajaCadena = new Caja<>();
        
        
        // 1.3.- Usando sólo el nombre de la clase.
        //      No hace falta ni siquiera poner "<>" porque Java ya sabe que la
        //          clase es genérica.
        
        cajaCadena = new Caja();
        
        
        // Le damos valor...
        cadena1 = "En un lugar de la mancha...";
        
        cajaCadena.setContenido(cadena1);
          
        
        // Obtenemos el valor
        cadena2 = cajaCadena.getContenido();
        
        
        // Obtenemos la longitud de la cadena
        longitud = cadena2.length();
        
        
        // SALIDA
        System.out.printf("Caja: %s\n", cajaCadena);
        System.out.printf("Cont: %s\n", cadena2);
        System.out.printf("Longitud: %d\n", longitud);
    }
}

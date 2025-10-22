/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.pruebastreams;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jprof
 */
public class Pruebastreams {

    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Pedro");
        nombres.add("Lucía");
        nombres.add("Andrés");
        nombres.add("María");
        nombres.add("Laura");
        
        /*
        for (int i=0; i<nombres.size(); i++) {
            System.out.println(nombres.get(i));
        }
        */
        
        /*
            Usando streams:
                - filtar para dejar solo los nombres que empiezan por L
                - convirtais a mayusculas
                - se muestren por consola uno por uno

        */
        
        /*
        // SOLO CON LAMBDA FUNCTIONS
       
        nombres.stream()
                .filter( e -> e.startsWith("L") )
                .map( e -> e.toUpperCase() )
                .forEach( e -> System.out.println(e) );
        
       */ 
        
        nombres.stream()
                .filter( e -> e.startsWith("L") )
                .map( String::toUpperCase )
                .forEach( System.out::println );
        
        
    }
}

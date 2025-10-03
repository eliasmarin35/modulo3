/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.avante.records;

import com.avante.records.logica.Persona;

/**
 *
 * @author jprof
 */
public class PruebaClasePersona {

    public static void main(String[] args) {
        Persona[] ps = {
            new Persona("Margarita", 25),
            new Persona("Luis", 45),
            new Persona("Fernando", 23),
            new Persona("Paco", 18),
            new Persona("Maite", 98),
            new Persona("Rosa", 52),
        };

        for (Persona p : ps) {
            System.out.println("\n======PERSONA=======");
            System.out.println(p);

            System.out.printf(
                    "Hola %s, tienes %d años.\n",
                    p.getNombre(),
                    p.getEdad()
            );
        }
        
        
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.records;


import com.avante.records.logica.PersonaRecord;

/**
 *
 * @author jprof
 */
public class PruebaRecordPersona {
    public static void main (String[] args) throws Exception {
        PersonaRecord[] ps = {
            new PersonaRecord("Margarita", 25),
            new PersonaRecord("Luis", 45),
            new PersonaRecord("Fernando", 23),
            new PersonaRecord("Paco", 18),
            new PersonaRecord("Maite", 98),
            new PersonaRecord("Rosa", 52),
        };
 
        for (PersonaRecord p : ps) {
            System.out.println("\n======PERSONA RECORD =========");
           
            System.out.println(p);
          
            System.out.printf(
                "%s : Hola %s, tienes %d años.\n",
                    Integer.toHexString(p.hashCode()).toUpperCase(),
                    p.nombre(),
                    p.edad()
            );
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.clasesgenericas;

import com.avante.clasesgenericas.logica.CajaGen;
import com.avante.clasesgenericas.logica.PersonaRecord;

/**
 *
 * @author jprof
 */
public class EjemploCajaGenerica {
    public static void main (String[] args) throws Exception {
        // String
        CajaGen<String> c1 = new CajaGen<String>("ADIOS!");
        System.out.println(c1);
        
        // PersonaRecord
        CajaGen<PersonaRecord> c2 = new CajaGen<>(new PersonaRecord("Lios", 78));
        PersonaRecord p =  c2.getContenido();
        
        System.out.println(p);
    }
 }

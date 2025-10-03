/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.clasesgenericas;

import com.avante.clasesgenericas.logica.Caja;
import com.avante.clasesgenericas.logica.PersonaRecord;

/**
 *
 * @author jprof
 */
public class EjemploCajaSimple {

    public static void main(String[] args) {
        // Caja con String
        Caja c1 = new Caja("Hola!");
        
        System.out.println(c1);
        
        // Caja con entero
        Caja c2 = new Caja();
        c2.setContenido(Integer.valueOf(54));
        
        System.out.println(c2);
        
        // Caja con entero
        Caja c3 = new Caja(new PersonaRecord("Margarita", 25));
        PersonaRecord p = (PersonaRecord) c3.getContenido();
        System.out.println(p);
        
        /* 
        ESTO FALLARIA porque aunque Java intenta hacer el casting a Integer
           el objeto en cuestion no puede convertirse a Integer
           (porque es un PersonaRecord)
        
        Integer num = (Integer) c3.getContenido();
        
        System.out.println(num);
        */
    }
}

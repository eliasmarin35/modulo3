/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.pruebasingletonlombok;

import com.avante.pruebasingletonlombok.logic.AlumnoLombokData;



/**
 *
 * @author jprof
 */
public class PruebaLombokData {

    public static void main(String[] args) {
        AlumnoLombokData al1 = new AlumnoLombokData(10, "Juan");
        AlumnoLombokData al2 = new AlumnoLombokData(2, "Luis");
        
        System.out.printf("Alumno(%d: %s)\n",al1.getNumero(),al1.getNombre());
        
        al2.setNombre("Maria");
        
        System.out.printf("Alumno(%d: %s)\n",al2.getNumero(),al2.getNombre());
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.pruebasingletonlombok;

/**
 *
 * @author jprof
 */
public class PruebaLombokCompleto {

    public static void main(String[] args) {
        AlumnoLombokCompleto al1 = new AlumnoLombokCompleto();
        AlumnoLombokCompleto al2 = new AlumnoLombokCompleto();
        
        al1.setNumero(1);
        al1.setNombre("Juan");
        
        al2.setNumero(1);
        al2.setNombre("Juan");

        
        System.out.printf(
            "Los Alumnos:\n\t%s\n\t%s\n\nSon iguales: %b.\n",
            al1,
            al2,
            al1.equals(al2)
        );
    }
}

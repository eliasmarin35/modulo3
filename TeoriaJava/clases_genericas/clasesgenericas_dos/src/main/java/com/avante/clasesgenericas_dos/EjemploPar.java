/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.clasesgenericas_dos;

import com.avante.clasesgenericas_dos.logica.Par;

/**
 *
 * @author jprof
 */
public class EjemploPar {   
    public static void main (String[] args) throws Exception {
        // Utilizamos la clase Par<C,V> para almacenar los nombres de los
        //      alumnos utilizando:
        //          * CLAVE: número de  lista  (por lo tanto Integer)
        //          * VALOR: nombre del alumno (por lo tanto String)
        
        Par<Integer,String> alumno = new Par<Integer,String>();
        
        alumno.setClaveValor(15, "Daniel");
        
        // SALIDA
        System.out.printf("El alumno es: %s\n", alumno);
    }
}

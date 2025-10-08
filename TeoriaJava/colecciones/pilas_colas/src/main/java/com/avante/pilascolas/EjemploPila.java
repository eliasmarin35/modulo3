/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.pilascolas;

import com.avante.pilascolas.logica.Alumno;
import java.util.LinkedList;
import java.util.Stack;


/**
 *
 * @author jprof
 */
public class EjemploPila {    
    
    public static void main(String[] args) {
        // VARS
        Stack<Alumno> alumnos;
        Alumno al;
        
        // Creo una pila
        alumnos = new Stack<Alumno>();
        
        // Añadimos a la pila
        alumnos.push(new Alumno(45,"Maria"));
        alumnos.push(new Alumno(65,"Luis"));
        alumnos.push(new Alumno(23,"Juan"));
        alumnos.push(new Alumno(78,"Sofia"));
        
        // Vemos cuantos elementos hay
        System.out.printf("Tamaño de la pila: %d.\n", alumnos.size());
        
        System.out.println("");
        
        // Vamos sacando elementos de la pila, hasta que esta esté vacía
        while ( ! alumnos.empty() ) {
            al = alumnos.pop();
            System.out.println(al);
        }
        
        System.out.println("");
        
        // Comprobamos que no quedan elementos
        System.out.printf("Tamaño de la pila: %d.\n", alumnos.size());
    }
}

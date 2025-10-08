/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.coleccioneslistas;

import com.avante.coleccioneslistas.logica.Alumno;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author jprof
 */
public class EjemploLinkedList {
    /*
        Una LinkedList es una lista doblemente enlazada
        Eso significa que es muy eficiente:
            * Añadir/Borrar al principio y al final de la lista
            * Añadir/Borrar en algun lugar de la lista, UNA VEZ QUE NOS
                ENCONTRAMOS ES ESA POSICION
            * Usarla como Pila o como Cola
    
        No es tan eficiente para ir a una posicion dada (hay que recorrer la
            lista).
    */
    
    public static void main(String[] args) throws Exception {
        // VARS
        LinkedList<Alumno>  alumnosLL;
        ListIterator<Alumno> lIt;
        boolean esPar;
        int indice;
        
        // Creamos la lista y la iteramos
        System.out.println("\n====> 1.- Creamos una linked list y la recorremos con for-each");
        
        alumnosLL = new LinkedList<>();
        
        // creamos elementos
        alumnosLL.add(new Alumno(78,"Maria"));
        alumnosLL.add(new Alumno(72,"Luis"));
        alumnosLL.add(new Alumno(76,"Fernando"));
        alumnosLL.add(new Alumno(10,"Alejandra"));
        alumnosLL.add(new Alumno(36,"Sofia"));
        alumnosLL.add(new Alumno(67,"Marcos"));
        
        // iteramos en un for-each
        for (Alumno a : alumnosLL) {
            System.out.println(a);
        }
        
        // Recorremos la lista con un list iterator hacia delante
        System.out.println("\n====> 2.- Usamos la lista con un listIterator - recorrido hacia delante");
        
        lIt = alumnosLL.listIterator();
        
        while (lIt.hasNext()) {
            System.out.println(lIt.next());
        }
        
        // Recorremos la lista con un list iterator hacia atras
        System.out.println("\n====> 2.- Usamos la lista con un ListIterator - recorrido hacia atras");
       
        // Creo un list iterator que comience en el ultimo elemento
        lIt = alumnosLL.listIterator(alumnosLL.size());
       
        
        while (lIt.hasPrevious()) {
            System.out.println(lIt.previous());
        }
        
        
        // Vamos a usar un list iterator para eliminar los elementos pares de
        //  la lista
        System.out.println("\n====> 3.- Eliminamos los indices pares de la lista");
        lIt = alumnosLL.listIterator(alumnosLL.size());
        while (lIt.hasPrevious()) {
            // nextIndex devuelve el indice del siguiente elemento, pero no
            //    avanza al siguiente, eso ocurrira cuando llamemos a next
            indice = lIt.previousIndex();
            esPar = (indice % 2 == 0);
            
            lIt.previous();
            
            if (esPar) {
                System.out.printf("Borro el elemento numero %d\n",indice);
            
                // remove, set, add siempre actuan sobre el ultimo elemento
                //      devuelto por un next o un previous
                lIt.remove();
            }
        }
        
        System.out.println("");
        
        for (Alumno a : alumnosLL) {
            System.out.println(a);
        }
    }
}

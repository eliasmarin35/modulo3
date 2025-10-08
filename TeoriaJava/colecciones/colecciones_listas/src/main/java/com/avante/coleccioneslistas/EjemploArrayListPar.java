/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.coleccioneslistas;

import com.avante.coleccioneslistas.logica.Par;
import java.util.ArrayList;

/**
 *
 * @author jprof
 */
public class EjemploArrayListPar {
    public static void main( String[] args ) throws Exception {
        /*
        // Hemos creado una clase generica que podemos usar para representar
        //      un alumno, con la clave un numero de lista y el valor un nombre.
        Par<Integer,String> a1 = new Par<Integer,String>(76,"Julian");
        
        System.out.println(a1);
        */
        
        /*
        // Esto no se puede hacer en Java, no se puede crear un array de una
        //     clase generica
        Par<Integer,String>[] alumnos;
        alumnos = new Par<Integer,String>[10];
        */
        
        // Lo que si se puede hacer es usar una lista (en este caso ArrayList)
        ArrayList< Par < Integer, String > > alumnos = new ArrayList<>(3);
        
        // metemos valores
        alumnos.add( new Par<>(57,"Inma") );
        alumnos.add( new Par<>(87,"Maria") );
        alumnos.add( new Par<>(90,"Marta") );
        
        // recorremos los valores con un for-each
        for ( Par<Integer,String> p : alumnos ) {
            System.out.println(p);
        }
    }
}

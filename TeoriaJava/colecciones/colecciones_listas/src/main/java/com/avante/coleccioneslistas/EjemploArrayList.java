/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.coleccioneslistas;

import com.avante.coleccioneslistas.logica.Alumno;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jprof
 */
public class EjemploArrayList {

    public static void main(String[] args) {
        // VARS
        ArrayList<Alumno> listaAlumnos;
        Iterator<Alumno> it, it1, it2;
        Alumno a1, a2;
        boolean hayElementos;
        int contador;
        
        // Creamos nuestra lista de alumnos
        listaAlumnos = new ArrayList<Alumno>();
        
        // Añadimos alumnos -> metodo add de una lista
        // En un ArrayList añadir un elemento es eficiente
        listaAlumnos.add(new Alumno(45,"Jose Alfredo"));
        listaAlumnos.add(new Alumno(34,"Maria"));
        listaAlumnos.add(new Alumno(89,"Juana"));
        listaAlumnos.add(new Alumno(1,"Luisa"));
        listaAlumnos.add(new Alumno(90,"Fernanda"));
        
        // 1.- Imprimos alumnos --> for-each
        System.out.println("\n ===> 1.- Recorrido con for-each");
        
        for (Alumno a : listaAlumnos) {
            System.out.println(a);
        }
        
        
        // 2.- Imprimimos alumos --> for tradicional
        // usamos .size() para obtener el tamaño de la lista
        // usamos .get(posicion) para obtener el elemento en la posicion x
        //
        // En un ArrayList obtener el elemento en la posicion x es eficiente
        
        System.out.println("\n ===> 2.- Recorrido con for tradicional");
        
        for (int i=0; i < listaAlumnos.size();i++) {
            a1 = listaAlumnos.get(i);
            System.out.println(a1);
        }
        
        // 3.- Imprimimos alumos --> patron iterador
        System.out.println("\n ===> 3.- Recorrido con el patron iterador");
        
        // 1- Creamos el iterador
        // El iterador es su propio objeto en si mismo
        it = listaAlumnos.iterator();
        
        // Para saber si quedan elementos, se usa el metodo .hasNext() del
        //    iterador
        // Para obtener el siguiente elemento, se usa el metodo .next()
        while ( it.hasNext() ) {
            a1 = it.next();
            System.out.println(a1);
        }
        
        
        // Usar dos iteradores en la misma lista
        System.out.println("\n ===> 3.- Uso de dos iteradores");
        
        // Creo dos iteradores
        it1 = listaAlumnos.iterator();
        it2 = listaAlumnos.iterator();
        
        hayElementos = it1.hasNext() || it2.hasNext();
        contador=0;
                
        while ( hayElementos ) {
            // incremento contador
            contador++;
            
            if (it1.hasNext()) {
                a1 = it1.next();
                System.out.printf("1 : %s.\n",a1);
            }
            
            if (contador % 2 == 0 && it2.hasNext()) {
                a2 = it2.next();
                System.out.printf("\t2 : %s.\n",a2);
            }
            
            // Fin de la iteracion
            hayElementos = it1.hasNext() || it2.hasNext();
        }
        
        
        
        
        
        
        
        
    }
}

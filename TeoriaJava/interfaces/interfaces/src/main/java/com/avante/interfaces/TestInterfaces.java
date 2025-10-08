/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.interfaces;

import com.avante.interfaces.logica.Alumno;
import com.avante.interfaces.logica.Coche;
import com.avante.interfaces.logica.Imprimible;

/**
 *
 * @author jprof
 */
public class TestInterfaces {
    public static void sacaPorPantalla( Imprimible i ) {
        i.imprimir();
    }

    public static void main(String[] args) {
        // Creo un alunmo y un coche
        System.out.println("\n====> 1.- Creo objetos concretos y llamo a sus metodos");
        Alumno al = new Alumno(56, "Maria");
        Coche  co = new Coche("Luis", "676656565", 120);
        
        // Puedo llamar a todos los metodos de cada clase
        System.out.printf("El alumno se llama %s.\n",al.nombre());
        System.out.printf("La matricula del coche es %s.\n",co.matricula());
        
        // Creo un alumno, pero lo guardo en un imprimible
        System.out.println("\n=====> 2.- Creo objeto concreto, pero lo guardo en interfaz.");
        Imprimible al2 = new Alumno(90,"Juan");
        
        /*
        // Solo puedo llamar a los metodos de la interfaz imprimible
        // Por tanto lo de abajo da error
        System.out.printf("El nombre del alumno es %s.\n",al2.nombre());
        */
        
        al2.imprimir();
        
        // Puedo usar objetos concretos como si fueran la interfaz
        System.out.println("\n====> 3.- Usar objetos concretos como si fueran la interfaz.");
        
        // el alumno al y el coche co pueden ser usado como imprimibles.
        // Por tanto pueden pasarse como parametros del metodo sacaPorPantalla
        sacaPorPantalla(al);
        sacaPorPantalla(co);
        
    }
}

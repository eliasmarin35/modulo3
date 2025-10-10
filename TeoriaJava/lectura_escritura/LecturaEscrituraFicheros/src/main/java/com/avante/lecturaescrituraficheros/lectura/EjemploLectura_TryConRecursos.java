/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.avante.lecturaescrituraficheros.lectura;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jprof
 */
public class EjemploLectura_TryConRecursos {

    public static void main(String[] args) {
        // El try con recursos se asegura que el recurso se cerrará al final
        //     independientemente de que ocurra ninguna excepción.
        //
        // El recurso debe declararse dentro del los parentesis del try, asi
        //     que solo existe dentro del bloque.
        //
        // Por eso no tenemos que hacer br.close() porque se hará implicitamente
        //
        try ( BufferedReader br = new BufferedReader(new FileReader("datos.txt")) ) {
            
            br.lines()
                    .map(s -> s.trim())
                    .forEach(System.out::println);
            
        } catch (IOException e) {
            System.err.println("Algo pasó al leer el archivo.");
        }
    }
}

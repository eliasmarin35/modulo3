/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.avante.lecturaescrituraficheros.lectura;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author jprof
 */
public class EjemploLecturaPropiedades_TryConRecursos {

    private final static String FILENAME = "config.properties";

    public static void main(String[] args) {
        Properties props;

        props = new Properties();

        // Leer el fichero de texto en un objeto propiedades
        // El try con recursos se asegura que el recurso se cerrará al final
        //     independientemente de que ocurra ninguna excepción.
        //
        // El recurso debe declararse dentro del los parentesis del try, asi
        //     que solo existe dentro del bloque.
        // Por eso no tenemos que hacer br.close() porque se hará implicitamente
        //
        try ( BufferedReader br = new BufferedReader(new FileReader(FILENAME)) ) {
            
            props.load(br);

        } catch (IOException e) {
            System.err.printf("Algo pasó al leer el archivo %s.\n", FILENAME);
        }

        // Imprimo todas las propiedades
        props.entrySet().stream()
                .forEach(System.out::println);
    }
}

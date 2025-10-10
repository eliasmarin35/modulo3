/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.lecturaescrituraficheros.binarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author jprof
 */
public class LecturaEscritura_Binarios {
    private final static String INPUT_NAME="logo_java_input.png";
    private final static String OUTPUT_NAME="logo_java_output.png";
    
    public static void main(String[] args) {
        byte[] buffer = new byte[1024];
        int    numBytes;
        
        
        // Un bloque try-con-recursos puede crear más de un recurso
        // Al acabar el bloque se agurará que todos los recursos creados
        //    se han cerrado
        try (
                FileInputStream  fis = new  FileInputStream(INPUT_NAME);
                FileOutputStream fos = new FileOutputStream(OUTPUT_NAME)
        ) {
            // El método read(byte[]) de FileInputStream lee como máximo
            //     el numero de bytes que caben en el array que se pasa
            //     por parámetro y devuelve el número de bytes leídos.
            //
            // En el caso de que no haya más datos que leer, devuelve -1
            //   (EOF).
            //
            
            numBytes = fis.read(buffer);
            
            while ( numBytes != -1 ) {
                // FileOututStream tiene métodos simétricos con FileInputStream
                fos.write(buffer);
                numBytes = fis.read(buffer);
            }
        }
        catch(IOException e) {
            System.err.println("Algún problema leyendo o escribiendo.");
        }
    }
}

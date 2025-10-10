/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.avante.lecturaescrituraficheros.lectura;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jprof
 */
public class EjemploLecturaTexto_FileReader {

    public static void main(String[] args) {
        FileReader fr = null;
        char c;
        int n;

        try {
            fr = new FileReader("datos.txt");
            do {
                n = fr.read();

                if (n != -1) {
                    c = (char) n;
                    System.out.println(c);
                }
            } while (n != -1);

            fr.close();
        } catch (FileNotFoundException e) {
            System.err.println("No se encuentra el archivo datos.txt");
        } catch (IOException e) {
            System.err.println("Algo pasó al leer el archivo.");
        }
    }
}

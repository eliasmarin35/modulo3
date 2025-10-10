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
public class EjemploLecturaPorLineas_BufferedRead {

    public static void main(String[] args) {
        BufferedReader br = null;

        String line;
        int numLine = 0;

        try {
            br = new BufferedReader(new FileReader("datos.txt"));

            line = br.readLine();

            while (line != null) {
                line = line.trim();
                System.out.printf("Linea %d: %s\n", ++numLine, line);

                line = br.readLine();
            }

            br.close();

        } catch (FileNotFoundException e) {
            System.err.println("No se encuentra el archivo datos.txt");
        } catch (IOException e) {
            System.err.println("Algo pasó al leer el archivo.");
        }
    }
}

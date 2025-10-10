/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.lecturaescrituraficheros.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author jprof
 */
public class EjemploEscribirPersistencia_ObjectOutputStream {
    private final static String FILENAME = "persona.dat";
    
    public static void main (String[] args) {
        Alumno a = new Alumno(89,"Luis");
        
        try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME,false)) ) {
            
            oos.writeObject(a);
            
        }
        catch (IOException e) {
            System.err.printf("Ocurrió un error al escribir en el fichero %s.\n",FILENAME);
        }
    }
}

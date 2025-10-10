/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.lecturaescrituraficheros.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author jprof
 */
public class EjemploLeerPersistencia_ObjectInputStream {
    private final static String FILENAME = "persona.dat";
    
    public static void main (String[] args) {
        Alumno a=null;
        
        try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME)) ) {
     
            a = (Alumno) ois.readObject();
        }
        catch (IOException e) {
            System.err.printf("Ocurrió un error al leer en el fichero %s.\n",FILENAME);
        }
        catch (ClassNotFoundException e) {
            System.err.printf("No existe la clase a la que pertenece el objecto en el archivo %s.\n",FILENAME);
        }
        
        System.out.println(a);
    }
}

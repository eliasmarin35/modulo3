/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.lecturaescrituraficheros.escritura;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author jprof
 */
public class EjemploEscritura_PrintWriter {
    private static final String FILENAME="out_001.txt";
    
    public static void main(String[] args) {
        
        ArrayList<String> stringList = new ArrayList<>();
        
        stringList.add("==> UNO");
        stringList.add("");
        stringList.add("\t==> DOS");
        stringList.add("\t");
        stringList.add("==> TRES");
        stringList.add("");
        stringList.add("   ==> CUATRO");
        stringList.add("");
        stringList.add("==> CINCO   ");
        stringList.add("");
        stringList.add("==> SEIS    ");
                
        
        // El constructor de FileWrite(String filename, boolean append)
        //    nos permite abrir un fichero para inlcuir cosas al final de este
        //
        // OJO!! Si no usamos ese constructor o si append=false el contenido
        //    inicial del fichero se pierde.
        //
        // La clase PrintWriter tiene un buffer intermedio. Este buffer se va
        //    volcando al fichero en disco de manera transparente al usuario
        //    o cuando el usuario lo fuerce llamando al metodo flush.
        //
        // Al hacerse un close (o al acabar el bloque try-con-recursos ocurre
        //    un flush automatico, para que se terminen de escribir los datos
        //    que faltan.
        //
        // Pero si ocurriese un error y se saltara a la excepcion, el fichero
        //    se cerraria (por estar en un bloque try-con-recursos) pero no se
        //    puede asegurar que el contenido del buffer se haya volcado al
        //    fichero.
        try ( PrintWriter pw = new PrintWriter(new FileWriter(FILENAME,false)) ) {
            
            // Escribo los contenidos del array list como lineas en el archivo
            // Le hacemos un trim a cada linea antes de escribirla e ignoramos las
            //   lineas vacias
            stringList.stream()
                .map( s -> s.trim() )
                .filter( s-> !s.isEmpty())
                .forEach( s -> pw.println(s) );
        }
        catch(IOException e) {
            System.err.printf("Algún error escribiendo en el archivo %s.\n",FILENAME);
        }
    }
}

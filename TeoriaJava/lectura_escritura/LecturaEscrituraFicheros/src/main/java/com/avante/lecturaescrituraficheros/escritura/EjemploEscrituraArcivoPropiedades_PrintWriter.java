/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.lecturaescrituraficheros.escritura;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 *
 * @author jprof
 */
public class EjemploEscrituraArcivoPropiedades_PrintWriter {
    private static final String FILENAME = "conf_out_001.properties";
    
    public static void main(String[] args) {
        Properties props = new Properties();
        
        props.setProperty("email", "juanma@pp.com");
        props.setProperty("telefono", "666666666");
        props.setProperty("ciudad", "Sevilla");
        props.setProperty("pais", "España");
        props.setProperty("DNI", "27654896O");
        
        try( PrintWriter pw = new PrintWriter(new FileWriter(FILENAME,false))) {
            
            props.store(pw,"Mi primer archivo properties.");
            
        }
        catch (IOException e) {
            System.err.printf("Algún error esccribiendo las propiedades en %s.\n",FILENAME);
        }
    }
}

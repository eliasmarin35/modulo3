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
public class EjemploLecturaPropiedades_BufferedRead {

    private final static String FILENAME = "config.properties";

    public static void main(String[] args) {
        BufferedReader br = null;
        Properties props;
        String k1, k2, k3, v1, v2, v3;

        props = new Properties();

        // Leer el fichero de texto en un objeto propiedades
        try {
            br = new BufferedReader(new FileReader(FILENAME));

            props.load(br);

            br.close();

        } catch (FileNotFoundException e) {
            System.err.printf("No se encuentra el archivo %s.\n", FILENAME);
        } catch (IOException e) {
            System.err.printf("Algo pasó al leer el archivo %s.\n", FILENAME);
        }

        // Trabajo con las propiedades
        // 1.- Obtener todas las propiedades e imprimirlas
        System.out.println("\n====> 1.- Imprimo todas las propiedades K=V");
        props.entrySet().stream()
                .forEach(System.out::println);

        // 2.- Obtener todos los valores e imprimirlas
        System.out.println("\n====> 2.- Imprimo todos los valores V");
        props.values().stream()
                .forEach(System.out::println);

        // 3.- Obtener todas las claves e imprimirlas
        System.out.println("\n====> 3.- Imprimo todas las clasves K");
        props.keySet().stream()
                .forEach(System.out::println);

        // 4.- Comprobar si existe una clave y obtener su valor
        System.out.println("\n====> 4.- Compruebo que existe una clave dada y obtengo su valor");
        k1 = "username";
        if (props.containsKey(k1)) {
            System.out.printf("La clave %s tiene el valor %s.\n", k1, props.get(k1));
        } else {
            System.out.printf("La clave %s no existe.\n", k1);
        }

        k1 = "user";
        if (props.containsKey(k1)) {
            System.out.printf("La clave %s tiene el valor %s.\n", k1, props.get(k1));
        } else {
            System.out.printf("La clave %s no existe.\n", k1);
        }
        
        // 5.- Obtener valores sin comprobar si la clave existe
        System.out.println("\n====> 5.- Obtengo un valor sin comprobar si la clave existe.");
        
        k1 = "user";
        System.out.printf("Existe: %s == %s\n",k1,props.get(k1));
        
        k1 = "username";
        System.out.printf("No Existe: %s == %s\n",k1,props.get(k1)); // Da null
        
        k1 = "username";
        System.out.printf("No Existe (getProperty): %s == %s\n",k1,props.getProperty(k1)); // Da null
        
        
        // 6.- Obtener valores con valor por defecto
        System.out.println("\n====> 6.- Obtengo un valor con uno por defecto.");
        
        k1 = "user";
        System.out.printf("Existe: %s == %s\n",k1,props.getProperty(k1,"nobody"));
        
        k1 = "username";
        System.out.printf("No Existe (por defecto): %s == %s\n",k1,props.getProperty(k1,"nobody"));
        
        k1 = "name";
        System.out.printf("Existe vacia (se queda con el valor vacio): %s == %s\n",k1,props.getProperty(k1,"nobody"));
        
        
        // 7.- Añadir nuestras propiedades
        System.out.println("\n====> 7.- Añado una propiedad");
        
        k1 = "date";
        props.setProperty(k1, "15-JAN-2025");
        
        System.out.printf("%s == %s\n",k1,props.getProperty(k1));
        
        // 8.- Borrar una clave-valor
        System.out.println("\n====> 8.- Borrar una clave");
        
        props.entrySet().stream().forEach(System.out::println);
        System.out.println("");
        
        k1 = "date";
        props.remove(k1);
        
        System.out.printf("He borrado %s.\n\n",k1);
        
        props.entrySet().stream().forEach(System.out::println);
    }
}

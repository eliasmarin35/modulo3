/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.clasesgenericas_dos;

import com.avante.clasesgenericas_dos.logica.CajaBasica;

/**
 *
 * @author jprof
 */
public class EjemploCajaBasica {
    public static void main (String [] args) throws Exception {
        // VARIABLES
        CajaBasica caja1=null;
        Object     contenido=null;
        Integer    numero1=-3, numero2=-3;
        String     cadena1="XX", cadena2="YY";
        
        int longitud=-1;
        
        // PROGRAMA

        
        // ------- 
        // 1.- Almaceno un Integer y al extraer hago casting a Integer
        System.out.println("\n==== 1.- mete Integer - saca Integer");
        
        // Almaceno algo en la caja (uso el setter)
        caja1 = new CajaBasica();
        numero1 = Integer.valueOf(57);
        
        caja1.setContenido(numero1);
        
        // Extraigo el elemento de la caja (uso el getter)
        // Y además espero que sea de un tipo especifico y por tanto
        //    lo fuerzo mediante un casting explicito.
        try {
            numero2 = (Integer) caja1.getContenido();
        }
        catch (Exception error) {
            System.err.printf("Ha ocurrido un FALLO al extraer: %s\n", error);
        }
        
        // SALIDA
        System.out.println(caja1);
        System.out.println(numero2);
        
        
        // ------- 
        // 2.- Almaceno un String y al extraer hago casting a Integer (FALLA)
        System.out.println("\n==== 2.- mete String - saca Integer - Falla");
        
        // Almaceno algo en la caja (uso el setter)
        caja1 = new CajaBasica();
        cadena1 = "HOLA QUE TAL?";
        numero2 = -3; 
        
        caja1.setContenido(cadena1);
        
        // Extraigo el elemento de la caja (uso el getter)
        // Y además espero que sea de un tipo especifico y por tanto
        //    lo fuerzo mediante un casting explicito.
        try {
            numero2 = (Integer) caja1.getContenido();
        }
        catch (Exception error) {
            System.err.printf("Ha ocurrido un FALLO al extraer: %s\n", error);
        }
        
        // SALIDA
        System.out.println(caja1);
        System.out.println(numero2);
        
        // ------- 
        /*
        3.- Almaceno un String y al extraer guardo en un Object.
            
            Por lo tanto no tengo que hacer ningun casting, pero la variable
                "sólo" es Object, es decir, cuando un Object no sea suficiente
                para la funcionalidad que necesitamos, habrá que terminar
                haciendo el casting de todas formas, sólo habremos postpuesto
                el momento de hacerlo.
            En resumen, usar un Object nos evita hacer el casting en el momento
                del getter, pero hay muchas probabilidades de que después haya
                hacerlo.
        */
        System.out.println("\n==== 3.- mete String - saca Object - No hay que hacer casting (de momento)");
        
        // Almaceno algo en la caja (uso el setter)
        caja1 = new CajaBasica();
        cadena1 = "HOLA QUE TAL?";
        contenido = null; 
        
        caja1.setContenido(cadena1);
        
        // Extraigo el elemento de la caja (uso el getter)
        // No hay que hacer casting porque la variable ya es un object.
        contenido = caja1.getContenido();
       
        // SALIDA
        System.out.println(caja1);
        System.out.println(contenido);
        
        // Voy a imprimir la longitud de la cadena de texto que guarde en la
        //     caja.
        // Para ello, vuelvo a sacar el contenido con el getter y a guardarlo
        //     en una variable Object.
        
        contenido = caja1.getContenido();
        // longitud = contenido.length(); // (esto es error en compilación)
        longitud = ((String) contenido).length();
        
        System.out.printf("La longitud de la cadena de texto de la caja es: %d.\n", longitud);
    }
}

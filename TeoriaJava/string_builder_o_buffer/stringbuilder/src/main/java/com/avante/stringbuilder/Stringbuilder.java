/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.stringbuilder;

/**
 *
 * @author jprof
 */
public class Stringbuilder {
    
    /*
        Las cadenas de caracteres en Java son inmutables (o invariantes), ESO
            quiere decir que cada cadena se crea en menoria, y cada modificacion
            o concatenación resulta en crear en memoria una nueva cadena
            resultado.
    
        Para textos pequeños esto no es un problema, pero para trozos de texto
            grandes resulta en un uso ineficiente de la memoria.
    
        En general, si sabemos que vamos a construir un texto por trozos, es
            recomendable usar StringBuffer.
    
        StringBuffer es un buffer en memoria para almacenar texto de manera
            eficiente, que permite ir añadiendo y modificando el texto que
            llevamos.
    
        A la hora de imprimirlo por pantalla se transforma en String, la idea
            es que solo acabe existiendo un String para todo el buffer.
    
    
        StringBuffer es seguro para concurrencia (multihilos).
    
        StringBuilder no es seguro en concurrencia, pero tiene los mismos
            metodos que StringBuffer y se puede usar tranquilamente si nuestro
            programa sólo tiene un hilo de procesamiento.
    
    
        ENLACE AL LOREM IPSUM: https://loremipsum.io/generator
    
    */

    public static void main(String[] args) {
        // VARS
        StringBuffer buff1, buff2;
        String s1;
        
        // 1.- constructor por defecto y añadir
        System.out.println("\n ====> 1.- Constructor por defecto, u sando append y directamente sout.");
        
        buff1 = new StringBuffer();
        
        buff1.append("Lorem ipsum dolor sit amet consectetur adipiscing elit. Quisque faucibus ex sapien vitae pellentesque sem placerat. In id cursus mi pretium tellus duis convallis. Tempus leo eu aenean sed diam urna tempor. Pulvinar vivamus fringilla lacus nec metus bibendum egestas. Iaculis massa nisl malesuada lacinia integer nunc posuere. Ut hendrerit semper vel class aptent taciti sociosqu. Ad litora torquent per conubia nostra inceptos himenaeos.");
        buff1.append("\n\n");
        buff1.append(57);
        buff1.append('Z');
        buff1.append("\n\n");
        buff1.append("Lorem ipsum dolor sit amet consectetur adipiscing elit. Quisque faucibus ex sapien vitae pellentesque sem placerat. In id cursus mi pretium tellus duis convallis. Tempus leo eu aenean sed diam urna tempor. Pulvinar vivamus fringilla lacus nec metus bibendum egestas. Iaculis massa nisl malesuada lacinia integer nunc posuere. Ut hendrerit semper vel class aptent taciti sociosqu. Ad litora torquent per conubia nostra inceptos himenaeos.");
        buff1.append("\n\n");
        
        // Podemos depender del toString gracias al casting implicito
        System.out.println(buff1);
        
        
        
        // 2.- Metodo para convertir a cadena usando el constructor con parametros
        System.out.println("\n ====> 2.- Constructor con parametros, usando append y directamente sout.");
        
        buff2 = new StringBuffer(buff1);
        buff2.append("\n\nHOLA QUE TAL!");
        
        s1 = buff2.toString();
        
        System.out.println(s1);
        
        
        // 3.- Modificacion de caracteres
        System.out.println("\n ====> 3.- Modificar caracteres en StringBuffer.");
        
        // Cojo el buffer2 y modifico el principio poniendo X en los
        //      10 primeros caracteres
        
        for (int i=0; i<=10; i++) {
            buff2.setCharAt(i,'X');
        }
        
        System.out.println(buff2);
        
        
        // 4.- Insercion
        System.out.println("\n ====> 4.- Insercion.");
        
        buff2.insert(11,"\nFIN DE LAS X\n\n");
        buff2.insert(0 ,"EMPIEZAN LAS X:\n");
        
        System.out.println(buff2);
        
    }
}

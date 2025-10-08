/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.charint;

/**
 *
 * @author jprof
 */
public class CaracteresEspeciales {
    /*
        ENLACE A LA TABLA ASCII: https://www.ascii-code.com/
        ENLACE A LOS CODIGOS ANSI: https://gist.github.com/fnky/458719343aabd01cfb17a3a4f7296797
    */
    public static void main(String[] args) {
        // 1.- Caracteres especiales
        /*
            \\ -> \
            \n -> intro
            \t -> tabulador
            \" -> "
            \' -> '
            \r -> retorno de carro
            \b -> retroceso
            \f -> avance de pagina (form feed)
        
            Escribiendo el codigo:
            \nnn -> se interpreta como el codigo octal del caracter (obsoleto)
                    ejemplo \033 es el caracter ESC
        
            \\uNNNN -> se interpreta como el codigo hexadecimal unicode del caracter
                    ejemplo \u001B es el caracter ESC
        */
        
        String s1;
        
        // 1.- Ejemplo escribiendo color rojo
        // es el caracter ESC + "[31m"
        // ( se resetea con ESC + "[0m"
        // OJO!! Funciona en terminal que soporte codigos ANSI
        
        System.out.println("\n-----> 1.- Escribir un texto con rojo");
        s1 = "Hola \u001B[31mLuis\u001B[0m, que tal?";
        System.out.println(s1);
        
        
        // 2.- Ejemplo con una letra
        // LA R mayuscula es el codigo hex 52
        System.out.println("\n-----> 2.- Ejemplo con una letra.");
        s1 = "Mi letra es \u0052";
        System.out.println(s1);
        
        
        // 3.- Ejemplo de backspace
        System.out.println("\n-----> 3.- Ejemplo de backspace.");
        s1 = "HOLA\b LUIS";
        System.out.println(s1);
        System.out.printf("La cadena anterior tiene %d.\n",s1.length());
    }
}

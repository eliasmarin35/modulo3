/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.charint;

/**
 *
 * @author jprof
 */
public class Charint {
    /*
        ENLACE A LA TABLA ASCII: https://www.ascii-code.com/
    */

    public static void main(String[] args) {
        // VARS
        char c1, c2, c3, c4;
        int  n1, n2, n3, n4;
        
        
        // 1.- Literales caracter
        System.out.println("\n =========> 1.- literales caracter.");
        c1 = 'A';
        System.out.println(c1);
        
        // 2.- Caracter como int
        System.out.println("\n =========> 2.- meter un char en un int.");
        c1 = 'A';
        n1 = c1;
        System.out.println(n1);
        
        // 3.- Int como char
        System.out.println("\n =========> 3.- meter un int en un char.");
        // Usamos la S (01010011 en binario, 123 en octal, 53 en hex y 83 en decimal).
        n1 = 0b01010011; // binario
        n2 = 0123;       // octal
        n3 = 0x53;       // hexadecimal
        n4 = 83;         // decimal
        
        c1 = (char) n1;
        c2 = (char) n2;
        c3 = (char) n3;
        c4 = (char) n4;
        
        System.out.printf("Los caracteres son %c, %c, %c y %c.\n", c1,c2,c3,c4);
        
        // 4.- Usar los char como si fueran numeros
        System.out.println("\n =========> 4.- Usar un bucle for de chars");
        c1 = 'A';
        c2 = 'Z';
        
        for (char c=c1; c<=c2; c++) {
            System.out.println(c);
        }
        
        // 5.- Poner una letra en mayuscula
        System.out.println("\n =========> 5.- Poner una letra en mayuscula.");
        c1 = 'a';
        c2 = 'A';
        n1 = c1 - c2;
        
        System.out.printf("Entre la %c y la %c hay %d.\n",c1,c2,n1);
        
        c1 = 't';
        c2 = (char) (c1 - n1);
        
        System.out.printf("La letra %c menos %d nos da la letra %c.\n",c1,n1,c2);
    }
}

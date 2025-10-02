/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.incrementos;

/**
 *
 * @author jprof
 */
public class Decrementos {

    public static void main(String[] args) {
        int n1, n2;
        
        // ============> INCREMENTO (Ya asigna valor!)
        System.out.println("\nResultado de PRE INCREMENTO y POST INCREMENTO");
        n1 = 3;
        
        // POST INCREMENTO
        n1++;
        n1++;
        n1++;
        
        // PRE INCREMENTO
        ++n1;
        ++n1;
        ++n1;
        
        System.out.printf("El número es %d.\n",n1);
        
        // ============> Ejemplo de PRE INCREMENTO        
        System.out.println("\nEjemplo de PRE INCREMENTO");
        
        n1 = 3;
        n2 = 0;
        
        n2 = (++n1) + 2;
        
        System.out.printf("El número 1 es %d.\n",n1);
        System.out.printf("El número 2 es %d.\n",n2);
        
        // ============> Ejemplo repeticion de PRE INCREMENTO
        System.out.println("\nRepeticion Ejemplo de PRE INCREMENTO");
        
        n1 = 3;
        n2 = 0;
        
        n1 = n1 + 1;
        n2 = n1 + 2;
        
        System.out.printf("El número 1 es %d.\n",n1);
        System.out.printf("El número 2 es %d.\n",n2);
        
        // ============> Ejemplo de POST INCREMENTO
        System.out.println("\nEjemplo de POST INCREMENTO");
        
        n1 = 3;
        n2 = 0;
        
        n2 = (n1++) + 2;
        
        System.out.printf("El número 1 es %d.\n",n1);
        System.out.printf("El número 2 es %d.\n",n2);
        
        // ============> Ejemplo repeticion de POST INCREMENTO

        System.out.println("\nRepeticion Ejemplo de POST INCREMENTO");
        
        n1 = 3;
        n2 = 0;
        
        n2 = n1 + 2;
        n1 = n1 + 1;
        
        System.out.printf("El número 1 es %d.\n",n1);
        System.out.printf("El número 2 es %d.\n",n2);
        
    }
}

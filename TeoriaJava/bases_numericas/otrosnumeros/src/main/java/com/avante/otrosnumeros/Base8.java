/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.otrosnumeros;

/**
 *
 * @author jprof
 */
public class Base8 {
    public static void main (String[] args) throws Exception {   
        /*
            Los numeros en base 8 son los numeros octales.
            Se componen de digitos que van del 0 al 7 (siempre de 0 a BASE-1).
            Para calcular el valor de un numero se utilizan potencias de la base (8)
                dependiendo de su posicion.
            El digito menos significativo se multiplica por la potencia 0 de la base
                (la base es 8, y cualquiero numero elevado a 0 es 1).
            A continuación cada digito restante de derecha a izquierda se multiplicara
                por una potencia de la base (8) que irá de 1 en adelante según la posición.
            El resultado en base 10 será la suma de todas estas multiplicaciones.
        
            Ej:
                775
                    5 * 8^0 = 5 * 1  = 5
                    7 * 8^1 = 7 * 8  = 56
                    7 * 8^2 = 7 * 64 = 448
                    
        ====================================
                   775 -> 5+56+448 = 509
        
            * El 1 seguido de ceros en octal será una potencia de 8.
                El 8 se eleva al numero de ceros que haya.
                Ej:
                    1000 => 8^3 = 512
        
            * Una secuencia de sietes en octal, será una potencia de 8 menos 1.
                El 8 se eleva al numero total de sietes que haya.
        
                Ej: 
                    7777 => 8^4 -1 = 4095
        */
    }
    
}

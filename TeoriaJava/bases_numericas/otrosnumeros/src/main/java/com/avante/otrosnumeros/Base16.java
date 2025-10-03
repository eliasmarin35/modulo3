/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.otrosnumeros;

/**
 *
 * @author jprof
 */
public class Base16 {
    public static void main (String[] args) throws Exception {   
        /*
            Los numeros en base 16 son los numeros hexadecimales.
            Se componen de digitos que van del 0 al F (siempre de 0 a BASE-1).
                (0 1 2 3 4 5 6 7 8 9 A B C D E F)
            Para calcular el valor de un numero se utilizan potencias de la base (16)
                dependiendo de su posicion.
            El digito menos significativo se multiplica por la potencia 0 de la base
                (la base es 16, y cualquiero numero elevado a 0 es 1).
            A continuación cada digito restante de derecha a izquierda se multiplicara
                por una potencia de la base (16) que irá de 1 en adelante según la posición.
            El resultado en base 10 será la suma de todas estas multiplicaciones.
        
            Ej:
                1AC
                    C-> 12 * 16^0 = 12 * 1   = 16
                    A-> 10 * 16^1 = 10 * 16  = 160 
                    1-> 1  * 16^2 = 1  * 256 = 256
                    ===================================
                    1AC => 16+160+256 = 432
                  
        
            * El 1 seguido de ceros en hexadecimal será una potencia de 16.
                El 16 se eleva al numero de ceros que haya.
                Ej:
                    1000 => 16^3 = 4096
        
            * Una secuencia de F en hexadecimal, será una potencia de 16 menos 1.
                El 16 se eleva al numero total de F que haya.
        
                Ej (Maximo Valor de un Byte):
                    Un Byte se puede representar con dos digitos hexadeciamles.
                    Cada digito hexadecimal representa 4 digitos binarios
        
                    FF en hex -> 1111 1111 en bin 
                    FF => 16^2 -1 = 255
        
                    ( 16 == 2^4 ---> 16^2 == 2^8 )
        
        
                Ej de representacion de un Byte en hex:
                    A3  -> 1010 0011
        */
    }
    
}

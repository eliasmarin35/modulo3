/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.otrosnumeros;

/**
 *
 * @author jprof
 */
public class Base2 {
    public static void main (String[] args) throws Exception {
        /*
            UNIDADES DE MEDIDA
                Dsitancia
                * 1Km = 1000 metros -> 10^3
        
                Bytes
                1 KB = 1024 B -> 2^10
        
                Potencias de 2
                    2^0  = 1
                    2^1  = 2
                    2^2  = 4
                    2^3  = 8
                    2^4  = 16
                    2^5  = 32
                    2^6  = 64
                    2^7  = 128
                    2^8  = 256
                    2^9  = 512
                    2^10 = 1024
        */
        
        
        /*
            Los numeros en base 2 son los numeros binarios.
            Se componen de digitos que van del 0 al 1 (siempre de 0 a BASE-1).
            Para calcular el valor de un numero se utilizan potencias de la base (2)
                dependiendo de su posicion.
            El digito menos significativo se multiplica por la potencia 0 de la base
                (la base es 2, y cualquiero numero elevado a 0 es 1).
            A continuación cada digito restante de derecha a inquierda se multiplicara
                por una potencia de la base (2) que irá de 1 en adelante según la posición.
            El resultado en base 10 será la suma de todas estas multiplicaciones.
        
            Ej:
                1001
                    1 * 2^0 = 1 * 1 = 1
                    0 * 2^1 = 0 * 2 = 0
                    0 * 2^2 = 0 * 4 = 0
                    1 * 2^3 = 1 * 8 = 8
        ====================================
                   1001 -> 1+0+0+8 = 9
        
            * El 1 seguido de ceros en binario será una potencia de 2.
                El dos se eleva al numero de ceros que haya.
                Ej:
                    1000 => 2^3 = 8
        
            * Una secuencia de unos en binario, será una potencia de 2 menos 1.
                El dos se eleva al numero total de unos que haya.
        
                Ej (maximo valor que podemos escribir en un Byte):
                    (un Byte tiene 8 bits)
        
                        Max valor en binario de un byte es 11111111
                    
                    11111111 => 2^8 -1 = 256 - 1 = 255
                    
                
        */
    }
    
}

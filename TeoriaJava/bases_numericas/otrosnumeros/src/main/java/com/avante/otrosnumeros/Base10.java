/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.otrosnumeros;

/**
 *
 * @author jprof
 */
public class Base10 {

    public static void main(String[] args) {
        /*
            Los numeros en base 10 son los numeros que usamos normalmente.
            Se componen de digitos que van del 0 al 9 (siempre de 0 a BASE-1).
            Para calcular el valor de un numero se utilizan potencias de la base (10)
                dependiendo de su posicion.
            El digito menos significativo se multiplica por la potencia 0 de la base
                (la base es 10, y cualquiero numero elevado a 0 es 1).
            A continuación cada digito restante de derecha a inquierda se multiplicara
                por una potencia de la base (10) que irá de 1 en adelante según la posición.
            El resultado en base 10 será la suma de todas estas multiplicaciones.
        
            Ej:
                7543
        
                    3 * 10^0 = 3 * 1    = 3
                    4 * 10^1 = 4 * 10   = 40
                    5 * 10^2 = 5 * 100  = 500
                    7 * 10^3 = 7 * 1000 = 7000
                       ========================
                    3 + 40 + 500 + 7000 = 7543
        
            Cualquier numero que sea un 1 seguido de ceros, valdra la BASE elevada
                al numero de 0.
        
            Ej:
        
                1000  -> 10^3
                10000 -> 10^4
        
            Y por tanto, cualquier numero que sea una sucesion del mayor digito
                expresable en la BASE (BASE-1, que para el 10, seria el 9), vale
                la BASE elevada al numero de digitos MENOS 1.
        
            Ej:
                999  -> 10^3 - 1 = 1000 - 1 = 999
        */
        
        int numero = 7543;
        System.out.println(numero);
    }
}

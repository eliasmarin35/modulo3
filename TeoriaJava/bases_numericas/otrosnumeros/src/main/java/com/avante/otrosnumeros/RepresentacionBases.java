/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.otrosnumeros;

/**
 *
 * @author jprof
 */
public class RepresentacionBases {

    public static void main(String[] args) throws Exception {
        int numbase2;
        int numbase8;
        int numbase16;

        // ===============> BINARIOS
        System.out.println("\n=============> BINARIOS");
        // se indican con 0b delante
        // 1001 = 9
        numbase2 = 0b1001;
        
        // Para imprimirla por pantalla en binario usamos Integer.toBinaryString()
        System.out.printf(
            "El numero binario %s es %d.\n",
                Integer.toBinaryString(numbase2),
                numbase2
        );
        
        // ===============> OCTALES
        System.out.println("\n=============> OCTALES");
        // se indican con 0 delante
        // 775 = 509
        numbase8 = 0775;
        
        // Para imprimirla por pantalla en octal usamos Integer.toOctalString()
        System.out.printf(
            "El numero octal %s es %d.\n",
                Integer.toOctalString(numbase8),
                numbase8
        );
        
        // ===============> HEXADECIMAL
        System.out.println("\n=============> HEXADECIMAL");
        // se indican con 0x delante
        // FF = 255
        numbase16 = 0xFF;
        
        // Para imprimirla por pantalla en hexadecimal usamos Integer.toHexString()
        System.out.printf(
            "El numero hexadecimal %s es %d.\n",
                Integer.toHexString(numbase16).toUpperCase(),
                numbase16
        );
    }
}

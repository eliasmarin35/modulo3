/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.enumsimple;

import com.avante.enumsimple.logica.DiaSemanaInt;

/**
 *
 * @author jprof
 */
public class MainEnumInt {

    public static void main(String[] args) throws Exception {
        for ( DiaSemanaInt dia : DiaSemanaInt.values()) {
            System.out.printf("%s -> %d.\n", dia, dia.getHorasCurro());
        }
    }

}

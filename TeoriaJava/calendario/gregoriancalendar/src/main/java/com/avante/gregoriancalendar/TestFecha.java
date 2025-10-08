/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.gregoriancalendar;

import com.avante.gregoriancalendar.logica.Fecha;

/**
 *
 * @author jprof
 */
public class TestFecha {

    public static void main(String[] args) {
        Fecha f1 = new Fecha(8,10,2025);
        
        System.out.println(f1);
        f1.addDias(100);
        System.out.println(f1);
    }
}

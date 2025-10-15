/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.pruebasingleton;

/**
 *
 * @author jprof
 */
public class TestAlumnoSingleton {

    public static void main(String[] args) {
        AlumnoSingleton a1, a2, a3;
        
        a1 = AlumnoSingleton.getInstance();
        a2 = AlumnoSingleton.getInstance();
        a3 = AlumnoSingleton.getInstance();
        
        a1.set(1,"Luis");
        a2.set(2,"Maria");
        a3.set(3,"Juan");
        
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        
        System.out.println(a1==a2);
        System.out.println(a1==a3);
        System.out.println(a2==a3);
    }
}

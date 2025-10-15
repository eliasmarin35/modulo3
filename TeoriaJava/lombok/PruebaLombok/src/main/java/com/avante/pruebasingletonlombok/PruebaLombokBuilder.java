/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.pruebasingletonlombok;

import com.avante.pruebasingletonlombok.logic.AlumnoLombokBuilder;

/**
 *
 * @author jprof
 */
public class PruebaLombokBuilder {

    public static void main(String[] args) {
        AlumnoLombokBuilder al1 = AlumnoLombokBuilder.builder()
                .numero(1)
                .nombre("Juan")
                .build();

        AlumnoLombokBuilder al2 = AlumnoLombokBuilder.builder()
                .numero(2)
                .nombre("Luis")
                .build();
        
        AlumnoLombokBuilder al3 = new AlumnoLombokBuilder(3,"Pedro");

        System.out.println(al1);
        System.out.println(al2);
        System.out.println(al3);
    }

}

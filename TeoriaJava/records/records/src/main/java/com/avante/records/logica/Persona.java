/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.records.logica;

/**
 *
 * @author jprof
 */
public class Persona {
    private final String nombre;
    private final int    edad;

    public Persona (String n, int e) {
        this.nombre = n;
        this.edad = e;
    }
    
    public String getNombre () {
        return this.nombre;
    }
    
    public int getEdad () {
        return this.edad;
    }
    
    @Override
    public String toString() {
        return String.format(
            "La persona [%s] tiene %d años.",
            this.nombre,
            this.edad
        );
    }
}

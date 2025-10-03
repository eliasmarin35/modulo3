/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.records.logica;

/**
 *
 * @author jprof
 */
public record PersonaRecord (
    String nombre,
    int    edad
) {

    @Override
    public String toString() {
        return String.format(
            "La persona [%s] tiene %d años.",
            this.nombre,
            this.edad
        );
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.pilascolas.logica;

/**
 *
 * @author jprof
 */
public record Alumno(int numero, String nombre) {
    public String toString() {
        return String.format("<%03d: %s >",this.numero,this.nombre);
    }
}

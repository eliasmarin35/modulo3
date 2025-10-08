/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.interfaces.logica;

/**
 *
 * @author jprof
 */
public record Alumno(int num, String nombre) implements Imprimible {
    
    @Override
    public String toString() {
        return String.format("<%d: %s >", this.num, this.nombre);
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }
    
}

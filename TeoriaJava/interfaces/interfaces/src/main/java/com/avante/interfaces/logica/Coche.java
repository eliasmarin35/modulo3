/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.interfaces.logica;

/**
 *
 * @author jprof
 */
public record Coche(
        String duenyo,
        String matricula,
        int velocidadMaxima
        )
        implements Imprimible {

    public String toString() {
        return String.format("Coche de %s, con matricula %s y vel. max.=%d.",
                this.duenyo,
                this.matricula,
                this.velocidadMaxima
        );
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

}

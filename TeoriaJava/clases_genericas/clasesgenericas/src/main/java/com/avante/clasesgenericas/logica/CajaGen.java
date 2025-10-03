/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.clasesgenericas.logica;

/**
 *
 * @author jprof
 */
public class CajaGen<T> {
    private T contenido = null;
    
    public CajaGen () {}
    
    public CajaGen( T c ) {
        this.contenido = c;
    }
    
    public T getContenido() {
        return this.contenido;
    }
    
    public void setContenido( T c ) {
        this.contenido = c;
    }
    
    @Override
    public String toString () {
        return this.contenido.toString();
    }
}

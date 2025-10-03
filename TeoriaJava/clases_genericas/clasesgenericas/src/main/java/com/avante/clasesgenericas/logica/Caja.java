/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.clasesgenericas.logica;

/**
 *
 * @author jprof
 */
public class Caja {
    private Object contenido = null;
    
    public Caja () {}
    
    public Caja ( Object o ) {
        this.contenido = o;
    }
    
    public Object getContenido() {
        return this.contenido;
    }
    
    public void setContenido ( Object o ) {
        this.contenido = o;
    }
    
    @Override
    public String toString () {
        return this.contenido.toString();
    }
}

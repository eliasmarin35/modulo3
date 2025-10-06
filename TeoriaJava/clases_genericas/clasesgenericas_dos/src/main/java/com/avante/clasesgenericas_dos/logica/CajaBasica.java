/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.clasesgenericas_dos.logica;

/**
 *
 * @author jprof
 */
public class CajaBasica {
    private Object contenido;
    
    public Object getContenido () {
        return this.contenido;
    }
    
    public void setContenido (Object c) {
        this.contenido = c;
    }
    
    @Override
    public String toString() {
        return String.format("CAJA: %s", this.contenido);
    }
}

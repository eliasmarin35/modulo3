/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.clasesgenericas.logica;

/**
 *
 * @author jprof
 */
public class CajaGen2<X,Y> {
    private X contenido1 = null;
    private Y contenido2 = null;
    
    public CajaGen2 () {}
    
    public X getContenido1() {
        return this.contenido1;
    }
    
    public Y getContenido2() {
        return this.contenido2;
    }
    
    public void setContenido1( X c ) {
        this.contenido1 = c;
    }
    
    public void setContenido2( Y c ) {
        this.contenido2 = c;
    }
}

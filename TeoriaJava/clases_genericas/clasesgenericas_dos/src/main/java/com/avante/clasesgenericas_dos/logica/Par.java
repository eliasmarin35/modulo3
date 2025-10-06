/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.clasesgenericas_dos.logica;

/**
 *
 * @author jprof
 */
public class Par<C,V> {
    private C clave;
    private V valor;
    
    // Getters
    public C getClave() {
        return this.clave;
    }
    
    public V getValor() {
        return this.valor;
    }
    
    // Setters
    public void setClave ( C clave_parametro ) {
        this.clave = clave_parametro;
    }
    
    public void setValor ( V valor_parametro ) {
        this.valor = valor_parametro;
    }
    
    public void setClaveValor (C clave_parametro, V valor_parametro) {
        this.setClave(clave_parametro);
        this.setValor(valor_parametro);
    }
    
    // Override del toString
    @Override
    public String toString () {
        return String.format(
            """
            Par[
                clave:
                    %s
                valor:
                    %s
            ]
            """,
            this.clave,
            this.valor
        );
    }
}

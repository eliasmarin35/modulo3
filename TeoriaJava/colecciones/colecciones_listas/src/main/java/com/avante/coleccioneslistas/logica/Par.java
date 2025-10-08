/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.coleccioneslistas.logica;

/**
 *
 * @author jprof
 */
public class Par<K,V> {
    private K clave;
    private V valor;
    
    public Par(K c, V v) {
        this.clave = c;
        this.valor = v;
    }
    
    @Override
    public String toString ( ) {
        return String.format("<%s: %s >", this.clave, this.valor);
    }

    /**
     * @return the clave
     */
    public K getClave() {
        return clave;
    }

    /**
     * @return the valor
     */
    public V getValor() {
        return valor;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(K clave) {
        this.clave = clave;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(V valor) {
        this.valor = valor;
    }
    
    
    
}

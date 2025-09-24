/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.veterinaria;

/**
 * Esta clase representa un gato
 * 
 * @author Juan Manuel
 */
public class Gato extends Animal {
    
    /**
     * Este metodo saluda al perro usando su nombre
     */
    @Override
    public void saludo() {
        System.out.println("Hola gato "+ this.getNombre());
    }
    
    /**
     * Este método saluda al perro usando su diminutivo
     */
    @Override
    public void saludoDiminutivo() {
        System.out.println("Hola gatito "+ this.obtenerDiminutivo());
    }
    
    /**
     * Este método devuelve un maullido
     */
    @Override
    public void habla() {
        System.out.println("MIAU!!");
    }
}

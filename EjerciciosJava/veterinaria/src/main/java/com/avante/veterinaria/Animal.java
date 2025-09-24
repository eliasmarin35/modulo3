/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.veterinaria;

/**
 * Esta clase representa un animal
 * 
 * @author Juan Manuel
 */
public abstract class Animal {
    /**
     * El nombre del animal
     */
    private String nombre="[NOMBRE POR DEFECTO]";
    
    /**
     * El getter del nombre
     * 
     * @return El nombre que tiene el animal
     */
    public String getNombre () {
        return this.nombre;
    }
    
    /**
     * El setter del nombre
     * 
     * @param nombre El nombre que queremos darle al animal.
     */
    public void setNombre (String nombre) {
        if (nombre == null) {
            throw new Error("El nombre no puede ser null");
        }
        
        // El método de la clase String strip() 
        //    elimina los espacios que pueda
        //    haber delante o detrás del texto.
        nombre = nombre.strip();
        
        if ( nombre == "" ) {
            throw new Error("El nombre no puede estar vacío.");
        }
        
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el diminutivo del nombre añadiendole "ito"
     * 
     * @return El diminutivo del nombre acabado en "ito" 
     */
    protected String obtenerDiminutivo () {
        return this.nombre + "ito";
    }
    
    /**
     * Imprime por pantalla un saludo con el nombre del
     *     animal.
     */
    public void saludo() {
        System.out.println("Hola animal "+ this.nombre +".");
    }
    
    /**
     * Imprime por pantalla un saludo con el nombre del
     *     animal en diminutivo.
     */
    public void saludoDiminutivo() {
        System.out.println("Hola animalito "+ this.obtenerDiminutivo() +".");
    }
    
    /**
     * Imprime por pantalla la forma de hablar del animal.
     */
    public abstract void habla();
}

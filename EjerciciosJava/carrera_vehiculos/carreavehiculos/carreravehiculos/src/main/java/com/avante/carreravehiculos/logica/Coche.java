/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.carreravehiculos.logica;

/**
 *
 * @author jprof
 */
public class Coche extends Vehiculo {
    // ==== ATRIBUTOS DE LA CLASE ====
    
    // Velocidades mínimas y máximas expresadas en metros por iteración
    private static final int MIN_VEL = 0;
    private static final int MAX_VEL = 0;
    
    // ==== CONSTRUCTOR ===
    /**
     * LLama la constructor de la clase padre que lo hace todo
     * @param nombre 
     */
    public Coche (String nombre) {
        super(nombre);
    }
    
    // ==== METODOS OVERRIDE ===
    /**
     * 
     * @return la velocidad minima del vehiculo concreto
     */
    @Override
    public int getMinVel() {
            return Coche.MIN_VEL;
    };
    
    /**
     * 
     * @return la velocidad máxima del vehículo concreto
     */
    @Override
    public int getMAxVel() {
            return Coche.MAX_VEL;
    };
}

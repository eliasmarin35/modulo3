/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.carreravehiculos.logica;

/**
 *
 * @author jprof
 */
public class Bicicleta extends Vehiculo {
    // ==== ATRIBUTOS DE LA CLASE ====
    
    // Velocidades mínimas y máximas expresadas en metros por iteración
    private static final int MIN_VEL = 5;
    private static final int MAX_VEL = 10;
    private static final String TIPO = "bicicleta";
    
    // ==== CONSTRUCTOR ===
    /**
     * LLama la constructor de la clase padre que lo hace todo
     * @param nombre 
     */
    public Bicicleta (String nombre) {
        super(nombre);
    }
    
    // ==== METODOS OVERRIDE ===
    /**
     * 
     * @return la velocidad minima del vehiculo concreto
     */
    @Override
    public int getMinVel() {
            return Bicicleta.MIN_VEL;
    };
    
    /**
     * 
     * @return la velocidad máxima del vehículo concreto
     */
    @Override
    public int getMAxVel() {
            return Bicicleta.MAX_VEL;
    };
    
    /**
     * Obtiene el tipo de vehiculo en forma de texto
     * @return el tipo de vehículo
     */
    @Override
    protected String getTipoVehiculo() {
        return Bicicleta.TIPO;
    }
}

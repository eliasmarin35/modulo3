/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.carreravehiculos.logica;

import java.util.Random;

/**
 *
 * @author jprof
 */
public abstract class Vehiculo {
    // ==== ATRIBUTOS =====
    
    /**
     * velocidad del vehiculo en metros por iteracion
     */
    private int velocidad;
    
    /**
     * nombre del jugador que utiliza el vehiculo
     */
    private String jugador;
    
    /**
     * posicion en la carrera
     */
    private int posicion = 0;
    
    /**
     * Distancia del recorrido de la carrera en metros.
     */
    private static int DISTANCIA_TOTAL=100;
            
            
    // ==== METODOS CONSTRUCTOR =====
    
    /**
     * dara valores a los atributos
     * para la velocidad habra que usar otro metodo que la calcule.
     */
    protected Vehiculo (String nombre) {
        this.jugador = nombre;
        this.velocidad = this.calculaVelocidad();
    }
    
    
    // ==== METODOS ====
    /**
     * Calcula la velocidad fija del vehiculo
     * Sera un numero aleatorio entre la velocidad minima y maxima de la clase
     *     concreta.
     * 
     * @return la velocidad fija expresada en metros por iteracion
     */
    private int calculaVelocidad () {
        int min = this.getMinVel();
        int max = this.getMAxVel();
        
        Random rng = new Random();
        
        return rng.nextInt(min, max);
    } 
    
    /**
     * 
     * @return la velocidad minima del vehiculo concreto
     */
    public abstract int getMinVel();
    
    /**
     * 
     * @return la velocidad máxima del vehículo concreto
     */
    public abstract int getMAxVel();
    
    // ==== METODOS ESTATICOS ====
    public static void setDistanciaTotal (int distancia) {
        Vehiculo.DISTANCIA_TOTAL = distancia;
    }
    
}

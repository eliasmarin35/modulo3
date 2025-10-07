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
    private static int DISTANCIA_TOTAL=-1;
            
            
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
    
    /**
     * Avanza una iteración y nos dice si ha acabado la carrera.
     * @return si ha finalizado la carrera
     */
    public boolean avanza() {
        boolean fin = false;
        
        if ( ! this.esFinalizado() ) {
            this.posicion = this.posicion + this.velocidad;
            
            // imprimimos por pantalla donde estamos
            this.imprimePosicion();
            
            fin = this.esFinalizado();
            
            if (fin) {
                this.imprimeFinalizado();
            }
        }
        
        return fin; 
    }
    
    /**
     * Indica si el vehiculo ha finalizado la carrera
     * @return si ha finalizado la carrera
     */
    private boolean esFinalizado () {
        return this.posicion >= Vehiculo.DISTANCIA_TOTAL;
    }
    
     /**
     * Imprime por pantalla la posicion del vehiculo.
     */
    protected void imprimePosicion() {
        System.out.printf(
            "----> El %s de %s ha llegado a %d metros.\n",
            this.getTipoVehiculo(),
            this.jugador,
            this.posicion
        );
    }
    
    /**
     * Imprime por pantalla que el vehiculo ha finalizado
     */
    protected void imprimeFinalizado() {
        System.out.printf(
            "\t\t====> El %s de %s ha finalizado la carrera.\n",
            this.getTipoVehiculo(),
            this.jugador
        );
    }
    
    /**
     * Obtiene una cadena de texto con el tipo de vehiculo
     * @return texto que representa el tipo de vehiculo
     */
    protected abstract String getTipoVehiculo();
    
    /**
     * Devuelve el nombre del jugador
     * @return el nombre del jugador
     */
    public String getNombre() {
        return this.jugador;
    }
    
   
    // ==== METODOS ESTATICOS ====
    /**
     * Establecer la distancia del recorrido de la carrera
     * @param distancia la distancia en metros
     */
    public static void setDistanciaTotal (int distancia) {
        Vehiculo.DISTANCIA_TOTAL = distancia;
    }
    
}

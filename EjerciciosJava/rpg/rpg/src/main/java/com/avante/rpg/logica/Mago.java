/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.rpg.logica;

/**
 *
 * @author Juan Manuel
 */
public class Mago extends Personaje {
    
    private static final String PROFESION = "MAGO";
    private static final int ATAQUE = 8;
    private static final int DEFENSA = 2;
    
    public Mago(String nombre) {
        super(nombre);
    }

    /**
     * Este método devuelve la profesión del Mago
     * 
     * @return la profesión del Mago 
     */
    @Override
    public String getProfesion() {
        return Mago.PROFESION;
    }

    @Override
    protected int getAtaque() {
        return Mago.ATAQUE;
    }

    @Override
    protected int getDefensa() {
        return Mago.DEFENSA;
    }
    
}

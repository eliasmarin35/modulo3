/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.rpg.logica;

/**
 *
 * @author Juan Manuel
 */
public class Guerrero extends Personaje{
    private static final String PROFESION = "GUERRERO";
    private static final int ATAQUE = 5;
    private static final int DEFENSA = 8;
    
    public Guerrero(String nombre) {
        super(nombre);
    }
    
    /**
     * Método que devuelve la profesión del Guerrero
     * 
     * @return la profesión del Guerrero
     */
    @Override
    public String getProfesion () {
        return Guerrero.PROFESION;
    }
    
    @Override
    protected int getAtaque() {
        return Guerrero.ATAQUE;
    }

    @Override
    protected int getDefensa() {
        return Guerrero.DEFENSA;
    }
}

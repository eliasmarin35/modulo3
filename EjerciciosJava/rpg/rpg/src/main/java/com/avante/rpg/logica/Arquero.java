/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.rpg.logica;

/**
 *
 * @author JUan Manuel
 */
public class Arquero extends Personaje{
    private static final String PROFESION = "ARQUERO";
    private static final int ATAQUE = 6;
    private static final int DEFENSA = 4;
    
    public Arquero(String nombre) {
        super(nombre);
    }
    
    /**
     * Método que devuelve la profesión del Guerrero
     * 
     * @return la profesión del Guerrero
     */
    @Override
    public String getProfesion () {
        return Arquero.PROFESION;
    }
    
    @Override
    protected int getAtaque() {
        return Arquero.ATAQUE;
    }

    @Override
    protected int getDefensa() {
        return Arquero.DEFENSA;
    }
}

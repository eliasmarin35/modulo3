/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.veterinaria;

/**
 *
 * @author Juan Manuel
 */
public class Veterinaria {

    public static void main(String[] args) {
        // Instanciamos un gato y un perro
        Animal miPerro = new Perro();
        Gato miGato = new Gato();
        
        // Le damos nombre al perro
        miPerro.setNombre("Bobby");
        
        // Imprimimos por pantalla el nombre del perro
        miPerro.saludo();
        
        // Imprimimos por pantalla el nombre del perro en diminutivo
        miPerro.saludoDiminutivo();
        
        // Imprimimos el nombre del gato
        miGato.saludo();
        
        // Hacemos hablar al perro y al gato
        miPerro.habla();
        miGato.habla();
    }
}
